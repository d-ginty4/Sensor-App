package com.challenge.sensors.rest;

public class SensorNotFoundException extends RuntimeException{

	public SensorNotFoundException(String message, Throwable cause) {
		super(message, cause);
		
	}

	public SensorNotFoundException(String message) {
		super(message);
		
	}

	public SensorNotFoundException(Throwable cause) {
		super(cause);
		
	}
}
