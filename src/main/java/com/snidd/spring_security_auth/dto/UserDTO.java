package com.snidd.spring_security_auth.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * User Dto.
 */
@Getter
@Setter
public class UserDTO {
    private String username;
    private String password;
    private String email;
}
