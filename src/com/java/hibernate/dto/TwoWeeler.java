package com.java.hibernate.dto;

import javax.persistence.Entity;

@Entity
public class TwoWeeler extends Vehicle {
	
	private String streeringHandle;

	public String getStreeringHandle() {
		return streeringHandle;
	}

	public void setStreeringHandle(String streeringHandle) {
		this.streeringHandle = streeringHandle;
	}

}
