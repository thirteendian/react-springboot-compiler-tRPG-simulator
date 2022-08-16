package edu.duke.summer.server.config;


import edu.duke.summer.server.controller.LoginSuccessHandler;
import edu.duke.summer.server.jwt.AuthEntryPointJwt;
import edu.duke.summer.server.jwt.AuthTokenFilter;
import edu.duke.summer.server.service.impl.MyUserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;

@Configuration
@EnableWebSecurity
//enables @PreAuthorize, @PostAuthorize
//supports JSR-250
@EnableGlobalMethodSecurity(
        // securedEnabled = true,
        // jsr250Enabled = true,
        prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    /**
     * Following two will Help DaoAuthenticationProvider in AuthenticationManager to validate
     * UsernamePasswordAuthenticationToken
     */
    @Autowired
    MyUserDetailsServiceImpl myUserDetailsService;

    @Autowired
    private AuthEntryPointJwt unauthorizedHandler;

    @Bean
    public AuthTokenFilter authenticationJwtTokenFilter() {
        return new AuthTokenFilter();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /**
     * Will UserDetailsServer to build Authentication object
     * with the help of PasswordEncoder
     * <p>
     * First, after API(with login request) entering, OncePerRequestFilter will use
     * doFilterInternal() to load Userdetail(help of UserDetailsService)
     * <p>
     * Second, will use UsernamePasswordAuthenticationToken to get {password,username} from login request
     * and authenticate an account
     * <p>
     * Third, will use DaoAuthenticationProvider to valid UsernamePasswordAuthenticationToken
     * return Authentication object
     * <p>
     * Fourth, AuthenticationEntryPoint catch unauthorized error and return 401
     *
     * @param auth build AuthenticationManager
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(myUserDetailsService).passwordEncoder(passwordEncoder());
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        final CorsConfiguration config = new CorsConfiguration();

        config.setAllowedOrigins(Arrays.asList("http://localhost:3000"));
        config.setAllowedMethods(Arrays.asList("GET", "POST", "OPTIONS", "DELETE", "PUT", "PATCH"));
        config.setAllowCredentials(true);
        config.setAllowedHeaders(Arrays.asList("Authorization", "Cache-Control", "Content-Type"));

        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", config);

        return source;
    }

    /**
     * @param http HttpSecurity, used for configure "cors", "csrf","session management" and "authorization"
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http    //config cors
                .cors()
                //config csrf
                .and()
                .csrf().disable()
                .exceptionHandling().authenticationEntryPoint(unauthorizedHandler)


                .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)


                .and()
                .authorizeRequests().antMatchers("/api/auth/**").permitAll()
                .antMatchers("/api/test/**").permitAll()
                .antMatchers("/user/**").permitAll()
                .anyRequest().authenticated();
//                .and()
//                .authorizeRequests()
//                .antMatchers("/").permitAll()
//                .anyRequest().authenticated()
//                .antMatchers("/user/**").hasRole("USER")
//                .antMatchers("/index_after_login").hasAnyRole("USER","ADMIN")
//                .antMatchers("/admin").hasRole("ADMIN")

        //Logout delete Cookies
//                .and()
//                .logout()
//                .deleteCookies("JSESSIONID")
//                .logoutSuccessUrl("/")
//
//                .and()
//                .rememberMe().rememberMeParameter("remember_me")
//                .key("uniqueAndSecret")
//                .tokenValiditySeconds(86400)//valid for a day
//                .and().formLogin(
//                        form->form.loginPage("/login")
//                                .permitAll()
//                                .defaultSuccessUrl("/")
//                                .failureUrl("/login.html?error=true")
//                )
        ;
        http.addFilterBefore(authenticationJwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);
    }


//    /**
//     * This is a special Component extends method of
//     * onAuthenticationSuccess
//     * that will be used by HttpSecurity....formLogin().successHandler();
//     */
//    @Autowired
//    private LoginSuccessHandler loginSuccessHandler;


}
