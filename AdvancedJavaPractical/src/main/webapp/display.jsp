<%@page import="com.service.EmployeeService"%>
<%@page import="java.util.List"%>
<%@page import="com.model.EmployeeModel"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee Details</title>
<link rel="stylesheet" type="text/css" href="css/tableStyles.css">
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.3.0/font/bootstrap-icons.css" />

</head>
<body>

<div class="container">
        <h1>Employee Data</h1>
         <!-- Back button with arrow icon -->
    	<a href="registration.jsp" class="btn btn-secondary">
        <i class="bi bi-arrow-left"></i> Back
    	</a>
    	
        <table>
            <thead>
                <tr>
                	<th>Employee Id</th>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>User Name</th>
                    <th>Password</th>
                    <th>Address</th>
                    <th>Contact No.</th>
                    <th>Update</th>
                    <th>Remove</th>
                </tr>
            </thead>
            <tbody>
		<!-- create list and get all employee details from database -->
                <%
			List<EmployeeModel> employees = new EmployeeService().getEmployeeDetails();
			for(EmployeeModel employee : employees) {
		%>
                <tr>
                    !-- get the data from employee model and showing it to table -->
                    <td data-label="First Name"> <%= employee.getEmployeeId() %> </td>
                    <td data-label="First Name"> <%= employee.getFirstName() %> </td>
                    <td data-label="Last Name"> <%= employee.getLastName() %> </td>
                    <td data-label="User Name"> <%= employee.getUserName() %> </td>
                    <td data-label="Password"> <%= employee.getPassword() %> </td>
                    <td data-label="Address"> <%= employee.getAddress() %> </td>
                    <td data-label="Contact No."> <%= employee.getContactNo() %> </td>
                                        
                </tr>
                <%
		`	}
                %>
            </tbody>
        </table>
</div>

</body>
</html>
