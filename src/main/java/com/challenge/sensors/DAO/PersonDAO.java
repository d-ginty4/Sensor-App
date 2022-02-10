package com.challenge.sensors.DAO;

import java.util.List;


import javax.persistence.EntityManager;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.challenge.sensors.entity.Person;

@Repository
public class PersonDAO {

	private EntityManager entityManager;
	
	@Autowired
	public PersonDAO(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}
	
	@Transactional
	public List<Person> findAll(){
		Session currentSession = entityManager.unwrap(Session.class);
		
		Query<Person> theQuery = currentSession.createQuery("from Person", Person.class);
		
		List<Person> persons =theQuery.getResultList();
		
		return persons;
	}
}
