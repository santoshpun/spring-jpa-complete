package com.santosh.springjpacomplete.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.santosh.springjpacomplete.model.Department;
import com.santosh.springjpacomplete.repository.DepartmentRespository;
import com.santosh.springjpacomplete.request.dto.SaveDepartmentRequest;
import com.santosh.springjpacomplete.response.dto.DepartmentResponse;

@Service
public class DepartmentServiceImpl implements DepartmentService {
	@Autowired
	private DepartmentRespository departmentRepository;

	@Override
	public List<Department> getAllDepartments() {
		List<Department> departments = departmentRepository.findAll();
		return departments;
	}

	@Override
	public DepartmentResponse saveDepartment(SaveDepartmentRequest saveDepartmentRequest) {
		Department department = new Department();
		department.setName(saveDepartmentRequest.getName());
		department.setActive('Y');

		departmentRepository.save(department);

		DepartmentResponse departmentResponse = new DepartmentResponse();
		departmentResponse.setDepartmentId(department.getId());
		departmentResponse.setDepartmentName(department.getName());
		departmentResponse.setStatus(department.getActive() == 'Y' ? "Active" : "Blocked");
		return departmentResponse;
	}

	@Override
	public DepartmentResponse updateDepartment(SaveDepartmentRequest saveDepartmentRequest) {
		Department department = departmentRepository.findById(saveDepartmentRequest.getDepartmentId()).get();
		department.setName(saveDepartmentRequest.getName());
		departmentRepository.save(department);

		DepartmentResponse departmentResponse = new DepartmentResponse();
		departmentResponse.setDepartmentId(department.getId());
		departmentResponse.setDepartmentName(department.getName());
		departmentResponse.setStatus(department.getActive() == 'Y' ? "Active" : "Blocked");

		return departmentResponse;
	}

	@Override
	public boolean deleteDepartment(SaveDepartmentRequest saveDepartmentRequest) {
		Department department = departmentRepository.findById(saveDepartmentRequest.getDepartmentId()).get();
		department.setActive('D');
		departmentRepository.save(department);
		return true;
	}

}
