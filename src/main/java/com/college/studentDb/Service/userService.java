package com.college.studentDb.Service;


import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.college.studentDb.Entity.user;
import com.college.studentDb.Repository.UserRepo;


@Service
public class userService {
	
	private static final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(); 
	
	private static final Logger logger = LoggerFactory.getLogger(userService.class);
    
	@Autowired
	private  UserRepo userrepo;
	
	public List<user> get() {
		
		return userrepo.findAll();
	}

	public boolean insert(user usr) {
		try {
			usr.setPassWord(passwordEncoder.encode(usr.getPassWord()));
			usr.setRoles(Arrays.asList("USER"));
			userrepo.save(usr);
			return true;
		    }catch(Exception e) {
		    	logger.error("logger testing"+e);
		    	return false;
		}
	}
	
	public void insertAdmin(user usr) {
		usr.setPassWord(passwordEncoder.encode(usr.getPassWord()));
		usr.setRoles(Arrays.asList("USER" , "Admin"));
		userrepo.save(usr);
	}

	public void saveUser(user usr) {
		userrepo.save(usr);
	}
	
	
	public user findByuser(String usr) {
		return userrepo.findByUserName(usr);
	}

	public List<user> getAll() {
		return userrepo.findAll();
	}
}
