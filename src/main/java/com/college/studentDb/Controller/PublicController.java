package com.college.studentDb.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.college.studentDb.Entity.user;
import com.college.studentDb.Service.userService;

@RestController
@RequestMapping("/public")
public class PublicController {

	  @Autowired
	  private userService userservice; 
	
	  @PostMapping("/create-user")
	  public boolean insert(@RequestBody user usr){
		  userservice.insert(usr);
		  return true;
	  }
}
