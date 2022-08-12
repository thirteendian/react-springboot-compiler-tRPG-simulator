package edu.duke.summer.server.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.WebAttributes;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * See SecurityConfig
 * Spring Security saved the URL prior to login and redirect to the user back to that URL
 * upon successful authentication
 */
@Component
public class LoginSuccessHandler implements AuthenticationSuccessHandler {

    protected Log logger = LogFactory.getLog(this.getClass());
    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();


    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        String targetUrl = getUrlOfRole(authentication);
        if(response.isCommitted()){
            logger.debug("Response has already been committed. Unable to redirect to "+ targetUrl);
            return;
        }
        redirectStrategy.sendRedirect(request,response,targetUrl);
        HttpSession session = request.getSession(false);
        if(session == null){
            return;
        }
        session.removeAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
    }

    protected String getUrlOfRole(final Authentication authentication){
        Map<String, String> urlOfRole = new HashMap<>();
        urlOfRole.put("ROLE_USER","/main");
        urlOfRole.put("ROLE_ADMIN","/admin_main");
        final Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        for(final GrantedAuthority grantedAuthority : authorities){
            String authorityName = grantedAuthority.getAuthority();
            if(urlOfRole.containsKey(authorityName)){
                return urlOfRole.get(authorityName);
            }
        }
        throw new IllegalStateException();
    }
}
