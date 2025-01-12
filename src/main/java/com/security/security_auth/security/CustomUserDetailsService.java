package com.security.security_auth.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.security.security_auth.entity.User;
import com.security.security_auth.service.UserService;


@Service
public class CustomUserDetailsService implements UserDetailsService{
    @Autowired
    private  UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User>user=userService.findByUserName(username);
        user.orElseThrow(() -> new UsernameNotFoundException("User not found with username: " + username));


        return new CustomUserDetails(user.get().getUserName(), user.get().getPassword(), "ROLE_"+user.get().getRole());
    }

}
