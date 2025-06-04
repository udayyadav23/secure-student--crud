package com.college.studentDb.Repository;



import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.college.studentDb.Entity.user;

@Repository
public interface UserRepo  extends MongoRepository<user , ObjectId>{

	user findByUserName(String usr);

	void deleteByUserName(String name);
	
}
