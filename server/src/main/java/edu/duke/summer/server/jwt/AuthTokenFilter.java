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
            return headerAuth.substring(7, headerAuth.length());
        }

        return null;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        try {
            //get JWT from header(Removing Bearer prefix)
            String jwt = parseJwt(request);
            //If has JWT
            if (jwt != null && jwtUtils.validateJwtToken(jwt)) {
                //parse username
                String username = jwtUtils.getUserNameFromJwtToken(jwt);
                //get UserDetails from username
                UserDetails userDetails = userDetailsService.loadUserByUsername(username);
                //create Authentication Object
                UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null,
                        userDetails.getAuthorities());
                authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                //Set Authentication method to be Authentication
                SecurityContextHolder.getContext().setAuthentication(authentication);
                //========NOW IF ONE WANT TO GET USERDETAILS:=================
                // use SecurityContext:
                //UserDetails userDetails = (UserDetails) SecurityContextHolder
                // .getContext().getAuthentication().getPrincipal()
                //========AND THEN USE THEM==============
                // userDetails.getUsername()
                // userDetails.getPassword()
                // userDetails.getAuthorities()
            }
        } catch (Exception e) {
            logger.error("Cannot set user authentication: {}", e.getMessage());
        }

        filterChain.doFilter(request, response);
    }
}
