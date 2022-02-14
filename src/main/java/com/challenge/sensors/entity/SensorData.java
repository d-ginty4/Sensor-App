package com.challenge.sensors.entity;

import java.security.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="sensor_data")
public class SensorData {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "sensor_id")
	private int sensorId;
	
	@Column(name = "date_time")
	private LocalDateTime dateTime;
	
	@Column(name = "temperature")
	private float temperature;
	
	@Column(name = "humidity")
	private float humidity;
	
	public SensorData() {
		
	}

	public SensorData(int sensorId, float temperature, float humidity) {
		this.sensorId = sensorId;
		this.temperature = temperature;
		this.humidity = humidity;
	}

	public LocalDateTime getDateTime() {
		return dateTime;
	}

	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}

	public float getTemperature() {
		return temperature;
	}

	public void setTemperature(float temperature) {
		this.temperature = temperature;
	}

	public float getHumidity() {
		return humidity;
	}

	public void setHumidity(float humidity) {
		this.humidity = humidity;
	}

	public int getSensorId() {
		return sensorId;
	}

	public void setSensorId(int sensorId) {
		this.sensorId = sensorId;
	}

	@Override
	public String toString() {
		return "sensorData [dateTime=" + dateTime + ", temperature=" + temperature + ", humidity=" + humidity + "]";
	}
}
