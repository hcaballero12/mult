package com.icare.dao;

import java.util.List;

public interface DAO {
	
	
	public List<Issue> getOpenIssues();
	
	public List<Issue> getCloseIssues();
	
	public String getDepartmentEmail(int id);
	
	public void updateIssueStats(Long id);
	
	public boolean addIssue(Issue is, Long id, String department);
	
	public List<Issue> getEmployeeIssues(Long id);
	
	public List<Issue> getDepartmentIssues(Long id);
	
	public Employee authorize(String user, String pass);

	Issue getIssues(Long Id);

	




}
