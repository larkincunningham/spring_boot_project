package com.grp3.logic.helpers;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.grp3.logic.calculators.IPledgeCalculator;
import com.grp3.models.Project;
import com.grp3.models.User;

/**
 ********************************************************************
 * Standard implementation of IPledgeHelper
 *
 * @author Kyle Williamson
 * @version 1.0.0
 ********************************************************************
 */
@Component
public class PledgeHelper implements IPledgeHelper {
	
	@Autowired
	private IProjectHelper _projHelper;
	
	@Autowired
	private IPledgeCalculator _pledgeCalc;

	@Override
	public boolean projectPledgeable(Project project) {
		return (!project.getCancelled() && !_projHelper.isProjectFinished(project));
	}

	@Override
	public boolean userCanPledge(User user, BigDecimal amountToPledge) {
		BigDecimal availAmount = _pledgeCalc.calculateAvailableAmountToPledge(user);
		return (availAmount.compareTo(amountToPledge) >= 0);
	}

	@Override
	public boolean pledgeCancelableForProject(Project project) {
		return (project.getCancelled() || (!_projHelper.isProjectFinished(project) && !project.getCancelled()));
	}

}
