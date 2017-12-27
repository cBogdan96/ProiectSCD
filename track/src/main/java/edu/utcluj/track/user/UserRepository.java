package edu.utcluj.track.user;

import edu.utcluj.track.position.Position;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

/**
 * created by Covrig Bogdan
 **/
public interface UserRepository extends JpaRepository<User, Long> {


    @Query("SELECT u from User u where u.username= :username AND u.password = :password")
    User findByUsernameAndPassword(@Param("username") String username, @Param("password") String password);

    User findByUsername(String email);
}
