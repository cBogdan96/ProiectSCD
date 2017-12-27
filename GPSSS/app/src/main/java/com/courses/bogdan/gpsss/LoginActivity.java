package com.courses.bogdan.gpsss;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import android.provider.Settings.Secure;

/**
 * Created by Bogdan on 12/18/2017.
 */

public class LoginActivity extends Activity implements View.OnClickListener {

    Button loginButton;
    EditText username , password;
    private String android_id ;

    private Executor executor = Executors.newFixedThreadPool(1);
    private volatile Handler msgHandler;
    private Intent login;

    private static final String STATIC_USER = "{" +
            "\"username\":\"%s\"," +
            "\"password\":\"%s\"" +
            "}";

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginButton = (Button) findViewById(R.id.loginButton);

        username  = (EditText) findViewById(R.id.emailLogin);
        password = (EditText) findViewById(R.id.passwordLogin);


        loginButton.setOnClickListener(this);

        msgHandler = new MsgHandler(this);



    }

    @Override
    public void onClick(View v) {
        executor.execute(new Runnable() {
            public void run() {
                Message msg = msgHandler.obtainMessage();
//                msg.arg1 = verifyUser( "bogdan@yahoo.com", "bogdan") ? 1 : 0;
                String user = String.valueOf(username .getText());
                String pass = String.valueOf(password.getText());
                msg.arg1 = verifyUser( user, pass) ? 1 : 0;
                msgHandler.sendMessage(msg);
                if (msg.arg1 == 1) {

                    login  = new Intent(getApplicationContext(),MainActivity.class);
                   startActivity(login);
                }

            }
        });
    }



    private boolean verifyUser( String username, String password) {
        HttpURLConnection con = null;
        try {
            URL obj = new URL("http://192.168.1.5:8085/user/login");
            con = (HttpURLConnection) obj.openConnection();
            con.setRequestMethod("POST");
            con.setRequestProperty("User-Agent", "Mozilla/5.0");
            con.setRequestProperty("Content-Type", "application/json; charset=UTF-8");

            con.setDoOutput(true);
            OutputStream os = con.getOutputStream();
            os.write(String.format(STATIC_USER,username,password).getBytes());
            os.flush();
            os.close();

            int responseCode = con.getResponseCode();

            if (responseCode == HttpURLConnection.HTTP_OK) { //success



                BufferedReader in = new BufferedReader(new InputStreamReader(
                        con.getInputStream()));
                String inputLine;
                StringBuilder response = new StringBuilder();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }

                in.close();

                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            if (con != null) {
                con.disconnect();
            }
        }
    }


    private static class MsgHandler extends Handler {
        private final WeakReference<Activity> sendActivity;

        public MsgHandler(Activity activity) {
            sendActivity = new WeakReference<>(activity);
        }

        public void handleMessage(Message msg) {
            if (msg.arg1 == 1) {
                Toast.makeText(sendActivity.get().getApplicationContext(),
                        "Success!", Toast.LENGTH_LONG).show();



            } else {
                Toast.makeText(sendActivity.get().getApplicationContext(),
                        "incorrect username or password!", Toast.LENGTH_LONG).show();
            }
        }
    }
}
