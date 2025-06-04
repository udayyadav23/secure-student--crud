package com.college.studentDb;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.MongoTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@SpringBootApplication
@EnableTransactionManagement
public class StudentDatabaseApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentDatabaseApplication.class, args);
//		Arrays.stream(applicationContext.getBeanDefinitionNames()).sorted().forEach(System.out::println);
	}
	
@Bean 
  public PlatformTransactionManager add(MongoDatabaseFactory dbFactory) {
	  return new MongoTransactionManager(dbFactory);
  }
	
}
