package com.santosh.springjpacomplete.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.santosh.springjpacomplete.model.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Integer> {

	@Query("select t from Task t join t.project p where p.id = :projectId")
	List<Task> findTasksByProvidedProjectId(@Param("projectId") Integer projectId);
}
