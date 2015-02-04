package com.java.hibernate.dto;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "UserVehicle")
public class UserD {

	private int userId;
	private String name;
	private Collection<Vehicle> vehicle = new ArrayList<Vehicle>();

	@Id
	@GeneratedValue
	@Column(name = "USER_ID")
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	@Column(name = "USER_NAME")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@ManyToMany(cascade=CascadeType.ALL)
	public Collection<Vehicle> getVehicle() {
		return vehicle;
	}

	/*
	 * @OneToOne
	 * 
	 * @JoinColumn(name="VEHICLE_ID") public Vehicle getVehicle() { return
	 * vehicle; }
	 */
	public void setVehicle(Collection<Vehicle> vehicle) {
		this.vehicle = vehicle;
	}

}
