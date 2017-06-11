package com.grp3.control.validation;

import java.math.BigDecimal;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.grp3.logic.helpers.IPledgeHelper;
import com.grp3.models.User;
import com.grp3.services.IUserSecurityService;

/**
 ********************************************************************
 * Custom hibernate validator that checks if a user is able to make a pledge
 *
 * @author Kyle Williamson
 * @version 1.0.0
 ********************************************************************
 */
@Component
public class UserCanPledgeValidator implements ConstraintValidator<UserCanPledge, BigDecimal> {
	
	@Autowired
	private IUserSecurityService _userSecServ;
	
	@Autowired
	private IPledgeHelper _pledgeHelper;

	@Override
	public void initialize(UserCanPledge constraintAnnotation) {	
	}

	@Override
	public boolean isValid(BigDecimal value, ConstraintValidatorContext context) {
		User loggedInUser = _userSecServ.getLoggedInUser();
		return _pledgeHelper.userCanPledge(loggedInUser, value);
	}

}
