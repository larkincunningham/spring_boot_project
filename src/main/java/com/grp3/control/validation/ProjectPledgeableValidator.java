package com.grp3.control.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.grp3.logic.helpers.IPledgeHelper;
import com.grp3.models.Project;
import com.grp3.services.IProjectService;

/**
 ********************************************************************
 * Custom hibernate validator that checks if a project is pledgeable
 *
 * @author Kyle Williamson
 * @version 1.0.0
 ********************************************************************
 */
@Component
public class ProjectPledgeableValidator implements ConstraintValidator<ProjectPledgeable, Long> {
	
	@Autowired
	private IProjectService _projServ;
	
	@Autowired 
	private IPledgeHelper _pledgeHelper;

	@Override
	public void initialize(ProjectPledgeable constraintAnnotation) {
	}

	@Override
	public boolean isValid(Long value, ConstraintValidatorContext context) {
		Project proj = _projServ.getProject(value);
		return _pledgeHelper.projectPledgeable(proj);
	}

}
