package com.college.studentDb.Repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.college.studentDb.Entity.studentDetails;

public interface StudentRepository extends MongoRepository<studentDetails, ObjectId> {

}
