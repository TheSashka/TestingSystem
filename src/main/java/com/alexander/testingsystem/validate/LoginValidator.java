package com.alexander.testingsystem.validate;

import com.alexander.testingsystem.dao.UserDAOJDBCTemplateImpl;
import com.alexander.testingsystem.model.User;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class LoginValidator implements Validator {

    private final String STRING_PATTERN = "[a-zA-Z]+";
    private Pattern pattern;
    private Matcher matcher;
    private UserDAOJDBCTemplateImpl userDAOJDBCTemplate;

    public boolean supports(Class<?> aClass) {
        return false;
    }

    public void validate(Object o, Errors errors) {
        User user = (User) o;
        userDAOJDBCTemplate = new UserDAOJDBCTemplateImpl();
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "login", "required.login",
                "login is required.");

        if(userDAOJDBCTemplate.checkLoginAndPassword(user.getLogin(), user.getPassword()) == 0)
        {
            errors.rejectValue("login", "Login or Password incorrect");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password",
                "required.password", "Password is required.");

    }
}
