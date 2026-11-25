package com.snidd.spring_security_auth.service;

import com.snidd.spring_security_auth.dto.UserDTO;
import com.snidd.spring_security_auth.entity.User;
import com.snidd.spring_security_auth.model.AuthenticatedUser;
import com.snidd.spring_security_auth.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


/**
 * Service to handle user logic.
 */
@Service
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }


    /**
     * Create User entity to be stored.
     * Encode/hash password.
     * @param userDTO user dto.
     * @return saved user.
     */
    public User register(UserDTO userDTO) {
        System.out.println("Request body: " +  userDTO);

        User u = new User();
        u.setEmail(userDTO.getEmail());
        u.setUsername(userDTO.getUsername());
        u.setPassword(passwordEncoder.encode(userDTO.getPassword()));

        return userRepository.save(u);
    }


    /**
     * Load  by the username from store/DB.
     * @param username the username identifying the user whose data is required.
     * @return authenticated user.
     * @throws UsernameNotFoundException e.
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User u = userRepository.findByUsername(username);
        AuthenticatedUser authenticatedUser = new AuthenticatedUser(u);
        return authenticatedUser;
    }


}
