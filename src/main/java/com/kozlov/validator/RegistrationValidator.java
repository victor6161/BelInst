package com.kozlov.validator;


import com.kozlov.dao.UserDAOImpl;
import com.kozlov.dto.UserDTO;
import com.kozlov.entity.UserEntity;
import org.apache.commons.validator.routines.EmailValidator;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import java.util.List;

/**
 * валидатор для регистрации.
 */
public class RegistrationValidator implements Validator {

    public boolean supports(Class<?> aClass) {
        return UserDTO.class.isAssignableFrom(aClass);
    }

    private final int maxLenth = 7;

    public void validate(Object o, Errors errors) {
        UserDTO user = (UserDTO) o;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "login", "login.empty",
                "Поле логин не должно быть пустым");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "password.empty",
                "Password must not be empty.");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "fullName", "full_name.empty");
        List<UserEntity> userList = new UserDAOImpl().getList(UserEntity.class);
        for (UserEntity userEntity : userList) {
            if (userEntity.getName().equals(((UserDTO) o).getLogin())) {
                errors.rejectValue("login", "login.exists",
                        "login already exists.");
            }
        }

        if ((user.getPassword().length()) < maxLenth) {
            errors.rejectValue("confirmPassword", "confirmPassword.tooShort",
                    "Password is too short.");
        }
        if (!(user.getPassword()).equals(user.getConfirmPassword())) {
            errors.rejectValue("confirmPassword", "confirmPassword.passwordDontMatch",
                    "Passwords don't match.");
        }

        if (!EmailValidator.getInstance().isValid(user.getEmail())) {
            errors.rejectValue("email", "email.notValid",
                    "Email address is not valid.");
        }
    }
}
