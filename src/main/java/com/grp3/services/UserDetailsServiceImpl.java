package com.grp3.services;

import java.util.HashSet;
import java.util.Set;

import org.springframework.transaction.annotation.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.grp3.models.Role;
import com.grp3.models.User;
import com.grp3.repositories.IUserRepository;

/**
 ********************************************************************
 * Implementation of the SpringSecurity provided interface UserDetailsService
 *
 * @author Kyle Williamson
 * @version 1.0.0
 ********************************************************************
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	private IUserRepository _userRepo;

    @Override
    @Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = _userRepo.findBy_userName(username);
		
		Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
		for(Role role: user.getRoles()) {
			grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
		}
		return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(), grantedAuthorities);
	}

}
