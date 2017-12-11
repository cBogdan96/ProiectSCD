/**
 * Created with IntelliJ IDEA.
 * User: radu.miron
 * Date: 12/2/15
 * Time: 10:45 AM
 * To change this template use File | Settings | File Templates.
 */
function checkUser() {
    var criteria = new Criteria();
    sendRequest("POST", "user?" + $.param(criteria), null, getUserSuccessHandler, getUserErrorHandler);
    // sendRequest("GET", "user?" + $.param(criteria), null, getUserSuccessHandler, getUserErrorHandler);
}

function Criteria() {
    var email = $('#email_modal').val().trim(); // select data from input and trim it
    if (email.length > 0) {
        this.email = email;
    }

    var password = $('#password_modal').val().trim(); // select data from input and trim it
    if (password.length > 0) {
        this.password = password;
    }
}

function getUserSuccessHandler(respData) {
    var rData = JSON.stringify(respData);
    if(rData == true){
       goToPage('map.html')
    }else{
        goToPage('index.html')
    }
    // $("#result").append("<br>" + JSON.stringify(respData));
    //$("#result").text(respData); // appends the json to the 'result' div. see index.html
}

function getUserErrorHandler(status) {
    alert("err response: " + status); // popup on err.
}