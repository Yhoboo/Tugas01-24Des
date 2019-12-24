package com.yhoboo.challenge3.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

public class SecurityServiceImpl implements SecurityService{

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Override
    public String findLoggedInUsername() {
        Object userDetails = SecurityContextHolder.getContext().getAuthentication().getDetails();
        if(userDetails instanceof UserDetails){
            return ((UserDetails)userDetails).getUsername();
        }
        return null;
    }


    @Override
    public void autoLogin(String username, String password) {
        UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        UsernamePasswordAuthenticationToken usrPassAuthToken= new UsernamePasswordAuthenticationToken(userDetails, password,userDetails.getAuthorities());
        authenticationManager.authenticate(usrPassAuthToken);

        if (usrPassAuthToken.isAuthenticated()){
            SecurityContextHolder.getContext().setAuthentication(usrPassAuthToken);
        }
    }
}
