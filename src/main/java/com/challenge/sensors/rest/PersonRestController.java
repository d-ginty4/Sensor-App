package com.challenge.sensors.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.challenge.sensors.DAO.PersonDAO;
import com.challenge.sensors.entity.Person;

@RestController
@RequestMapping("/api")
public class PersonRestController {
	
	private PersonDAO personDAO;
	
	@Autowired
	public PersonRestController(PersonDAO thePersonDAO) {
		personDAO = thePersonDAO;
	}
	
	@GetMapping("/persons")
	public List<Person> findAll(){
		return personDAO.findAll();
	}
}
