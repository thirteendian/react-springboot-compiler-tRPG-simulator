package edu.duke.summer.server.config;


import edu.duke.summer.server.controller.LoginSuccessHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    /**
     * A Configuration of Spring Security
     * <p>
     *     Security Process contains two part:
     *     <ul>
     *         <li>Authentication(configured by AuthenticationMangerBuilder)</li>
     *         <li>Authorization(configured by HttpSecurity)</li>
     *     </ul>
     * </p>
     */
    @Autowired
    UserDetailsService userDetailsService;

    /**
     * Gets the PasswordEncoder for springframework.security.
     * <p>
     * This method was used by springframework.security to encode string password into 60 length encoded string.
     * @return
     */
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    /**
     * <p>
     *     AUTHENTICATION
     *     submit form->
     *     <ul>
     *         <li>UsernamePasswordAuthenticationFilter-></li>
     *         <li>UsernamePasswordAuthenticationToken-></li>
     *         <li>AuthenticationManager-></li>
     *         <li>User Info Storage</li>
     *         <li>Fail->AuthenticationFailureHandler</li>
     *         <li>Success->SecurityContextHolder-></li>
     *         <li>InteractiveAuthenticationSuccessEvent-></li>
     *         <li>AuthenticationSuccessHandler(saved by ExceptionTranslationFilter)</li>
     *     </ul>
     * </p>
     * @param auth
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

    /**
     * Settings for authorization
     * using HttpSecurity to setup roles for each
     * <p>
     *     AUTHORIZATION
     *     Unauthenticated Requests->
     *     <ul>
     *         <li>FilterSecurityInterceptor-></li>
     *         <li>ExceptionTranslationFilter(throw AccessDeniedException) -></li>
     *         <li>AuthenticationEntryPoint(render login page ***HttpSecurity.formLogin())</li>
     *     </ul>
     * </p>
     */

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/user/**").hasRole("USER")
                .antMatchers("/index_after_login").hasAnyRole("USER","ADMIN")
                .antMatchers("/admin").hasRole("ADMIN")

                //Logout delete Cookies
                .and()
                .logout()
                .deleteCookies("JSESSIONID")
                .logoutSuccessUrl("/")

                .and()
                .rememberMe().rememberMeParameter("remember-me")
                .key("uniqueAndSecret")
                .tokenValiditySeconds(86400)//valid for a day


                .and().formLogin(
                        form->form.loginPage("/login")
                                .permitAll()
                                .defaultSuccessUrl("/")
                                .failureUrl("/login.html?error=true")
                )
                ;
    }


    /**
     * This is a special Component extends method of
     * onAuthenticationSuccess
     * that will be used by HttpSecurity....formLogin().successHandler();
     */
    @Autowired
    private LoginSuccessHandler loginSuccessHandler;



}
