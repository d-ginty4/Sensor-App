package com.challenge.sensors.DAO;

import java.sql.Date;
import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.challenge.sensors.entity.Sensor;
import com.challenge.sensors.entity.SensorData;

@Repository
public class SensorDAO {

	private EntityManager entityManager;
	
	@Autowired
	public SensorDAO(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}
	
	public void save(Sensor theSensor) {
		Session currentSession = entityManager.unwrap(Session.class);
		
		currentSession.saveOrUpdate(theSensor);
	}

	public void saveData(SensorData theSensorData) {
		Session currentSession = entityManager.unwrap(Session.class);
		
		currentSession.saveOrUpdate(theSensorData);
	}

	public List<Sensor> findAll(List<String> data){
		Session currentSession = entityManager.unwrap(Session.class);
		
		Query<Sensor> theQuery = currentSession.createQuery("from Sensor", Sensor.class);
		
		List<Sensor> sensors =theQuery.getResultList();
		
		for(Sensor s: sensors) {
			extractData(data, s);
		}
		
		return sensors;
	}
	
	public Sensor findById(int idInteger, List<String> data) {
		Session currentSession = entityManager.unwrap(Session.class);
		
		Sensor theSensor = currentSession.get(Sensor.class, idInteger);
		
		extractData(data, theSensor);
		
		return theSensor;
	}
	
	private void extractData(List<String> data, Sensor sensor) {
		Session currentSession = entityManager.unwrap(Session.class);
		
		String query = "";
		
		if(data.contains("temperature")) {
			query = "select avg(temperature) from SensorData where sensorId= " + sensor.getId();
		
			Double avgTemperature = (Double) currentSession.createQuery(query).getSingleResult();
			
			sensor.setAvgTemperature(avgTemperature.floatValue());
		}
		
		if(data.contains("humidity")) {
			query = "select avg(humidity) from SensorData where sensorId= " + sensor.getId();
		
			Double avgHumidity = (Double) currentSession.createQuery(query).getSingleResult();
			
			sensor.setAvgHumidity(avgHumidity.floatValue());
		}
	}
}
