package com.santosh.springjpacomplete.request.dto;

public class SaveDepartmentRequest {

	private Integer departmentId;
	private String name;

	public Integer getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Integer departmentId) {
		this.departmentId = departmentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
