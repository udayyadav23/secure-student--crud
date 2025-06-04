package com.college.studentDb.Service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class serviceTests {

	@Autowired
	private userService userservice;
	
	@ParameterizedTest
	 @CsvSource({
		 "Naga",
		 "Uday",
		 "Lalitha",
		 "udveg"
	 })
	public void findByUserNameTest(String user) {
		assertNotNull(userservice.findByuser(user),"failed for " + user);
	}
	 @ParameterizedTest
	 @CsvSource({
		 "1,1,2",
		 "2,2,4",
		 "5,5,5"
	 })
	@Disabled
     public void test( int a , int b  , int expected ) {
    	 assertEquals(expected, a+b);
     }
}
