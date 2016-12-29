package com.kozlov.converter;

import com.kozlov.dto.UserDTO;
import com.kozlov.entity.UserEntity;
import org.springframework.core.convert.converter.Converter;

public class UserDtoToEntity implements Converter<UserDTO, UserEntity> {

    @Override
    public UserEntity convert(UserDTO userDTO) {
        UserEntity userEntity = new UserEntity();
        userEntity.setName(userDTO.getLogin());
        userEntity.setPassword(userDTO.getPassword());
        userEntity.setEmail(userDTO.getEmail());
        userEntity.setRole("ROLE_USER");
        userEntity.setFullName(userDTO.getFullName());
        return userEntity;

    }
}
