package com.challenge.sensors.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="sensor")
public class Sensor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "country")
	private String country;
	
	@Column(name = "city")
	private String city;
	
	@Transient
	private float avgTemperature;
	
	@Transient
	private float avgHumidity;
	
	public Sensor() {
		
	}

	public Sensor(String country, String city) {
		this.country = country;
		this.city = city;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public float getAvgTemperature() {
		return avgTemperature;
	}

	public void setAvgTemperature(float avgTemperature) {
		this.avgTemperature = avgTemperature;
	}

	public float getAvgHumidity() {
		return avgHumidity;
	}

	public void setAvgHumidity(float avgHumidity) {
		this.avgHumidity = avgHumidity;
	}

	@Override
	public String toString() {
		return "Sensor [id=" + id + ", country=" + country + ", city=" + city + ", avgTemperature=" + avgTemperature
				+ ", avgHumidity=" + avgHumidity + "]";
	}
}
