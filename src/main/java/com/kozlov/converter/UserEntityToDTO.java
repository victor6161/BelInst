package com.kozlov.converter;

import com.kozlov.dto.UserDTO;
import com.kozlov.entity.UserEntity;
import org.springframework.core.convert.converter.Converter;

import java.io.UnsupportedEncodingException;

/**
 * конвертер  entity к dto  для user.
 */
public class UserEntityToDTO implements Converter<UserEntity, UserDTO> {
    public UserDTO convert(UserEntity userEntity) {
        UserDTO userDTO = null;
        userDTO = new UserDTO();

        userDTO.setLogin(userEntity.getName());
        userDTO.setPassword(userEntity.getPassword());
        userDTO.setEmail(userEntity.getEmail());
        return userDTO;
    }
}
