package net.multivision.dao;


import java.util.List;



public interface EmployeeDAO {
	
	public boolean authUser(String user, String pass);
	
	public boolean getClearance(String user,String type);
	
	public void create(String name, String last, String user,String pass,String clear,String img);
	
	public Employee read(String user,String pass);
	
	public Employee update(String id);
	
	public void delete(String Id);
	
	public List<Employee> readAll();

	public void updateEmployee(String id,String user, String pass, String clearance,String first, String last,String img);

	
}
