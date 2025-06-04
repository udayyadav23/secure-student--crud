package com.college.studentDb.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.DeleteMapping;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.college.studentDb.Entity.user;
import com.college.studentDb.Repository.UserRepo;
import com.college.studentDb.Service.userService;

@RestController
@RequestMapping("/user")
public class UserController {
	  
	  @Autowired
	  private userService userservice; 
	  
	  
	  @Autowired
	  private  UserRepo userrepo;
	 
	  
	  @PutMapping
	  public ResponseEntity<?> update(@RequestBody user usr) {
		 Authentication authentication =  SecurityContextHolder.getContext().getAuthentication();
		 String username = authentication.getName();
		 user us = userservice.findByuser(username);
		 us.setPassWord(usr.getPassWord());
		 us.setUserName(usr.getUserName());
		 userservice.insert(us);
		 return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	  }
	  
	  @DeleteMapping
	  public ResponseEntity<?> delete() {
		 Authentication authentication =  SecurityContextHolder.getContext().getAuthentication();
		 userrepo.deleteByUserName(authentication.getName());
		 return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	  }

}
