package com.security.security_auth.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import lombok.extern.log4j.Log4j2;

@Configuration
@Log4j2
public class SecurityConfig {
//password encoder bean

     @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    } 



    //Security configuration bean
    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{

        http.authorizeHttpRequests(authRequest ->{
           // authRequest.anyRequest().authenticated();

            authRequest.anyRequest().hasRole("ADMIN");
        }).formLogin(Customizer.withDefaults());


        return http.build();

    }


    //In-Memory Authentication function
    /* 
     @Bean
    public UserDetailsService users(){
        UserDetails admin=User.builder()
        .username("admin")
        .password("{bcrypt}$2a$10$GRLdNijSQMUvl/au9ofL.eDwmoohzzS7.rmNSJZ.0FxO/BTk76klW")
        .roles("ADMIN")
        .build();
        log.info("the password of admin is: --> {}",admin.getPassword());
        
        UserDetails user=User.builder()
        .username("user")
        .password("{bcrypt}$2a$10$GRLdNijSQMUvl/au9ofL.eDwmoohzzS7.rmNSJZ.0FxO/BTk76klW")
        .roles("USER")
        .build();
        return new InMemoryUserDetailsManager(user ,admin);

    }*/
 



}
