package edu.duke.summer.server.jwt;

import edu.duke.summer.server.service.impl.MyUserDetailsServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * This filter will execute once per request(thus extends OncePerRequestFilter)
 * refer to Spring Security, Basic Authentication
 */
public class AuthTokenFilter extends OncePerRequestFilter {
    @Autowired
    private JwtUtils jwtUtils;

    @Autowired
    private MyUserDetailsServiceImpl userDetailsService;

    private static final Logger logger = LoggerFactory.getLogger(AuthTokenFilter.class);

    /**
     * Help Function
     */
    private String parseJwt(HttpServletRequest request) {
        String headerAuth = request.getHeader("Authorization");
        if (StringUtils.hasText(headerAuth) && headerAuth.startsWith("Bearer ")) {
            return headerAuth.substring(7, headerAuth.length());//remove "Bearer "
        }
        return null;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        try {
            //get JWT from header(Removing Bearer prefix)
            String jwt = parseJwt(request);
            //If has JWT, and authentication is successful, then success
            if (jwt != null && jwtUtils.validateJwtToken(jwt)) {
                //parse username
                String username = jwtUtils.getUserNameFromJwtToken(jwt);
                //DATABASE get UserDetails from username
                UserDetails userDetails = userDetailsService.loadUserByUsername(username);
                /*
                 * Create Authentication Object
                    Constructor(Object principal,Object credentials, Collection<? extends GrantedAuthority> authorities)
                 * The principal that the authentication Manager will look depends on user info storage where is
                     MyUserDetailsImpl by MyUserDetailsServiceImpl
                 * The AuthenticationManager is configured by AuthenticationManagerBuilder in securityConfig
                 */
                UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null,
                        userDetails.getAuthorities());
                authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                //The Authentication is set on the SecurityContextHolder
                SecurityContextHolder.getContext().setAuthentication(authentication);
                //RememberMeServices.loginSuccess if set
                /* Now one can get userdetails in securityContext:
                 * Examples:
                  UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal()
                 */
            }
            //If authentication fails, then Failure
        } catch (Exception e) {
            logger.error("Cannot set user authentication: {}", e.getMessage());
        }
        //BasicAuthenticationFilter invokes FilterChain.doFilter(request,response)
        filterChain.doFilter(request, response);
    }
}
