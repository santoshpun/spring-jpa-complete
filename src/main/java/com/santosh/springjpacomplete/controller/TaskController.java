package com.santosh.springjpacomplete.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.santosh.springjpacomplete.mapper.ProjectMapper;
import com.santosh.springjpacomplete.model.Project;
import com.santosh.springjpacomplete.model.Task;
import com.santosh.springjpacomplete.repository.TaskRepository;
import com.santosh.springjpacomplete.request.dto.SaveTaskRequest;
import com.santosh.springjpacomplete.response.dto.ProjectResponse;
import com.santosh.springjpacomplete.response.dto.TaskDetailResponse;

@RequestMapping("/tasks")
@RestController
public class TaskController {

	@Autowired
	private TaskRepository taskRepository;
	@Autowired
	private ProjectMapper projectMapper;

	@GetMapping
	public ResponseEntity<?> getAllTasks() {
		List<Task> tasks = taskRepository.findAll();

		List<TaskDetailResponse> taskDetailList = new ArrayList<TaskDetailResponse>();

		for (Task task : tasks) {
			TaskDetailResponse taskDetailResponse = new TaskDetailResponse();
			taskDetailResponse.setId(task.getId());
			taskDetailResponse.setName(task.getName());
			taskDetailResponse.setDescription(task.getDescription());
			taskDetailResponse.setPercentageCompleted(task.getTaskCompleted());

			Project project = task.getProject();

			ProjectResponse projectResponse = projectMapper.convertToProjectResponse(project);

			taskDetailResponse.setProject(projectResponse);

			taskDetailList.add(taskDetailResponse);
		}

		return ResponseEntity.ok().body(taskDetailList);
	}

	@GetMapping("/task/details/list/{projectId}")
	public ResponseEntity<?> getAllTaskDetails(@PathVariable("projectId") Integer projectId) {
		List<Task> tasks = taskRepository.findTasksByProvidedProjectId(projectId);

		return ResponseEntity.ok().body(tasks);
	}

	@PostMapping(value = "")
	public ResponseEntity<?> addTask(@RequestBody SaveTaskRequest saveTaskRequest) {

		Task task = new Task();
		task.setName(saveTaskRequest.getName());
		task.setDescription(saveTaskRequest.getDescription());
		task.setTaskCompleted(0);
		task.setProject(new Project(saveTaskRequest.getProjectId()));

		taskRepository.save(task);

		return ResponseEntity.status(HttpStatus.CREATED).body(task);
	}

}
