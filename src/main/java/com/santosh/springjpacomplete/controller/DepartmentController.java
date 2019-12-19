package com.santosh.springjpacomplete.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.santosh.springjpacomplete.model.Department;
import com.santosh.springjpacomplete.request.dto.SaveDepartmentRequest;
import com.santosh.springjpacomplete.response.dto.DepartmentResponse;
import com.santosh.springjpacomplete.service.DepartmentService;

@RequestMapping(value = "/departments")
@RestController
public class DepartmentController {
	@Autowired
	private DepartmentService departmentService;

	@GetMapping("")
	public ResponseEntity<?> getAllDepartments() {
		List<Department> departments = departmentService.getAllDepartments();
		return ResponseEntity.accepted().body(departments);
	}

	@PostMapping("/save")
	public ResponseEntity<?> save(@RequestBody SaveDepartmentRequest saveDepartmentRequest) {
		DepartmentResponse departmentResponse = departmentService.saveDepartment(saveDepartmentRequest);
		return ResponseEntity.status(HttpStatus.CREATED).body(departmentResponse);
	}

	@PostMapping("/update")
	public ResponseEntity<?> update(@RequestBody SaveDepartmentRequest saveDepartmentRequest) {
		DepartmentResponse departmentResponse = departmentService.updateDepartment(saveDepartmentRequest);
		return ResponseEntity.status(HttpStatus.OK).body(departmentResponse);
	}

	@PostMapping("/delete")
	public ResponseEntity<?> delete(@RequestBody SaveDepartmentRequest saveDepartmentRequest) {
		departmentService.deleteDepartment(saveDepartmentRequest);
		return ResponseEntity.noContent().build();
	}

}
