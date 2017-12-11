package edu.utcluj.track.user;

import edu.utcluj.track.position.Position;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.text.ParseException;
import java.util.List;

/**
 * created by Covrig Bogdan
 **/
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(method = RequestMethod.POST)
    public boolean readPositionFromTerminal(final String email, final String password) {
        if(userService.findByEmailAndPassword(email,password)!=null){
            return true;
        }else{
            return false;
        }

    }

    @RequestMapping(method = RequestMethod.PUT, value = "/register")
    public User register(final String email, final String password) {

        return userService.register(email,password);
    }
}
