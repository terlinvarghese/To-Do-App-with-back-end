package com.springwithmongo.taskusingmongo.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.springwithmongo.taskusingmongo.entity.Jobtask;
import com.springwithmongo.taskusingmongo.services.JobtaskServices;

@CrossOrigin(origins="http://localhost:3000/")
@RestController
public class JobtaskControler {
	
	@Autowired
	JobtaskServices js;
	
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public Jobtask savingtask(@RequestBody Jobtask j) {
		return js.savetask(j);
	}
	
	@RequestMapping(value="/view",method=RequestMethod.GET)
	public List<Jobtask> view(){
		return js.display();
	}
	
	@RequestMapping(value="/delete/{id}",method=RequestMethod.POST)
	public int delete(@PathVariable("id") int id) {
	  js.deletetask(id);
	  return id;
	}
	@RequestMapping(value="/update/{id}",method=RequestMethod.GET)
	public Jobtask update(@PathVariable("id") int id) {
		return js.taskupdate(id);
		
	}
}