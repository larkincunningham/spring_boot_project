package com.grp3.services;

import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.grp3.models.User;
import com.grp3.repositories.IRoleRepository;
import com.grp3.repositories.IUserRepository;

@Service
public class UserService implements IUserService {
	
	@Autowired
	private IUserRepository _userRepo;
	
	@Autowired
	private IRoleRepository _roleRepo;
	
	@Autowired
	private BCryptPasswordEncoder _pwEncoder;

	@Override
	public void save(User user) {
		user.setPassword(_pwEncoder.encode(user.getPassword()));
		user.setRoles(new HashSet<>(_roleRepo.findAll()));
		_userRepo.save(user);
	}

	@Override
	public User findByUsername(String username) {
		return _userRepo.findBy_userName(username);
	}
	
	@Override
	public User findByEmail(String email) {
		return _userRepo.findBy_email(email);
	}

}
