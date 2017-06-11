package com.grp3.logic.factories;

import com.grp3.control.forms.PledgeForm;
import com.grp3.control.forms.ProjectForm;
import com.grp3.control.forms.UserForm;
import com.grp3.models.Pledge;
import com.grp3.models.Project;
import com.grp3.models.User;

/**
 ********************************************************************
 * Interface which consists of factory methods for building domain models off their relevant forms
 *
 * @author Kyle Williamson
 * @version 1.0.0
 ********************************************************************
 */
public interface IFormsToModelsFactory {

	/**
	 * Create a user model object from a UserForm
	 * 
	 * @param userForm form representing a new user to create
	 * 
	 * @return newly created user model
	 */
	public User userFormToUser(UserForm userForm);
	
	/**
	 * Create a project model object from a ProjectForm
	 * 
	 * @param projectForm form representing a new project to create
	 * 
	 * @return newly created project model
	 */
	public Project projectFormToProject(ProjectForm projectForm);
	
	
	/**
	 * Create a plage model object from a PledgeForm
	 * 
	 * @param pledgeForm form representing a new pledge to create
	 * 
	 * @return newly created pledge model
	 */
	public Pledge pledgeFormToPledge(PledgeForm pledgeForm);
}
