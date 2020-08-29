package com.dev.quack.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dev.quack.models.Student;

@Repository
public interface UserRepo extends CrudRepository<Student, Integer>{
	
	 
}


