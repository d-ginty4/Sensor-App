package com.challenge.sensors.rest;

import java.sql.Date;
import java.time.LocalDateTime;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.challenge.sensors.DAO.SensorDAO;
import com.challenge.sensors.entity.Sensor;
import com.challenge.sensors.entity.SensorData;

@RestController
public class SensorRestController {
	
	private SensorDAO sensorDAO;
	
	@Autowired
	public SensorRestController(SensorDAO theSensorDAO) {
		sensorDAO = theSensorDAO;
	}
	
	@PostMapping("/sensor")
	public Sensor addSensor(@RequestBody Sensor theSensor) {
	
		sensorDAO.save(theSensor);
		
		return theSensor;
	}
	
	@PostMapping("/sensorData")
	public SensorData addSensorData(@RequestBody SensorData theSensorData) {
	
		theSensorData.setDateTime(LocalDateTime.now());
		sensorDAO.saveData(theSensorData);
		
		return theSensorData;
	}
	
	@GetMapping("/data")
	public List<Sensor> getSensors(@RequestParam List<String> id, @RequestParam List<String> data, 
									@RequestParam(required = false) Date startDate, @RequestParam(required = false) Date endDate) {
		List<Sensor> sensors = new ArrayList<Sensor>();
		
		for (String s: id) {
		    int idInteger = Integer.parseInt(s);
		    Sensor sensor = sensorDAO.findById(idInteger, data);
		    sensors.add(sensor);
		}
	    
	    return sensors;
	}
	
	@GetMapping("/allData")
	public List<Sensor> allSensorData(@RequestParam List<String> data, 
										@RequestParam(required = false) Date startDate, @RequestParam(required = false) Date endDate){
		List<Sensor> sensors = sensorDAO.findAll(data);
		
		return sensors;
	}
}
