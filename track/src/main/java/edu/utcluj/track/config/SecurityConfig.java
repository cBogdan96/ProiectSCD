//package edu.utcluj.track.config;
//
///**
// * created by Covrig Bogdan
// **/
//import edu.utcluj.track.user.DetailsService;
//import edu.utcluj.track.user.User;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Primary;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.stereotype.Component;
//import javax.sql.DataSource;
///**
// * Created by JavaDeveloperZone on 04-08-2017.
// */
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//
//import javax.sql.DataSource;
//
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//
//    @Autowired
//    @Qualifier( "datasource")
//    private DataSource dataSource;
//
////    @Autowired
////    private CustomAuthenticationSuccessHandler customAuthenticationSuccessHandler;
//
//
//    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//        auth
//                .jdbcAuthentication()
//                .dataSource(dataSource)
//                .usersByUsernameQuery("select username, password from user where username = ?")
//                .authoritiesByUsernameQuery("select username, role from user where username = ?")
//                .rolePrefix("ROLE_");
//        //.passwordEncoder(new ShaPasswordEncoder());
//    }
//
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//                .csrf()
//                .disable()
//                .authorizeRequests()
//                .antMatchers("/js/**","/img/**","/user/login").permitAll()
//                .anyRequest().hasAnyRole("USER")
//                .and()
//                .formLogin()
//                .loginPage("/index.html")
//                .permitAll()
//                .and()
//                .logout()
//                .permitAll();
//
//
//        // http.csrf().disable().authorizeRequests().anyRequest().permitAll();
//    }
//
//}
