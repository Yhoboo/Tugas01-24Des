package com.yhoboo.challenge3.config;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;

@Component
public class CustomSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

    private RedirectStrategy redirectStrategy;
    private final static String BackEnd = "BE";
    private final static String FrontEnd = "FE";

    protected void handle(HttpServletRequest request, HttpServletResponse response, Authentication authentication)throws IOException, ServletException{

    }

    protected String determineTargetUrl(Authentication authentication){
        String url = "";
        Collection<? extends GrantedAuthority> grantedAuthorities = authentication.getAuthorities();
        String role = "";
        url = "/user";
        return url;
    }
}
