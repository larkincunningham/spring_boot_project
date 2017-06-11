package com.grp3.logic.helpers;

import java.util.List;

import com.grp3.models.Pledge;
import com.grp3.models.Project;

/**
 ********************************************************************
 * Interface which provides helper functionality for the project domain
 *
 * @author Kyle Williamson
 * @version 1.0.0
 ********************************************************************
 */
public interface IProjectHelper {

	/**
	 * Check to see if the given project is finished (in terms of time, not goal)
	 * 
	 * @param proj Project to check if finished
	 * @return boolean representing true = finished, false = not finished
	 */
	boolean isProjectFinished(Project proj);
	
	/**
	 * Update a list of project objects cancelled and completed fields 
	 * 
	 * @param projects List of projects to update
	 * @return List of pledges which need to be updated due to project changes.
	 */
	List<Pledge> updateProjectsStatus(List<Project> projects);
}
