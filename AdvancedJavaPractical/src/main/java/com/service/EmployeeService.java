package com.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.model.EmployeeModel;
import com.util.DBUtil;

/**
 * Service class for handling employee database operations.
 * This class includes methods to check for existing usernames and contact numbers,
 * and to add and fetch employee details in the database.
 */
public class EmployeeService {

	Connection connection = null;
	
	/**
	 * Checks if a username already exists in the employee database
	 * @param username The username to check for existence
	 * @return true if the username exists, otherwise false.
	 */
	public boolean isUserNameExists(String username) {
		connection = new DBUtil().getConnection();       // Establishing a database connection
		
		String query = "select user_name from employee where user_name = ? ";   // query to execute 
		boolean isUserNamePresent = false;
		
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, username);
			
			ResultSet resultSet = statement.executeQuery();
			if(resultSet.next()) {
				isUserNamePresent = true;
			} 
			connection.close();    // closing the connection
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return isUserNamePresent;
	}
	
	/**
	 * Checks if a contact number already exists in the database
	 * @param contactNumber The contact number to be checked
	 * @return True if the contact number exists in the database, otherwise false
	 */
	public boolean checkContactExists(String contactNumber) {
		connection = new DBUtil().getConnection();      // Establishing a database connection
		
		String query = "select contact_no from employee where contact_no = ? ";     // query to execute
		boolean isContactPresent = false;
		
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, contactNumber);
			
			ResultSet resultSet = statement.executeQuery();
			if(resultSet.next()) {
				isContactPresent = true;
			}
			connection.close();    // closing the connection
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return isContactPresent;
	}
	
	/**
	 * This method adds employee details to the database
	 * @param employeeModel The EmployeeModel object containing the details of the employee to be added
	 * @return An integer indicating the success of the operation:
	 *        - Returns 1 if the employee details were successfully added to the database.
     *        - Returns 0 if the operation failed.
	 */
	public int addEmployeeDetails(EmployeeModel employeeModel) {
		connection = new DBUtil().getConnection();     // Establishing a database connection
		
		int executeQuery = 0;   // Variable to store the execution status of the SQL query
		
		// SQL query to insert employee details into the database
		String query = "insert into employee(first_name, last_name, user_name, employee_password, address, contact_no) values(?,?,?,?,?,?) ";
		
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			// Setting values for parameters in the prepared statement
			statement.setString(1, employeeModel.getFirstName());
			statement.setString(2, employeeModel.getLastName());
			statement.setString(3, employeeModel.getUserName());
			statement.setString(4, employeeModel.getPassword());
			statement.setString(5, employeeModel.getAddress());
			statement.setString(6, employeeModel.getContactNo());
			
			executeQuery = statement.executeUpdate();			
			connection.close();      // closing the connection
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return executeQuery;
	}
	
	/**
	 * Retrieves a list of all employees from the database.
	 * This method establishes a connection to the database using the `DBUtil` class,
	 * executes a query to fetch all employee records, and maps each record to an
	 * EmployeeModel` object. The `EmployeeModel` objects are then added to a list,
	 * which is returned to the caller.
	 * @return List<EmployeeModel> - A list containing `EmployeeModel` objects representing each employee in the database.
	 */
	public List<EmployeeModel> getEmployeeDetails() {
		connection = new DBUtil().getConnection();     // Establishing a database connection
		
		List<EmployeeModel> employees = new ArrayList<EmployeeModel>();     // create list to store all employee data
		
		String query = "select * from employee";   // query to execute
		
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			ResultSet resultSet = statement.executeQuery();
			while(resultSet.next()) {
				EmployeeModel employeeModel = new EmployeeModel();
				
				employeeModel.setEmployeeId(resultSet.getInt("id"));
				employeeModel.setFirstName(resultSet.getString("first_name"));
				employeeModel.setLastName(resultSet.getString("last_name"));
				employeeModel.setUserName(resultSet.getString("user_name"));
				employeeModel.setPassword(resultSet.getString("employee_password"));
				employeeModel.setAddress(resultSet.getString("address"));
				employeeModel.setContactNo(resultSet.getString("contact_no"));
				
				employees.add(employeeModel);
			}
			connection.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return employees;
	}
	
}
