package com.santosh.springjpacomplete.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.santosh.springjpacomplete.model.Department;

@Repository
public interface DepartmentRespository extends JpaRepository<Department, Integer>{

}
