package actions;

import helper.Authorization;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CustomerDao;
import dao.CustomerDaoImpl;
import entities.Customer;

public class Login extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String password, username;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		Authorization auth = new Authorization();
		HttpSession session = req.getSession(true);
		RequestDispatcher rd;
		
		
		//get username and password
		username = req.getParameter("user");
		password = req.getParameter("pass");
		
		System.out.println(username);
		System.out.println(password);
		
		Customer cust = auth.authorize(username, password);
		//authenticate user
		if(cust != null){
			session.setAttribute("account", cust.getAccount());
			session.setAttribute("first", cust.getFirstName());
			session.setAttribute("last", cust.getLastName());
			session.setAttribute("user", cust.getUsername());
			session.setAttribute("balance", cust.getBalance());
			//return to login page 
			rd = req.getRequestDispatcher("pages/main.jsp");
			rd.forward(req,  resp);

		}
		else{
			//validate user
			req.setAttribute("errorMessage", "Invalid user or password");
			rd = req.getRequestDispatcher("pages/home.jsp");
			rd.forward(req,  resp);

		}
		


	}

}
