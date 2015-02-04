package com.java.hibernate.dao;

import java.util.Set;

public class Functions {
	private Long id;
	private String functionCode;

	private Set<Subproducts> subproducts;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFunctionCode() {
		return functionCode;
	}

	public void setFunctionCode(String functionCode) {
		this.functionCode = functionCode;
	}

	public Set<Subproducts> getSubproducts() {
		return subproducts;
	}

	public void setSubproducts(Set<Subproducts> subproducts) {
		this.subproducts = subproducts;
	}

}
