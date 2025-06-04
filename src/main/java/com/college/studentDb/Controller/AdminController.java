package com.college.studentDb.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.college.studentDb.Entity.user;
import com.college.studentDb.Service.userService;



@RestController
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private userService userservice ;
	
	
	@GetMapping("/all-users")
	public ResponseEntity<?> getAllUsers(){
		List<user> users = userservice.getAll();
		if(users != null && !users.isEmpty()) {
			return new ResponseEntity<>(users , HttpStatus.FOUND);
		}
		return new ResponseEntity<>( HttpStatus.NOT_FOUND);
	}
	
	@PostMapping("/create-admin-user")
	public ResponseEntity<?> createAdmin(@RequestBody user userData){
		userservice.insertAdmin(userData);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
