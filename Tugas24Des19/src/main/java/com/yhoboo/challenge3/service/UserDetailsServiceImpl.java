package com.yhoboo.challenge3.service;

import com.yhoboo.challenge3.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
//        System.out.println("get nul........"+s);
        UserEntity user = userService.findByName(s);
        List<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>();
//        System.out.println("get nulss........"+user.getFullName());
        grantedAuthorities.add(new SimpleGrantedAuthority(user.getFullName()));


        return new User(String.valueOf(user.getUserId()), user.getPassword(), grantedAuthorities);
    }
}
