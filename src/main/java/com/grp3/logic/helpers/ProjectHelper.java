package com.grp3.logic.helpers;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.grp3.logic.calculators.IPledgeCalculator;
import com.grp3.models.Pledge;
import com.grp3.models.Project;

/**
 ********************************************************************
 * Standard implementation of the IProjectHelper interface.
 *
 * @author Kyle Williamson
 * @version 1.0.0
 ********************************************************************
 */
@Component
public class ProjectHelper implements IProjectHelper {
	
	@Autowired
	private IPledgeCalculator _pledgeCalc;

	@Override
	public boolean isProjectFinished(Project proj) {
		return new Timestamp(System.currentTimeMillis()).after(proj.getFinishTime());
	}

	@Override
	public List<Pledge> updateProjectsStatus(List<Project> projects) {
		List<Pledge> pledgesToDeactivate = new ArrayList<Pledge>();
		for(Project proj : projects) {
			BigDecimal totalPledged = _pledgeCalc.calculatePledgeAmount(proj.getPledges());
			if(isProjectFinished(proj)) {
				if(totalPledged.compareTo(proj.getGoalAmount()) < 0) {
					pledgesToDeactivate.addAll(proj.getPledges());
					proj.setCancelled(true);
					proj.setCompleted(false);
				} else {
					proj.setCancelled(false);
					proj.setCompleted(true);
				}
			}
		}
		return pledgesToDeactivate;
	}
	
}
