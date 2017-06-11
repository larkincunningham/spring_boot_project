package com.grp3.control.logic;

import org.springframework.stereotype.Component;

import com.grp3.models.Project;

@Component
public class ProjectCancelable {

	public boolean isCancelable(Project proj) {
		return (!proj.getCancelled() && !proj.getCompleted());
	}
}
