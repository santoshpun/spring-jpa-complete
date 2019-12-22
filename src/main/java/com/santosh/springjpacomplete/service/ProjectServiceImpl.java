package com.santosh.springjpacomplete.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.santosh.springjpacomplete.mapper.ProjectMapper;
import com.santosh.springjpacomplete.model.Project;
import com.santosh.springjpacomplete.repository.ProjectRepository;
import com.santosh.springjpacomplete.request.dto.SaveProjectRequest;
import com.santosh.springjpacomplete.request.dto.UpdateProjectRequest;
import com.santosh.springjpacomplete.response.dto.ProjectResponse;

@Service
public class ProjectServiceImpl implements ProjectService {

	@Autowired
	private ProjectRepository projectRepository;
	@Autowired
	private ProjectMapper projectMapper;

	@Override
	public List<ProjectResponse> getAllProjects() {
		List<Project> projects = projectRepository.findAll();

		return projectMapper.convertToProjectResponse(projects);
	}

	@Override
	public ProjectResponse save(SaveProjectRequest saveProjectRequest) {
		Project project = projectMapper.convertToProject(saveProjectRequest);

		projectRepository.save(project);

		return projectMapper.convertToProjectResponse(project);
	}

	@Override
	public ProjectResponse update(UpdateProjectRequest updateProjectRequest) {

		Project project = projectRepository.findById(updateProjectRequest.getId()).get();
		project.setName(updateProjectRequest.getName());
		project.setDescription(updateProjectRequest.getDescription());
		project.setStatus(updateProjectRequest.getStatus());
		project.setStartDate(updateProjectRequest.getStartDate());
		project.setEndDate(updateProjectRequest.getEndDate());

		projectRepository.save(project);

		ProjectResponse projectResponse = projectMapper.convertToProjectResponse(project);

		return projectResponse;
	}

	@Override
	public boolean delete(Integer projectId) {

		Project project = projectRepository.findById(projectId).get();
		project.setStatus(2);

		projectRepository.save(project);

		return true;
	}

}
