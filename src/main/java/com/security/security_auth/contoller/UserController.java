package com.security.security_auth.contoller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/")
public class UserController {

    @GetMapping("/home")
    public String getMethodName() {
        return "Hello world";
    }
}
