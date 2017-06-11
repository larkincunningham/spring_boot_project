package com.grp3.control.validation;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.grp3.services.IUserService;


/**
 ********************************************************************
 * Custom hibernate validator that checks if an email is already taken
 * 
 *
 * @author Joel Satkauskas
 * @version 1.0.0
 ********************************************************************
 */
@Component
public class RegistrationEmailValidator implements ConstraintValidator<ValidEmail, String> {
	
	@Autowired
	private IUserService _userServ;
	
	@Override
	public void initialize(ValidEmail constraintAnnotation) {
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		if (_userServ.findByEmail(value) == null)
		{
			return true;
		}
		return false;
	}

}
