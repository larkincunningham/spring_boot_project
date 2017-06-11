package com.grp3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.grp3.models.User;
import com.grp3.services.IUserService;

@Component
public class UserInitialsier implements CommandLineRunner {
	
	@Autowired
	private IUserService _userServ;

	@Override
	public void run(String... arg0) throws Exception {
		User user = _userServ.findByUsername("kyle");
		_userServ.save(user);
		
	}
}
