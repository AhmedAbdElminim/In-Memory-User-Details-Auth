package com.security.security_auth.service;

import java.util.Optional;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.security.security_auth.entity.User;
import com.security.security_auth.repository.UserRepo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepo userRepo;
    private final PasswordEncoder passwordEncoder;

    public long count(){
        return userRepo.count();
    }

    public Optional<User>findByUserName(String userName){

        return userRepo.findByUserName(userName);
    }

    public User insert(User user){

        
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        return userRepo.save(user);
    }
}
