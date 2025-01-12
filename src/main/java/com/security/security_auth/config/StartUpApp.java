package com.security.security_auth.config;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.security.security_auth.entity.User;
import com.security.security_auth.service.UserService;

import lombok.RequiredArgsConstructor;
@Component
@RequiredArgsConstructor
public class StartUpApp implements ApplicationRunner{
private final  UserService userService;
    @Override
    public void run(ApplicationArguments args)  throws Exception {

       if (userService.count()==0) {

        User user1=new User(null, "Ahmed", "ahmed", "12345", "ADMIN");
        User user2=new User(null, "Aser", "aser", "123", "USER");

            userService.insert(user1);
            userService.insert(user2);

            
        } 
        
    }
}
