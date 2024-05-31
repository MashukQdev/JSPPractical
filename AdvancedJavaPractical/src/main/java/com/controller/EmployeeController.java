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
 * This servlet handles requests related to employee operations such as adding, updating, and removing employees data
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
	 * Handles POST requests for adding, updating, and removing employee data
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
				request.setAttribute("employee", employeeModel);
				request.getRequestDispatcher("display.jsp").forward(request, response);
			} else {
				// if the insertion fails, forward to registration.jsp
				request.getRequestDispatcher("registration.jsp").forward(request, response);
			}
			
		} else if(action.equals("Update")) {        // update employee data in database
			EmployeeModel employeeModel = new EmployeeModel();
			
			employeeModel.setFirstName(request.getParameter("firstname"));
			employeeModel.setLastName(request.getParameter("lastname"));
			employeeModel.setUserName(request.getParameter("username"));
			employeeModel.setPassword(request.getParameter("password"));
			employeeModel.setAddress(request.getParameter("address"));
			employeeModel.setContactNo(request.getParameter("contactno"));
			
			String oldUsername = request.getParameter("oldusername");   // get old username so that we an update in database for that row only
			
			// update employee details in the database
			int executeQuery = new EmployeeService().updateEmployeeDetails(employeeModel, oldUsername);
			
			if(executeQuery > 0) {
				// if the update is successful, forward to display.jsp
				request.setAttribute("employee", employeeModel);
				request.getRequestDispatcher("display.jsp").forward(request, response);
			} else {
				// if the update fails, forward to registration.jsp
				request.getRequestDispatcher("registration.jsp").forward(request, response);
			}
			
		} else if(action.equals("Remove")) {          // remove employee data from the database
			String username = request.getParameter("username");
			
			// remove employee details from the database
			int executeQuery = new EmployeeService().removeEmployeeDetails(username);
			
			if(executeQuery > 0) {
				// if the removal is successful, respond with "success"
				response.getWriter().write("success");
				return;
			} else {
				// if the removal fails, respond with "not success"
				response.getWriter().write("not success");
				return;
			}
		}
	}

}
