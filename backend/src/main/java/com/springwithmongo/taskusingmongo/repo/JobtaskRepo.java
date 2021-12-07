package com.springwithmongo.taskusingmongo.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.springwithmongo.taskusingmongo.entity.Jobtask;


public interface JobtaskRepo extends MongoRepository<Jobtask, Integer>{

}