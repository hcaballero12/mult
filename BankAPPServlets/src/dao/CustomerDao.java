package dao;

import java.util.List;

import entities.Customer;

public interface CustomerDao {
	
	   public List<Customer> getAllCustomers();
	   public Customer getCustomer(long accountNO);
	   public void updateCustomer(Customer customer);
	   public void deleteCustomer(Customer customer);
	   public void insertCustomer(Customer customer);
			

}
