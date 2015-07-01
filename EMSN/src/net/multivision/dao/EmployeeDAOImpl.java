package net.multivision.dao;

import java.util.ArrayList;


import java.util.Iterator;
import java.util.List;
import org.springframework.orm.hibernate3.HibernateTemplate;



public class EmployeeDAOImpl implements EmployeeDAO {

	HibernateTemplate hibtemplate;

	Employee emp;

	
	public Employee getEmp() {
		return emp;
	}

	public void setEmp(Employee emp) {
		this.emp = emp;
	}

	public HibernateTemplate getHibtemplate() {
		return hibtemplate;
	}

	public void setHibtemplate(HibernateTemplate hibtemplate) {
		this.hibtemplate = hibtemplate;
	}
	
	public boolean authUser(String user, String pass) {

	    List<Employee> list=new ArrayList<Employee>(); 
	    list=hibtemplate.loadAll(Employee.class);
	    
	  
		
		for (Iterator iterator = list.iterator(); iterator.hasNext();) {
			Employee employee = (Employee) iterator.next();
			System.out.println("user" + employee.getUser());
			System.out.println("pass" + employee.getPassword());
			 
			if (employee.getUser().equalsIgnoreCase(user) && employee.getPassword().equals(pass)) {
				
				System.out.println("found");
				return true;
				
			} 
			
		}
		System.out.println("not found");
		return false;
		
	}

	public boolean getClearance(String user, String type) {
		
		List<Employee> list=new ArrayList<Employee>();  
	    list=hibtemplate.loadAll(Employee.class);
		
		for (Iterator iterator = list.iterator(); iterator.hasNext();) {
			Employee employee = (Employee) iterator.next();
		
			if (employee.getUser().equalsIgnoreCase(user) && employee.getClearance().equalsIgnoreCase("admin")) {
				System.out.println("manager");
				return true;
			}
				
		}
		System.out.println("no manager");
		return false;
	}

	@Override
	public void create(String name, String last, String user,String pass, String clear,String img) {
		
		emp.setFirstname(name);
		emp.setLastname(last);
		emp.setUser(user);
		emp.setPassword(pass);
		emp.setClearance(clear);
		emp.setImage(img);
		hibtemplate.save(emp);
		
	}

	@Override
	public Employee read(String user,String pass) {
		
		 List<Employee> list=new ArrayList<Employee>();  
		 list=hibtemplate.loadAll(Employee.class);
			
			for (Iterator iterator = list.iterator(); iterator.hasNext();) {
				Employee employee = (Employee) iterator.next();
				System.out.println("user" + employee.getUser());
				System.out.println("pass" + employee.getPassword());
				 
				if (employee.getUser().equalsIgnoreCase(user) && employee.getPassword().equals(pass)) {
					
					System.out.println(employee);
					return employee;
					
				} 
				
			}
			return null;
	}
	
	public List<Employee> readAll(){  
		
	    List<Employee> list=new ArrayList<Employee>();  
	    list=hibtemplate.loadAll(Employee.class);  
	    return list;  
	}  

	@Override
	public Employee update(String id) {
		
		Employee emp=(Employee)hibtemplate.get(Employee.class,Long.parseLong(id));
		return emp;
		
	}

	@Override
	public void delete(String id) {
		
		Employee emp=(Employee)hibtemplate.get(Employee.class,Long.parseLong(id)); 
		hibtemplate.delete(emp);
		
		
	}

	public void updateEmployee(String id,String user, String pass, String clearance,String first, String last,String img) {
		
		emp.setId(Long.parseLong(id));
		emp.setFirstname(first);
		emp.setLastname(last);
		emp.setUser(user);
		emp.setPassword(pass);
		emp.setClearance(clearance);
		emp.setImage(img);
		hibtemplate.update(emp);
		
		
	}

}
