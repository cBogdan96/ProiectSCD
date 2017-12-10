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


    @Query("SELECT u from User u where u.email= :email AND u.password = :password")
    User findByEmailAndPassword(@Param("email") String email, @Param("password") String password);

    User findByEmail(String email);
}
