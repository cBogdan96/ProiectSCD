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

    public User findByEmailAndPassword(String email, String password){
        return userRepository.findByEmailAndPassword(email,password);
    }

    public User register(String email, String password) {
        User u = new User();
        if(userRepository.findByEmail(email) == null) {
            u.setEmail(email);
            u.setPassword(password);
            return userRepository.save(u);
        }else return null;

    }
}
