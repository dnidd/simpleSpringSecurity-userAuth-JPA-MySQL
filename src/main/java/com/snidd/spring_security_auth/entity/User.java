package com.snidd.spring_security_auth.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

/**
 * User entity and DB table.
 */
@Entity
@Table(name = "users")
@Getter
@Setter
public class User {

    // PK
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String email;
}
