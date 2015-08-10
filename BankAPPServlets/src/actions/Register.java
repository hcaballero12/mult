package actions;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CustomerDao;
import dao.CustomerDaoImpl;
import entities.Customer;

public class Register extends HttpServlet {
	
	private Customer customer;
	private CustomerDao dao = new CustomerDaoImpl();
	private RequestDispatcher rd;
	
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//send back to login
		rd = req.getRequestDispatcher("pages/register.jsp");
		rd.forward(req,  resp);
	}
	
	
	
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {

		//get parameters from register form
		String first = req.getParameter("first").toString();
		String last = req.getParameter("last").toString();
		String user = req.getParameter("user").toString();
		String pass = req.getParameter("pass").toString();

		
		//register user
		Customer customer = new Customer(0,first,last,user,pass,0.0);
		dao.insertCustomer(customer);
		
		//register successfully
		req.setAttribute("errorMessage", "Register Successful");
		
		//send back to login
		rd = req.getRequestDispatcher("pages/home.jsp");
		rd.forward(req,  resp);
		
	}

}
