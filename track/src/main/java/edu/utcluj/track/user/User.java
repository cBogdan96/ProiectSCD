package edu.utcluj.track.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * created by Covrig Bogdan
 **/

@Entity
public class User {
    @Id
    @GeneratedValue
    @ApiModelProperty(hidden = true)
    private Long id;

    @NotNull
    @Column(name= "email")
    @Size(min = 4, message = " username must have at least 4 characters")
    private String email;

    @NotNull
    @Column(name= "password")
    @Size(min = 4, message = " password must have at least 4 characters")
    private String password;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
