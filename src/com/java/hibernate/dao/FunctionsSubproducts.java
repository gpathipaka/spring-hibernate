package com.java.hibernate.dao;

import java.io.Serializable;

public class FunctionsSubproducts implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Functions function;
	private Subproducts subProducts;
	private String code;
	private Id id = new Id();
	
	public FunctionsSubproducts() {}

	public FunctionsSubproducts(Functions function, Subproducts subProducts,
			String code) {

		if (function == null || subProducts == null) {
			throw new IllegalArgumentException("Null Paramerter");
		}
		this.id = new Id(function.getId(), subProducts.getId(), code);
		this.function = function;
		this.subProducts = subProducts;
	}

	public Id getId() {
		return id;
	}

	public void setId(Id id) {
		this.id = id;
	}

	public Functions getFunction() {
		return function;
	}

	public void setFunction(Functions function) {
		this.function = function;
	}

	public Subproducts getSubProducts() {
		return subProducts;
	}

	public void setSubProducts(Subproducts subProducts) {
		this.subProducts = subProducts;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public int hashCode() {
		final int PRIME = 31;
		int result = 1;
		result = PRIME * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		final FunctionsSubproducts other = (FunctionsSubproducts) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id)) {
			return false;
		}
		return true;
	}

	public static class Id implements Serializable {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private Long subProductId;
		private Long functionId;
		private String code;

		public Id() {
		};

		public Id(Long subProductId, Long functionId, String code) {
			this.subProductId = subProductId;
			this.functionId = functionId;
			this.code = code;
		}

		public int hashCode() {
			final int PERM = 31;
			int result = 1;
			result = PERM * result
					+ ((functionId == null) ? 0 : functionId.hashCode());
			result = PERM * result
					+ ((subProductId == null) ? 0 : subProductId.hashCode());
			return result;
		}

		public boolean equals(Object obj) {

			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			final Id other = (Id) obj;
			if (functionId == null) {
				if (other.functionId != null) {
					return false;
				}
			} else if (!functionId.equals(other.functionId))
				return false;
			if (subProductId == null) {
				if (other.subProductId != null) {
					return false;
				}
			} else if (subProductId.equals(other.subProductId)) {
				return false;
			}
			return true;
		}

	}

}
