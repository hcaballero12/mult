package business;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import org.apache.log4j.Logger;

import actions.Operation;
import dao.CustomerDao;
import dao.CustomerDaoImpl;
import entities.Customer;

public class Balance {
	
	CustomerDao dao = new CustomerDaoImpl();
	Customer cust;
	double balance = 0.0;
	final static Logger logger = Logger.getLogger(Balance.class);
	
	public double getBalance(String account){
			
			
			try {
				
				cust = dao.getCustomer(Long.parseLong(account));
				balance = cust.getBalance();
				return balance;
				
			} catch (Exception e) {
				logger.error( e );
			}		
			return balance;
		}

}
