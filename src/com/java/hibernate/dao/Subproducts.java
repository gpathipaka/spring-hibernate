package com.java.hibernate.dao;

import java.util.Set;

public class Subproducts {

	private Long id;
	private String subProductCode;
	private Set<Functions> functions;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSubProductCode() {
		return subProductCode;
	}

	public void setSubProductCode(String subProductCode) {
		this.subProductCode = subProductCode;
	}

	public Set<Functions> getFunctions() {
		return functions;
	}

	public void setFunctions(Set<Functions> functions) {
		this.functions = functions;
	}

}
