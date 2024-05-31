package com.model;

/**
 This class contain attributes such as first name, last name, username,
 password, address, and contact number
 */
public class EmployeeModel {

	private int employeeId;     // employee id of the employee
	private String firstName;   // first name of the employee
	private String lastName;    // last name of the employee
	private String userName;   // username of the employee
	private String password;    // password of the employee
	private String address;     // address of the employee
	private String contactNo;   // contact number of the employee
	
	/**
	 Get the employee id of the employee.
	 @return The employee id of the employee
	 */
	public int getEmployeeId() {
		return employeeId;
	}
	
	/**
	 Set the employee id of the employee
	 @param employeeId The employee id of the employee
	 */
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	
	/**
	 Get the first name of the employee.
	 @return The first name of the employee
	 */
	public String getFirstName() {
		return firstName;
	}
	
	/**
	 Set the first name of the employee
	 @param firstName The first name of the employee
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	/**
	 Get the last name of the employee.
	 @return The last name of the employee
	 */
	public String getLastName() {
		return lastName;
	}
	
	/**
	 Set the last name of the employee
	 @param lastName The last name of the employee
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	/**
	 Get the user name of the employee.
	 @return The user name of the employee
	 */
	public String getUserName() {
		return userName;
	}
	
	/**
	 Set the user name of the employee
	 @param userName The user name of the employee
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	/**
	 Get the password of the employee.
	 @return The password of the employee
	 */
	public String getPassword() {
		return password;
	}
	
	/**
	 Set the password of the employee
	 @param password The password of the employee
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
	/**
	 Get the address of the employee.
	 @return The address of the employee
	 */
	public String getAddress() {
		return address;
	}
	
	/**
	 Set the address of the employee
	 @param address The address of the employee
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	
	/**
	 Get the contactno of the employee.
	 @return The contactno of the employee
	 */
	public String getContactNo() {
		return contactNo;
	}
	
	/**
	 Set the contactno of the employee
	 @param contactNo The contactno of the employee
	 */
	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}
	
}
