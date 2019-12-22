package com.santosh.springjpacomplete.service;

import java.util.List;

import com.santosh.springjpacomplete.request.dto.SaveProjectRequest;
import com.santosh.springjpacomplete.request.dto.UpdateProjectRequest;
import com.santosh.springjpacomplete.response.dto.ProjectResponse;

public interface ProjectService {

	List<ProjectResponse> getAllProjects();

	ProjectResponse save(SaveProjectRequest saveProjectRequest);

	ProjectResponse update(UpdateProjectRequest updateProjectRequest);

	boolean delete(Integer projectId);

}
