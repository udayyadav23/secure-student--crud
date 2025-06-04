package com.college.studentDb.Service;


import java.util.List;
import java.util.Optional;

import javax.management.RuntimeErrorException;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.college.studentDb.Entity.studentDetails;
import com.college.studentDb.Entity.user;
import com.college.studentDb.Repository.StudentRepository;

@Service
public class studentService {
      
	  @Autowired
	  private StudentRepository studentrepository;
	  
	  @Autowired
	  private userService userservice;
	
	  @Transactional
	  public void insertData(studentDetails std, String username) {
		  try {user usr = userservice.findByuser(username); 
		  studentDetails student = studentrepository.save(std);
		  usr.getStd().add(student);
		 
		  userservice.saveUser(usr);}
		  catch(Exception e){
			  System.out.print(e);
			  throw new RuntimeException("An Error has been occured ", e);
		  }
		 
	  }

	public List<studentDetails> getData() {
		return studentrepository.findAll();
	}
	
	public Optional<studentDetails> findById(ObjectId id){
		return studentrepository.findById(id);
	}
	
	
	@Transactional
	public boolean deleteById(ObjectId id, String username) {
		boolean remove = false;
		try {
		user usr = userservice.findByuser(username);
		remove = usr.getStd().removeIf(x -> x.getId().equals(id));
		if(remove) {
			userservice.saveUser(usr);
			studentrepository.deleteById(id);
		   }
		}catch(Exception e) {
			System.out.println(e);
			throw new RuntimeException("Id not found"+id);
		}
		return remove;
	}

	public void insertData(studentDetails old) {
		studentrepository.save(old);
		
	}
	
}
