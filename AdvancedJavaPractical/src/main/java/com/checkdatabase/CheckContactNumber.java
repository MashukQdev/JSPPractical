package com.checkdatabase;

import java.io.IOException;

import com.service.EmployeeService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CheckContactNumber
 * This servlet handles the validation of contact numbers.
 * It checks if the contact number is:
 * - Not empty
 * - Contains only digits
 * - Within the acceptable length range (10 to 17 characters)
 * - Not already registered in the database
 */
@WebServlet("/CheckContactNumber")
public class CheckContactNumber extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public CheckContactNumber() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * Handles the HTTP POST request.
	 * @see HttpServletdoPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String contactNumber = request.getParameter("contact");    // get value pf parameter 'contact' send by ajax request
		boolean isValidNumber = contactNumber.matches("\\d+");    // expression to check contact number contains only numbers or not
		
		if(contactNumber.isEmpty()) {
			response.getWriter().write("Contact No cannot be empty.");
			return;
		} else if(!isValidNumber) {
			response.getWriter().write("Contact No must contain only digits.");
			return;
		} else if(contactNumber.length() < 10) {
			response.getWriter().write("Contact No must be at least 10 character long.");
			return;
		} else if(contactNumber.length() > 17) {
			response.getWriter().write("Contact No must not be longer than 17 characters.");
			return;
		} else if(new EmployeeService().checkContactExists(contactNumber)) {
			response.getWriter().write("Contact No already register.");
			return;
		} else {
			response.getWriter().write("");
			return;
		}
	}

}

