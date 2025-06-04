package com.college.studentDb.Service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.college.studentDb.Entity.user;
import com.college.studentDb.Repository.UserRepo;


@Component
public class UserDetailsServiceImpl implements UserDetailsService{
	
	@Autowired
	private UserRepo userrepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		user user = userrepo.findByUserName(username);
		if(user != null) {
			return org.springframework.security.core.userdetails.User.builder()
					.username(user.getUserName())
					.password(user.getPassWord())
					.roles(user.getRoles().toArray(new String[0]))
					.build();
		}
		throw new UsernameNotFoundException("user not found with username"+username);
	}

}
