/*This Class is a Helper Class to Get the Connection Object using Singleton pattern to get only one connection
to avoid connections leaks*/

package helper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionObj {

	private Connection conn;

	public ConnectionObj() {
		
		createConnection();

	}

	private void createConnection() {

		try {

			// load driver
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// create the url
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			// create username
			String userData = "caballero";
			// create password
			String password = "caballero";
			// get connection Object
			setConn(DriverManager.getConnection(url, userData, password));

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();

		}

	}

	public Connection getConn() {
		return conn;
	}

	public void setConn(Connection conn) {
		this.conn = conn;
	}

}
