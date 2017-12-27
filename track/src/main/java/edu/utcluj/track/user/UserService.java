package edu.utcluj.track.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * created by Covrig Bogdan
 **/
@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public User findByEmailAndPassword(String username, String password){
        return userRepository.findByUsernameAndPassword(username,password);
    }

    public User register(String username, String password) {
        User u = new User();
        if(userRepository.findByUsername(username) == null) {
            u.setUsername(username);
            u.setPassword(password);
            return userRepository.save(u);
        }else return null;

    }
}
