package com.java.hibernate.dto;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Table;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

@Entity
@Table(name = "USER_DETAILS")
public class UserDetails {

	private int userId;
	private String userName;
	private Address homeAddress;
	private Address officeAddress;
	//private Set<Address> addList = new HashSet<Address>();
	private Collection<Address> addList = new ArrayList<Address>();

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	@Column(name = "USER_NAME")
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@AttributeOverrides( {
			@AttributeOverride(name = "streetName", column = @Column(name = "OFFICE_STREE_NAME")),
			@AttributeOverride(name = "city", column = @Column(name = "OFFICE_CITY_NAME")),
			@AttributeOverride(name = "state", column = @Column(name = "OFFICE_STATE_NAME")),
			@AttributeOverride(name = "zip", column = @Column(name = "OFFICE_ZIP_NAME")), })
	public Address getOfficeAddress() {
		return officeAddress;
	}

	public void setOfficeAddress(Address officeAddress) {
		this.officeAddress = officeAddress;
	}

	@AttributeOverrides( {
			@AttributeOverride(name = "streetName", column = @Column(name = "HOME_STREE_NAME")),
			@AttributeOverride(name = "city", column = @Column(name = "HOME_CITY_NAME")),
			@AttributeOverride(name = "state", column = @Column(name = "HOME_STATE_NAME")),
			@AttributeOverride(name = "zip", column = @Column(name = "HOME_ZIP_NAME")), })
	public Address getHomeAddress() {
		return homeAddress;
	}

	public void setHomeAddress(Address homeAddress) {
		this.homeAddress = homeAddress;
	}

	@ElementCollection(fetch=FetchType.EAGER)
	@JoinTable(name="USER_ADDRESS", joinColumns=@JoinColumn(name="USER_ID"))
	@GenericGenerator(name="hilo", strategy="hilo")
	@CollectionId(columns = { @Column(name="ADDRESS_ID") }, generator = "hilo", type = @Type(type="long"))
	public Collection<Address> getAddList() {
		return addList;
	}

	public void setAddList(Collection<Address> addList) {
		this.addList = addList;
	}

}
