package com.santosh.springjpacomplete.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.santosh.springjpacomplete.model.Project;
import com.santosh.springjpacomplete.model.Task;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Integer> {

	

}
