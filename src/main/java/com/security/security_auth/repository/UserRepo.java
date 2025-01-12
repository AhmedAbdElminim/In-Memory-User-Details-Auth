package com.security.security_auth.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.security.security_auth.entity.User;

@Repository
public interface UserRepo extends JpaRepository<User,Long>{
    Optional<User>findByUserName(String userName);

}
