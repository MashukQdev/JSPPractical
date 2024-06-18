package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 This class contain method to establish a connection to a MySQL database
 */
public class DBUtil {

	Connection connection = null;
	
	/**
	 Establishes a connection to the MySQL database
	 @return A Connection object representing the database connection
	 @throws ClassNotFoundException If the MySQL JDBC driver class is not found.
     @throws SQLException If a database access error occurs, such as invalid credentials or connection URL.
	 */
	public Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/advancedjavadatabase","root","root");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return connection;
	}
	
}

