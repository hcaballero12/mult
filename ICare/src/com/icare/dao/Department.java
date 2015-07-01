package com.icare.dao;


import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "Care_Department")
public class Department {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long depId;
	
	@Column
	private String department;
	private String manager_name;
	private String email;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="department",fetch = FetchType.EAGER)
	private Set<Employee> employee;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="department")
	private Set<Issue> issues;

	public long getDepId() {
		return depId;
	}

	public String getDepartment() {
		return department;
	}

	public String getManager_name() {
		return manager_name;
	}

	public String getEmail() {
		return email;
	}

	public Set<Employee> getEmployee() {
		return employee;
	}

	public Set<Issue> getIssues() {
		return issues;
	}
	
	

	
	

}

