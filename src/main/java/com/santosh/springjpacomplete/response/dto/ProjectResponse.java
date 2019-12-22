package com.santosh.springjpacomplete.response.dto;

import java.util.Date;

public class ProjectResponse {

	private Integer id;
	private String name;
	private String description;
	// @DateTimeFormat(pattern = "MM/dd/yyyy HH:mm:ss")
	private Date startDate;
	// @DateTimeFormat(pattern = "MM/dd/yyyy HH:mm:ss")
	private Date endDate;
	private Integer status;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

}
