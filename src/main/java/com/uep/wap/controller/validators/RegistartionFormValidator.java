package com.uep.wap.controller.validators;

import com.uep.wap.configs.WebSecurityConfig;
import com.uep.wap.dto.UserProfileDTO;
import com.uep.wap.model.UserProfile;
import com.uep.wap.service.UserProfileService;
import org.apache.commons.validator.routines.EmailValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;


@Component
public class RegistartionFormValidator implements Validator {

    // common-validator library.
    private EmailValidator emailValidator = EmailValidator.getInstance();

    @Autowired
    private UserProfileService userProfileService;

    @Autowired
    private WebSecurityConfig securityConfig;


    // The classes are supported by this validator.
    @Override
    public boolean supports(Class<?> clazz) {
        return clazz == UserProfileDTO.class;
    }

    @Override
    public void validate(Object target, Errors errors) {
        UserProfileDTO user = (UserProfileDTO) target;

        // Check the fields of userProfileDTO.
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "NotEmpty.userProfileDTO.name");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "surname", "NotEmpty.userProfileDTO.surname");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "NotEmpty.userProfileDTO.username");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "NotEmpty.userProfileDTO.email");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty.userProfileDTO.password");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "confirmedPassword", "NotEmpty.userProfileDTO.confirmedPassword");

        if (!this.emailValidator.isValid(user.getEmail())) {
            // Invalid email.
            errors.rejectValue("email", "Pattern.userProfileDTO.email");
        }

        UserProfile dbUserByemail = userProfileService.findUserByEmail(user.getEmail());
        if (dbUserByemail != null) {
            // Email has been used by another account.
            errors.rejectValue("email", "Duplicate.userProfileDTO.email");
        }

        if (!errors.hasFieldErrors("username")) {
            UserProfile dbUserByUsername = userProfileService.findByUsername(user.getUsername());
            if (dbUserByUsername != null) {
                // Username is not available.
                errors.rejectValue("username", "Duplicate.userProfileDTO.userName");
            }
        }

        if (!errors.hasErrors()) {
            if (!user.getConfirmedPassword().equals(user.getPassword())) {
                errors.rejectValue("confirmedPassword", "Match.userProfileDTO.confirmedPassword");
            }
        }
    }

}
