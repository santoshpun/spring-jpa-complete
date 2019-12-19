package com.santosh.springjpacomplete.service;

import java.util.List;

import com.santosh.springjpacomplete.model.Department;
import com.santosh.springjpacomplete.request.dto.SaveDepartmentRequest;
import com.santosh.springjpacomplete.response.dto.DepartmentResponse;

public interface DepartmentService {

	public List<Department> getAllDepartments();

	public DepartmentResponse saveDepartment(SaveDepartmentRequest saveDepartmentRequest);

	public DepartmentResponse updateDepartment(SaveDepartmentRequest saveDepartmentRequest);

	public boolean deleteDepartment(SaveDepartmentRequest saveDepartmentRequest);

}
