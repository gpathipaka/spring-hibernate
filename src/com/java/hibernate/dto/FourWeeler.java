package com.java.hibernate.dto;

import javax.persistence.Entity;

@Entity
public class FourWeeler extends Vehicle {

	private String steeringWeel;

	public String getSteeringWeel() {
		return steeringWeel;
	}

	public void setSteeringWeel(String steeringWeel) {
		this.steeringWeel = steeringWeel;
	}
	
}
