package edu.duke.summer.client.config;


import edu.duke.summer.client.controller.AuthenticationController;
import edu.duke.summer.client.controller.LoginSuccessHandler;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    UserDetailsService userDetailsService;

//    @Autowired
//    DataSource dataSource;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.jdbcAuthentication()
//                .dataSource(dataSource)
//                .usersByUsernameQuery("select username,password,enabled from myuser where username=?")
//                .authoritiesByUsernameQuery("select username,authority from authorities where username=?");
        auth.userDetailsService(userDetailsService);
    }

    /**
     * Settings for authorization
     * using HttpSecurity to setup roles for each
     */

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/user").hasAnyRole("USER","ADMIN")
                .antMatchers("/admin").hasRole("ADMIN")
                .and()
                .formLogin()
                .successHandler(loginSuccessHandler);
    }

    /**
     * This is a special Component extends method of
     * onAuthenticationSuccess
     * that will be used by HttpSecurity....formLogin().successHandler();
     */
    @Autowired
    private LoginSuccessHandler loginSuccessHandler;

    /**
     * Gets the PasswordEncoder for springframework.security.
     * <p>
     * This method was used by springframework.security to encode string password into 60 length encoded string.
     * @return
     */
    @Bean
    public PasswordEncoder getPasswordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }


}
