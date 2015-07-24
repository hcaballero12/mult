package business;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import dao.CustomerDao;
import dao.CustomerDaoImpl;
import entities.Customer;

public class Balance {
	
	CustomerDao dao = new CustomerDaoImpl();
	Customer cust;
	double balance = 0.0;
	
	public double getBalance(String account){
			
			
			try {
				
				cust = dao.getCustomer(Long.parseLong(account));
				balance = cust.getBalance();
				return balance;
				
			} catch (Exception e) {
				// TODO: handle exception
			}
			
			return balance;
		}

}
