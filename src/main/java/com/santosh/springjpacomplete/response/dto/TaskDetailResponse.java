package com.santosh.springjpacomplete.response.dto;

public class TaskDetailResponse {
	private Integer id;
	private String name;
	private String description;
	private Integer percentageCompleted;
	private ProjectResponse project;

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

	public Integer getPercentageCompleted() {
		return percentageCompleted;
	}

	public void setPercentageCompleted(Integer percentageCompleted) {
		this.percentageCompleted = percentageCompleted;
	}

	public ProjectResponse getProject() {
		return project;
	}

	public void setProject(ProjectResponse project) {
		this.project = project;
	}

}
