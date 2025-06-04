package com.college.studentDb.Controller;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.college.studentDb.Entity.studentDetails;
import com.college.studentDb.Entity.user;
import com.college.studentDb.Service.studentService;
import com.college.studentDb.Service.userService;

@RestController
@RequestMapping("/student")
public class studentData {

	@Autowired
	private studentService studentservice;
	
	
	@Autowired
	private userService userservice;
	
	@GetMapping
	public ResponseEntity<?> getDetails() {
		
		Authentication authentication =  SecurityContextHolder.getContext().getAuthentication();
		String username = authentication.getName();
		user usr = userservice.findByuser(username);
		List<studentDetails> std  =  usr.getStd();
		if(std != null && !std.isEmpty()) {
			return new ResponseEntity <>(std , HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@PostMapping
	public ResponseEntity<?> putDetails(@RequestBody  studentDetails std) {
		try {
		Authentication authentication =  SecurityContextHolder.getContext().getAuthentication();
		String username = authentication.getName();
		std.setDate(LocalDateTime.now());
		studentservice.insertData(std , username);
		return new ResponseEntity<>(HttpStatus.CREATED);
		}catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	

	@GetMapping("/id/{myId}")
	public ResponseEntity<studentDetails> getById(@PathVariable ObjectId myId) {
		Authentication authentication =  SecurityContextHolder.getContext().getAuthentication();
		String username = authentication.getName();
		user user = userservice.findByuser(username);
		List<studentDetails> sd = user.getStd().stream().filter(x -> x.getId().equals(myId)).collect(Collectors.toList());
		if(!sd.isEmpty()) {
			Optional<studentDetails> std = studentservice.findById(myId);
			if(std.isPresent()) {
				return new ResponseEntity<>(std.get() , HttpStatus.OK);
			}
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
	}
	
	
	@DeleteMapping("/id/{myId}")
	public ResponseEntity<?> deleteData(@PathVariable ObjectId myId) {
		Authentication authentication =  SecurityContextHolder.getContext().getAuthentication();
		String username = authentication.getName();
		boolean removed = studentservice.deleteById(myId , username);
		if(removed)
		     return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		else
			 return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@PutMapping("id/{myId}")
	public ResponseEntity<?> updateData(@RequestBody studentDetails newstd, @PathVariable ObjectId myId) {
		Authentication authentication =  SecurityContextHolder.getContext().getAuthentication();
		String username = authentication.getName();
		user user = userservice.findByuser(username);
		List<studentDetails> sd = user.getStd().stream().filter(x -> x.getId().equals(myId)).collect(Collectors.toList());
		if(!sd.isEmpty()) {
			Optional<studentDetails> std = studentservice.findById(myId);
			if(std.isPresent()) {
				studentDetails old = std.get();
				old.setDesc(old.getDesc() != null && !old.getDesc().equals("") ? newstd.getDesc() :old.getDesc());
				old.setName(old.getName() != null && !old.getName().equals("")? newstd.getName() : old.getName() );
				studentservice.insertData(old);
				return new ResponseEntity<>(old , HttpStatus.OK);
			}
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	
	
}
