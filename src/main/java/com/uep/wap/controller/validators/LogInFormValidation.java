package com.uep.wap.controller.validators;

import com.uep.wap.configs.WebSecurityConfig;
import com.uep.wap.controller.helpers.UserLogIn;
import com.uep.wap.model.UserProfile;
import com.uep.wap.service.UserProfileService;
import org.apache.commons.validator.routines.EmailValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class LogInFormValidation implements Validator {

    private EmailValidator emailValidator = EmailValidator.getInstance();

    @Autowired
    private UserProfileService userProfileService;

    @Autowired
    private WebSecurityConfig securityConfig;

    // The classes are supported by this validator.
    @Override
    public boolean supports(Class<?> clazz) {
        return clazz == UserLogIn.class;
    }

    @Override
    public void validate(Object target, Errors errors) {
        UserLogIn user = (UserLogIn) target;
        PasswordEncoder encoder = securityConfig.passwordEncoder();
        // Check the fields of userProfileDTO.
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "NotEmpty.userProfileDTO.email");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty.userProfileDTO.password");

        if (!this.emailValidator.isValid(user.getEmail())) {
            // Invalid email.
            errors.rejectValue("email", "Pattern.userProfileDTO.email");
        }

        UserProfile dbUserByEmail = userProfileService.findUserByEmail(user.getEmail());
        if (dbUserByEmail == null) {
            // Email is not used
            errors.rejectValue("email", "Duplicate.UserLogIn.email");
        }
        else {
            String existing_password = dbUserByEmail.getPassword();
            if (!encoder.matches(user.getPassword(), existing_password)) {
                errors.rejectValue("password", "Similarity.UserLogIn.password");
            }
            else if (encoder.matches(user.getPassword(), existing_password)) {
                user.setPassword(encoder.encode(user.getPassword()));
            }
        }
    }
}
