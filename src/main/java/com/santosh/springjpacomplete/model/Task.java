package com.santosh.springjpacomplete.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name = "task")
public class Task {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String name;
	private String description;
	@Column(name = "task_completed")
	private Integer taskCompleted;

	@JoinColumn(name = "project_id", referencedColumnName = "id")
	@ManyToOne()
	private Project project;

	@OneToMany(mappedBy = "task", fetch = FetchType.EAGER)
	@Fetch(FetchMode.SUBSELECT)
	private List<TaskAssignee> assignees;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getTaskCompleted() {
		return taskCompleted;
	}

	public void setTaskCompleted(Integer taskCompleted) {
		this.taskCompleted = taskCompleted;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public List<TaskAssignee> getAssignees() {
		return assignees;
	}

	public void setAssignees(List<TaskAssignee> assignees) {
		this.assignees = assignees;
	}
}
