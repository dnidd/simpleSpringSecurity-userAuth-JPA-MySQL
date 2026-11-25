package com.snidd.spring_security_auth.model;

import com.snidd.spring_security_auth.entity.User;
import org.jspecify.annotations.Nullable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

/**
 * Class defines a Spring Security User.
 * Represents an authenticated user.
 */
public class AuthenticatedUser implements UserDetails {

    private User user;

    public AuthenticatedUser(User user) {
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    @Override
    public @Nullable String getPassword() {
        return  user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }
}
