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

<script type="text/javascript">
// sending ajax request to EmployeeController, alert will show as per the response get from servlet whether data deleted or not
$(document).ready(function() {
	$('.remove-link').click(function(event) {
		var username = $(this).data('username');
		$.ajax ({
			type: "POST",
			url: "EmployeeController",
			data: {
				action : 'Remove',
				username : username
				},
			success: function(response) {
				if(response === 'success') {
					 $('#customAlertMessage').text('Employee data removed successfully.');
	                 
	                 $('#okButton').click(function() {
	                	 window.location.href = 'registration.jsp';
	                  });
				} else {
					$('#customAlertMessage').text('Failed to remove employee details.');
				}
				$('#customAlertModal').modal('show');
			},
			error: function() {
                $('#customAlertMessage').text('Failed to remove employee.');
                $('#customAlertModal').modal('show');
            }
		});
	});
});
</script>

</head>
<body>
<%
EmployeeModel employeeModel = (EmployeeModel) request.getAttribute("employee");

if(employeeModel != null) {
%>
<div class="container">
        <h1>Employee Data</h1>
        <table>
            <thead>
                <tr>
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
                
                <tr>
                    <td data-label="First Name"> <%= employeeModel.getFirstName() %> </td>
                    <td data-label="Last Name"> <%= employeeModel.getLastName() %> </td>
                    <td data-label="User Name"> <%= employeeModel.getUserName() %> </td>
                    <td data-label="Password"> <%= employeeModel.getPassword() %> </td>
                    <td data-label="Address"> <%= employeeModel.getAddress() %> </td>
                    <td data-label="Contact No."> <%= employeeModel.getContactNo() %> </td>
                    <td data-label="Update"><a href="update.jsp?firstname=<%= employeeModel.getFirstName() %>&lastname=<%= employeeModel.getLastName() %>&username=<%= employeeModel.getUserName() %>&password=<%= employeeModel.getPassword() %>&address=<%= employeeModel.getAddress() %>&contactno=<%= employeeModel.getContactNo() %>">Update Data</a></td>
                    <td data-label="Remove"><a href="#" class="remove-link" data-username="<%= employeeModel.getUserName() %>">Remove Data</a></td>
                </tr>
                <%
					}
                %>
            </tbody>
        </table>
</div>
   
<!-- Modal HTML For Customized Alert-->
<div class="modal fade" id="customAlertModal" tabindex="-1" role="dialog" aria-labelledby="customAlertModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="customAlertModalLabel">Alert</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body" id="customAlertMessage">
        <!-- Alert message will be dynamically inserted here -->
      </div>
      <div class="modal-footer">
        <button type="button" id="okButton" class="btn btn-secondary" data-dismiss="modal">Ok</button>
      </div>
    </div>
  </div>
</div>

</body>
</html>
