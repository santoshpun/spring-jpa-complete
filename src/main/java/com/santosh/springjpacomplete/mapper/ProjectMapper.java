package com.santosh.springjpacomplete.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.santosh.springjpacomplete.model.Project;
import com.santosh.springjpacomplete.request.dto.SaveProjectRequest;
import com.santosh.springjpacomplete.response.dto.ProjectResponse;

@Component
public class ProjectMapper {

	public List<ProjectResponse> convertToProjectResponse(List<Project> projects) {
		List<ProjectResponse> projectList = new ArrayList<>();

		for (Project project : projects) {
			ProjectResponse projectResponse = new ProjectResponse();
			projectResponse.setId(project.getId());
			projectResponse.setName(project.getName());
			projectResponse.setDescription(project.getDescription());
			projectResponse.setStartDate(project.getStartDate());
			projectResponse.setEndDate(project.getEndDate());
			projectResponse.setStatus(project.getStatus());

			projectList.add(projectResponse);
		}

		return projectList;
	}

	public ProjectResponse convertToProjectResponse(Project project) {
		ProjectResponse projectResponse = new ProjectResponse();
		projectResponse.setId(project.getId());
		projectResponse.setName(project.getName());
		projectResponse.setDescription(project.getDescription());
		projectResponse.setStartDate(project.getStartDate());
		projectResponse.setEndDate(project.getEndDate());
		projectResponse.setStatus(project.getStatus());
		return projectResponse;
	}

	public Project convertToProject(SaveProjectRequest saveProjectRequest) {
		Project project = new Project();
		project.setName(saveProjectRequest.getName());
		project.setDescription(saveProjectRequest.getDescription());
		project.setStatus(0);
		project.setStartDate(saveProjectRequest.getStartDate());
		project.setEndDate(saveProjectRequest.getEndDate());
		return project;
	}

}
