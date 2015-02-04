package com.java.core;

import org.springframework.beans.factory.annotation.Configurable;


@Configurable
public class NonSpringClass {

	private SecurityMethods securityMethods;

	public SecurityMethods getSecurityMethods() {
		return securityMethods;
	}

	public void setSecurityMethods(SecurityMethods securityMethods) {
		this.securityMethods = securityMethods;
	}

	public String getStringFromSecurityMEthods() {
		if(securityMethods != null) {
			return securityMethods.returnString();
		} else {
			return "Bad Message !!!";
		}
	}
	
}
