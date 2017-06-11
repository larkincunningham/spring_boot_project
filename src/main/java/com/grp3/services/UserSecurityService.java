package com.grp3.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grp3.models.User;

@Service
public class UserSecurityService implements IUserSecurityService {
	
	@Autowired
	private ISecurityService _secService;
	
	@Autowired
	private IUserService _userService;

	@Override
	public User getLoggedInUser() {
		return _userService.findByUsername(_secService.findLoggedInUsername());
	}

}
