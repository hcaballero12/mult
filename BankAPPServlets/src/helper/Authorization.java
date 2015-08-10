/*This class is a helper class to authorize the user*/
package helper;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import dao.CustomerDao;
import dao.CustomerDaoImpl;
import entities.Customer;

public class Authorization {
	
	
	public Customer authorize(String user, String pass){
		
		
		CustomerDao dao = new CustomerDaoImpl();
		List list = new ArrayList();
		
		//get the users
		
		list = dao.getAllCustomers();
		
		for (Iterator iterator = list.iterator(); iterator.hasNext();) {
			Customer cust = (Customer) iterator.next();
			

			if(cust.getUsername().equals(user) && cust.getPassword().equals(pass)){
				
				return cust;
			}

			
		}
		return null;
		
		
		
		
	}

}
