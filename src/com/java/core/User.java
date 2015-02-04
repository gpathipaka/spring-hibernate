package com.java.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;

public class User {

	private int userId;
	private String firstName;
	private String lastName;
	private MessageSource messageSource;

	public MessageSource getMessageSource() {
		return messageSource;
	}

	public void setMessageSource(MessageSource messageSource) {
		this.messageSource = messageSource;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String toString() {
		return "User Detail \n" + "User Id: " + getUserId() + " Name: "
				+ getFirstName() + ", " + getLastName();
	}
	public void printMessage(){
		System.out.println(this.getMessageSource().getMessage("greeting123",new Object[] {"Gangadhar", "Pathipaka"}, "Default Greeting",  null));
	}
}
