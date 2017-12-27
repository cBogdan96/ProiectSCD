package edu.utcluj.track.user;

import edu.utcluj.track.position.Position;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * created by Covrig Bogdan
 **/
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

//    @RequestMapping(method = RequestMethod.POST,value = "/login")
//    public User readPositionFromTerminal(@RequestBody User user) {
////        if (userService.findByEmailAndPassword(user.getUsername(), user.getPassword()) != null) {
//            if( userService.findByEmailAndPassword(user.getUsername(), user.getPassword()) !=null){
//                return user;
//            } else {
//            user = null;
//            return user;
//        }
//
//    }

    @RequestMapping(method = RequestMethod.POST,value = "/login")
    public ResponseEntity<User> getUser(@RequestBody User user) {

        if (userService.findByEmailAndPassword(user.getUsername(), user.getPassword()) !=null) {
            return new ResponseEntity<User>(user, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/register")
    public User register(final String email, final String password) {

        return userService.register(email, password);
    }
}