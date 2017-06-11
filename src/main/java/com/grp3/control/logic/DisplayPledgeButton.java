package com.grp3.control.logic;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.grp3.logic.helpers.IPledgeHelper;
import com.grp3.logic.helpers.IProjectHelper;
import com.grp3.models.Project;
import com.grp3.models.User;
import com.grp3.services.IUserSecurityService;

@Component
public class DisplayPledgeButton implements IDisplayPledgeButton {
	
	@Autowired
	private IUserSecurityService _userSecServ;
	
	@Autowired
	private IPledgeHelper _pledgeHelper;
	
	@Autowired
	private IProjectHelper _projectHelper;
	
	@Override
	public boolean display(Project proj) {
		User user = _userSecServ.getLoggedInUser();
		
		boolean loggedCheck = (user != null);
		boolean projFinishedCheck = !_projectHelper.isProjectFinished(proj);
		boolean projCancCheck = !proj.getCancelled();
		boolean creditCheck = false;
		boolean userNotOwnerCheck = false;
		if(loggedCheck) {
			creditCheck = _pledgeHelper.userCanPledge(user, new BigDecimal(1));
			userNotOwnerCheck = (user.getUserId() != proj.getUser().getUserId());
		}
		
		return (loggedCheck && projFinishedCheck && projCancCheck && creditCheck && userNotOwnerCheck);
	}
}
