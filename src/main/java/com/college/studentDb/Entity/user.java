package com.college.studentDb.Entity;

import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.mongodb.lang.NonNull;

@Document(collection = "user")
public class user {
	
	@Id
	private ObjectId id;
	
	
	@Indexed(unique = true)
	@NonNull
	private String userName;
	
	@NonNull
	private String passWord ;
	
	@DBRef
	private List<studentDetails> std = new ArrayList<>();
	
	private List<String> roles = new ArrayList<>();
	

	public List<String> getRoles() {
		return roles;
	}

	public void setRoles(List<String> roles) {
		this.roles = roles;
	}

	public List<studentDetails> getStd() {
		return std;
	}

	public void setStd(List<studentDetails> std) {
		this.std = std;
	}

	public ObjectId getId() {
		return id;
	}

	public void setId(ObjectId id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	} 
	
	
	

}
