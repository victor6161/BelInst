package com.kozlov.entity;


import org.springframework.security.core.GrantedAuthority;


/**
 * для получения прав пользователя.
 */
public class GrantedAuthorityImpl implements GrantedAuthority {
    private String role;

    public GrantedAuthorityImpl(String role) {
        this.role = role;
    }

    @Override
    public String getAuthority() {
        return role;
    }
}
