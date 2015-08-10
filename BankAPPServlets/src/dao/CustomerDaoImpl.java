/////////////////////////////////////////////////////////////////////////
// Author -> Hector Caballero                                          //
// This Class whole purpose is to show a DAO Design Pattern using JDBC //
// I used Regular Statements, Prepared Statements and Stored Procedures//
// To demonstrate my ability to use all of them                        //
// //////////////////////////////////////////////////////////////////////
package dao;

import helper.ConnectionObj;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import business.Balance;
import entities.Customer;

public class CustomerDaoImpl implements CustomerDao {

	final static Logger logger = Logger.getLogger(CustomerDaoImpl.class);
	public List<Customer> customers;
	private Customer customer;
	private Connection conn;
	private ConnectionObj connObj;
	private CallableStatement callableStatement = null;
	private Statement stat;
	private PreparedStatement statment;

	@Override
	public List<Customer> getAllCustomers() {

		try {
			// create the list
			customers = new ArrayList();
			// get the connection from the helper class
			connObj = new ConnectionObj();
			conn = connObj.getConn();
			// create sql command
			String sql = "Select * from BANKCUSTOMER";
			stat = conn.createStatement();

			// execute statement
			ResultSet rs = stat.executeQuery(sql);

			while (rs.next()) {

				// create a customer
				customer = new Customer(rs.getLong("ACCOUNT"),
						rs.getString("FIRSTNAME"), rs.getString("LASTNAME"),
						rs.getString("USERNAME"), rs.getString("PASSWORD"),
						rs.getDouble("BALANCE"));

				customers.add(customer);

			}

			return customers;

		} catch (Exception e) {
			logger.error( e );
			return null;
		}
		finally{
			try {
				conn.close();
				stat.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				logger.error( e );
			}
		}

	}

	@Override
	public Customer getCustomer(long accountNO) {
		
		try {

			// get the connection from the helper class
			connObj = new ConnectionObj();
			conn = connObj.getConn();
			// create sql command
			String sql = "Select * from BANKCUSTOMER where ACCOUNT =?";
			statment = conn.prepareStatement(sql);
			
			//get parameters 
			statment.setLong(1,accountNO);
			
			// execute statement
			ResultSet rs = statment.executeQuery();

			while (rs.next()) {

				// create a customer
				customer = new Customer(rs.getLong("ACCOUNT"),
						rs.getString("FIRSTNAME"), rs.getString("LASTNAME"),
						rs.getString("USERNAME"), rs.getString("PASSWORD"),
						rs.getDouble("BALANCE"));

				

			}

			return customer;
		}catch(Exception e){
			logger.error( e );
			return null;
		}
		finally{
			try {
				conn.close();
				statment.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				logger.error( e );
			}
		}

		
	}

	@Override
	public void updateCustomer(Customer customer) {

		try {

			// get the connection from the helper class
			connObj = new ConnectionObj();
			conn = connObj.getConn();
			// create sql command

			String sql = "{call  update_BANKCUSTOMER(?,?,?,?,?,?)}";
			callableStatement = conn.prepareCall(sql);

			// get the in parameters
			callableStatement.setLong(1, customer.getAccount());
			callableStatement.setString(2, customer.getFirstName());
			callableStatement.setString(3, customer.getLastName());
			callableStatement.setString(4, customer.getUsername());
			callableStatement.setString(5, customer.getPassword());
			callableStatement.setDouble(6, customer.getBalance());
			

			// call the prepared statement
			callableStatement.executeUpdate();

		} catch (Exception e) {
			logger.error( e );

		}
		finally{
			try {
				conn.close();
				callableStatement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				logger.error( e );
			}
		}

	}

	@Override
	public void deleteCustomer(Customer customer) {

		try {

			// get the connection from the helper class
			connObj = new ConnectionObj();
			conn = connObj.getConn();
			// create sql command

			String sql = "{call   delete_BANKCUSTOMER(?)}";
			callableStatement = conn.prepareCall(sql);

			// get the in parameters
			callableStatement.setLong(1, customer.getAccount());

			// call the prepared statment
			callableStatement.executeUpdate();

		} catch (Exception e) {
			logger.error( e );

		}
		finally{
			try {
				conn.close();
				callableStatement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				logger.error( e );
			}
		}
	}
	
	public void insertCustomer(Customer customer){
		
		try {

			// get the connection from the helper class
			connObj = new ConnectionObj();
			conn = connObj.getConn();
			// create sql command
			String sql = "Insert into BANKCUSTOMER values(?,?,?,?,?,?)";
			statment = conn.prepareStatement(sql);
			
			//get parameters 
			statment.setLong(1, customer.getAccount());
			statment.setString(2, customer.getFirstName());
			statment.setString(3, customer.getLastName());
			statment.setString(4, customer.getUsername());
			statment.setString(5, customer.getPassword());
			statment.setDouble(6, customer.getBalance());
			
			// execute statement
			statment.executeUpdate();

		

			
		}catch(Exception e){
			logger.error( e );
		}
		finally{
			try {
				conn.close();
				statment.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				logger.error( e );
			}
		}
		
		
		
	}

}
