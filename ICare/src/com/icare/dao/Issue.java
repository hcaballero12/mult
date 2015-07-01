package com.icare.dao;



import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@Entity
@Table(name = "Care_Issue")
public class Issue {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long issueNum;

	@Column
	private int priority;
	private String description;
	private String status;
	@Type(type="timestamp")
	private Timestamp timestamp;


	// relationship with employee
	@ManyToOne
	@JoinColumn(name = "empId")
	private Employee employee;

	// relationship with department
	@ManyToOne
	@JoinColumn(name = "depId")
	private Department department;

	public long getIssueNum() {
		return issueNum;
	}

	public void setIssueNum(long issueNum) {
		this.issueNum = issueNum;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Timestamp getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Timestamp timestamp2) {
		this.timestamp = timestamp2;
	}



	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return "Issue [issueNum=" + issueNum + ", priority=" + priority
				+ ", description=" + description + ", status=" + status
				+ ", timestamp=" + timestamp + ", employee=" + employee
				+ ", department=" + department + "]";
	}
	
	

}
