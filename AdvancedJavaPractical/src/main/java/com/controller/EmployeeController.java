package com.controller;

import java.io.IOException;

import com.model.EmployeeModel;
import com.service.EmployeeService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EmployeeController
 * This servlet handles requests related to employee operation such as adding  employees data
 */
@WebServlet("/EmployeeController")
public class EmployeeController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public EmployeeController() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * Handles POST requests for adding employee data
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");     // get action value to understand which operation to perform on data
		
		// to add data in database
		if(action.equals("Add")) {          
			EmployeeModel employeeModel = new EmployeeModel();     // creating object of employee model
			
			// set values in employee model
			employeeModel.setFirstName(request.getParameter("firstname"));
			employeeModel.setLastName(request.getParameter("lastname"));
			employeeModel.setUserName(request.getParameter("username"));
			employeeModel.setPassword(request.getParameter("password"));
			employeeModel.setAddress(request.getParameter("address"));
			employeeModel.setContactNo(request.getParameter("contactno"));
			
			int executeQuery = new EmployeeService().addEmployeeDetails(employeeModel);   // add employee details to the database
			
			if(executeQuery > 0) {
				// if the data insertion is successful, forward to display.jsp
				request.getRequestDispatcher("display.jsp").forward(request, response);
			} else {
				// if the insertion fails, forward to registration.jsp
				request.getRequestDispatcher("registration.jsp").forward(request, response);
			}	
		} 
	}

}
