package com.springwithmongo.taskusingmongo.services;


import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;
import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;

import com.springwithmongo.taskusingmongo.entity.Squences;
import com.springwithmongo.taskusingmongo.entity.Jobtask;
import com.springwithmongo.taskusingmongo.repo.JobtaskRepo;

@Service
public class JobtaskServices {
	
	@Autowired
	JobtaskRepo jr;
	
	@Autowired
	JobtaskServices js;
	
	@Autowired
	private MongoOperations mongo;
	
	public int getNextSquence(String seqname) {
		Squences counter=mongo.findAndModify(query(where("_id").is(seqname)),
			new Update().inc("squ",1),
			options().returnNew(true).upsert(true),
			Squences.class);
		return counter.getSqu();
	}
	
	public Jobtask savetask(Jobtask j) {
		j.setId(js.getNextSquence(Jobtask.Squence_Name));
		j.setStatus("created");
		jr.save(j);
		return j;
	}
	
	public List<Jobtask> display(){
		return jr.findAll();
	}
	public void deletetask(int id) {
		jr.deleteById(id);
	}
public Jobtask taskupdate(int id) {
		
		Optional<Jobtask> li=jr.findById(id);
		Jobtask j=li.get();
		j.setStatus("completed");
		jr.save(j);
		return j;
	}
}