package com.kozlov.service;


import com.kozlov.dao.UserDAOImpl;
import com.kozlov.entity.GrantedAuthorityImpl;
import com.kozlov.entity.UserEntity;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Formatter;


@Service("customAuthenticationProvider")
public class CustomAuthenticationProvider implements AuthenticationProvider {
    private static final Logger LOGGER = Logger.getLogger(CustomAuthenticationProvider.class);
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String name = authentication.getName();
        LOGGER.info(new Formatter().format("authenticate method user %s", name));
        String password = authentication.getCredentials().toString();
        UserEntity userEntity = new UserDAOImpl().getUserByName(name);
        boolean bp;
        if (userEntity != null) {
            bp = passwordEncoder.matches(password, userEntity.getPassword());
            if (!bp) {
                return null;
            }
        } else {
            return null;
        }
        ArrayList<GrantedAuthorityImpl> role = new ArrayList<>();
        role.add(new GrantedAuthorityImpl(userEntity.getRole()));
        return new UsernamePasswordAuthenticationToken(authentication.getPrincipal(),
                authentication.getCredentials(),
                role);
    }


    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}
