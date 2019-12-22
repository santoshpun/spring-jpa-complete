package com.santosh.springjpacomplete.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.santosh.springjpacomplete.request.dto.SaveProjectRequest;
import com.santosh.springjpacomplete.request.dto.UpdateProjectRequest;
import com.santosh.springjpacomplete.response.dto.ProjectResponse;
import com.santosh.springjpacomplete.service.ProjectService;

@RequestMapping("/projects")
@RestController
public class ProjectController {

	@Autowired
	private ProjectService projectService;

	@GetMapping
	public ResponseEntity<?> getAllProjects() {
		List<ProjectResponse> projects = projectService.getAllProjects();

		return ResponseEntity.ok().body(projects);
	}

	@PostMapping(value = "")
	public ResponseEntity<?> addProject(@RequestBody SaveProjectRequest saveProjectRequest) {

		ProjectResponse projectResponse = projectService.save(saveProjectRequest);

		return ResponseEntity.status(HttpStatus.CREATED).body(projectResponse);
	}

	@PutMapping(value = "")
	public ResponseEntity<?> updateProject(@RequestBody UpdateProjectRequest updateProjectRequest) {

		ProjectResponse projectResponse = projectService.update(updateProjectRequest);

		return ResponseEntity.status(HttpStatus.OK).body(projectResponse);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> updateProject(@PathVariable(name = "id") Integer id) {

		projectService.delete(id);

		return ResponseEntity.noContent().build();
	}

}
