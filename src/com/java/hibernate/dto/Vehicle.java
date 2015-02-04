package com.java.hibernate.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name = "VEHICLE")
@Inheritance(strategy=InheritanceType.JOINED)
//@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
// @Inheritance(strategy = InheritanceType.SINGLE_TABLE)
// @DiscriminatorColumn(name = "VEHICLE_TYPE", discriminatorType =
// DiscriminatorType.STRING)
public class Vehicle {

	private int vahicleId;
	private String vehicleName;

	@Id
	@GeneratedValue
	@Column(name = "VEHICLE_ID")
	public int getVahicleId() {
		return vahicleId;
	}

	public void setVahicleId(int vahicleId) {
		this.vahicleId = vahicleId;
	}

	@Column(name = "VEHICLE_NAME")
	public String getVehicleName() {
		return vehicleName;
	}

	public void setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
	}
}
