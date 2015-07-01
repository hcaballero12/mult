package com.icare.dao;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;

public class DAOImpl implements DAO {

	HibernateTemplate hibtemplate;

	public HibernateTemplate getHibtemplate() {
		return hibtemplate;
	}

	public void setHibtemplate(HibernateTemplate hibtemplate) {
		this.hibtemplate = hibtemplate;
	}

	@Override
	public Issue getIssues(Long id) {
		// TODO Auto-generated method stub
		List<Issue> dep = hibtemplate.loadAll(Issue.class);
		Issue is = new Issue();
		for (Iterator iterator = dep.iterator(); iterator.hasNext();) {
			Issue issue = (Issue) iterator.next();
			
			if(issue.getIssueNum() == id){
				is = issue;
				return is;
				
			}
		}
		
		return null;
	}

	@Override
	public String getDepartmentEmail(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateIssueStats(Long id) {
		// TODO Auto-generated method stub
		// create employee object
		
		List<Issue> dep = hibtemplate.loadAll(Issue.class);
		Issue is = new Issue();
		for (Iterator iterator = dep.iterator(); iterator.hasNext();) {
			Issue issue = (Issue) iterator.next();
			
			if(issue.getIssueNum() == id){
				is = issue;	
				
			}
		}
		is.setStatus("close");
		hibtemplate.update(is);

	}

	@Override
	public boolean addIssue(Issue is, Long id, String department) {
		
		List<Department> dep = hibtemplate.loadAll(Department.class);
		List<Employee> emp = hibtemplate.loadAll(Employee.class);
		Employee emplo = null;
		Department depi = null;
		
		for (Iterator iterator = dep.iterator(); iterator.hasNext();) {
			Department depar = (Department) iterator.next();
			
			if(depar.getDepartment().equalsIgnoreCase(department))
			{
				depi = depar;
				break;
			}
		}
		
		for (Iterator iterator = emp.iterator(); iterator.hasNext();) {
			Employee employee = (Employee) iterator.next();
			if(employee.getEmpId() == id){
				emplo = employee;
				break;
			}
			
		}
		is.setDepartment(depi);
		is.setEmployee(emplo);
		hibtemplate.save(is);
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public List<Issue> getCloseIssues() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Issue> getEmployeeIssues(Long id) {
		// TODO Auto-generated method stub
		List<Issue> list = hibtemplate.loadAll(Issue.class);
		List<Issue> issueList = new ArrayList<Issue>();

		for (Iterator iterator = list.iterator(); iterator.hasNext();) {
			Issue issue = (Issue) iterator.next();
			if (issue.getEmployee().getEmpId() == id) {
				issueList.add(issue);
			}

		}
		return issueList;
	}

	@Override
	public List<Issue> getDepartmentIssues(Long id) {
		// TODO Auto-generated method stub
		
		
		List<Issue> list = hibtemplate.loadAll(Issue.class);
		List<Issue> issueList = new ArrayList<Issue>();

		for (Iterator iterator = list.iterator(); iterator.hasNext();) {
			Issue issue = (Issue) iterator.next();
			if (issue.getDepartment().getDepId() == id && issue.getStatus().equalsIgnoreCase("open")) {
				issueList.add(issue);
			}

		}
		return issueList;
	}

	@Override
	public Employee authorize(String user, String pass) {
		// check for user name and password and if is manager or employee

		List<Employee> list = new ArrayList<Employee>();
		list = hibtemplate.loadAll(Employee.class);

		for (Iterator<Employee> iterator = list.iterator(); iterator.hasNext();) {
			Employee employee = iterator.next();

			if (employee.getUsername().equalsIgnoreCase(user)
					&& employee.getPassword().equals(pass)) {

				System.out.println("employee found");
				return employee;

			}

		}

		return null;
	}

	@Override
	public List<Issue> getOpenIssues() {
		// TODO Auto-generated method stub
		return null;
	}

}
