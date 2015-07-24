package business;

import dao.CustomerDao;
import dao.CustomerDaoImpl;
import entities.Customer;

public class Operations {

	final double  ERROR_BALANCE = 0.00;
	CustomerDao dao = new CustomerDaoImpl();
	Customer cust;
	double balance;

	public double doOperation(double amount, String operation, String account) {

		balance = getBalance(account);
		cust = dao.getCustomer(Long.parseLong(account));

		// check for type of operation
		if (operation.equals("deposit")) {

			// update database
			balance += amount;
			cust.setBalance(balance);
			dao.updateCustomer(cust);
			System.out.println("Inserted into database");
			return balance;

		}

		else if (operation.equals("withdraw")) {

			//chack for insufficient balance
			if (cust.getBalance() >= amount) {
				// update database
				balance -= amount;
				cust.setBalance(balance);
				dao.updateCustomer(cust);
				System.out.println("Inserted into database");
				return balance;

			} else {
				System.out.println("error");
				return ERROR_BALANCE;

			}

		} else {
			System.out.println("Error");
			return ERROR_BALANCE;
		}

	}

	public double getBalance(String account) {

		try {

			cust = dao.getCustomer(Long.parseLong(account));
			balance = cust.getBalance();
			return balance;

		} catch (Exception e) {
			e.printStackTrace();
			return ERROR_BALANCE;
		}

		
	}

}
