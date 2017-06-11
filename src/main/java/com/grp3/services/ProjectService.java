package com.grp3.services;

import java.util.List;

import org.joda.time.DateTime;
import org.joda.time.Days;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.grp3.logic.helpers.IProjectHelper;
import com.grp3.models.Pledge;
import com.grp3.models.Project;
import com.grp3.repositories.IProjectRepository;

@Service
public class ProjectService implements IProjectService {
	
	@Autowired
	private IProjectRepository _repo;
	
	@Autowired
	private IPledgeService _pledgeServ;
	
	@Autowired
	private IProjectHelper _projHelper;

	@Override
	public Page<Project> getAllProjects(Pageable pageable) {
		return _repo.findAll(pageable);
	}

	@Override
	public List<Project> getAllProjects() {
		return _repo.findAll();
	}

	@Override
	public Project getProject(Long id) {
		return _repo.findOne(id);
	}

	@Override
	public void updateProjectsStatus() {
		List<Project> projects = _repo.findAll();
		List<Pledge> pledgesToDeactivate = _projHelper.updateProjectsStatus(projects);
		_repo.save(projects);
		_pledgeServ.cancelPledges(pledgesToDeactivate);
	}

	@Override
	public int getDaysLeft(Project proj) {
		if(proj.getCancelled() || proj.getCompleted()) {
			return 0;
		}
		return Days.daysBetween(new DateTime(), new DateTime(proj.getFinishTime())).getDays();
	}

	@Override
	public void save(Project proj) {
		_repo.save(proj);
		
	}

	@Override
	public void cancelProject(Project proj) {
		if(proj.getCompleted()) {
			return;
		}
		proj.setCancelled(true);
		_pledgeServ.cancelPledges(proj.getPledges());
		_repo.save(proj);
		
	}
}
