package com.bradend.ExamBelt.validators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.bradend.ExamBelt.models.User;
import com.bradend.ExamBelt.services.UserService;


@Component
public class UserValidator implements Validator {
	
	@Autowired
	private UserService userServ;

	@Override
	public boolean supports(Class<?> clazz) {
		return User.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
        User user = (User) target;
        
        // CHECK TO SEE IF CONFIRM PASSWORD AND PASSWORD MATCH
        if (!user.getPasswordConfirmation().equals(user.getPassword())) {
            errors.rejectValue("passwordConfirmation", "Match");
        }
        
        // CHECK FOR UNIQUE EMAIL
        if(userServ.findByEmail(user.getEmail()) != null) {
            errors.rejectValue("email", "Duplicate");
        }
        
	}
}
