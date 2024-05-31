package com.checkdatabase;

import java.io.IOException;

import com.service.EmployeeService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CheckUsername
 * This servlet handles the validation of usernames
 * It checks if the username is:
 * - Not empty
 * - Within the acceptable length range (4 to 30 characters)
 * - Not already registered in the database
 */
@WebServlet("/CheckUsername")
public class CheckUsername extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public CheckUsername() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");   // get username sent by ajax request 
		
		if(username.isEmpty()) {       // check if user name field is empty or not 
			response.getWriter().write("User name cannot be empty.");
			return;
			
		} else if(username.length() < 4) {       // check is user name length is less than 4 
			response.getWriter().write("User name must be at least 4 character long.");
			return;
			  
		} else if(username.length() > 30) {     // check is user name length is more than 30
			response.getWriter().write("User name must not be longer than 30 characters.");
			return;
			
		} else if(new EmployeeService().isUserNameExists(username)) {       // check is user name already exists in database
			response.getWriter().write("User name already register. Please use another one.");
			return;
			
		} else {
			response.getWriter().write("");
			return;
		}
	}

}
