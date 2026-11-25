package com.snidd.spring_security_auth.repository;

import com.snidd.spring_security_auth.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);
}
