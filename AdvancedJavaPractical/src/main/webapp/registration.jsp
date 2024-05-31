<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee Registration Form</title>
<link rel="stylesheet" type="text/css" href="css/styles.css">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.3.0/font/bootstrap-icons.css" />
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
    
<!-- java script file  -->
<script src="js/validation.js"></script> 

</head>
<body>

<div class="formbold-main-wrapper">
  <!-- Author: FormBold Team -->
  <!-- Learn More: https://formbold.com -->
  <div class="formbold-form-wrapper">

    <form action="EmployeeController" method="POST" onsubmit="showAlert();">
      <div class="formbold-form-title">
        <h2 class="">Employee Registration Form</h2>
        <span class="hestrick-note">(Note: * indicate required field)</span>
      </div>
      
      <div class="formbold-mb-4">
        <label for="address" class="formbold-form-label"> First Name <span class="hestrick">*</span> </label>
        <input type="text" name="firstname" id="firstname" class="formbold-form-input" onkeydown="return event.key != 'Enter';"/>
        <span id="firstname-error" class="error-message"></span>
      </div>

      <div class="formbold-mb-4">
        <label for="address" class="formbold-form-label"> Last Name <span class="hestrick">*</span> </label>
        <input type="text" name="lastname" id="lastname" class="formbold-form-input"/>
        <span id="lastname-error" class="error-message"></span>
      </div>
      
      <div class="formbold-mb-4">
        <label for="address" class="formbold-form-label"> User Name <span class="hestrick">*</span> </label>
        <input type="text" name="username" id="username" class="formbold-form-input"/>
        <span id="username-error" class="error-message"></span>
      </div>
      
      <div class="formbold-mb-3">
        <label for="address" class="formbold-form-label"> Password <span class="hestrick">*</span> </label>
        <input type="password" name="password" id="password" class="formbold-form-input"/>
        <i class="bi bi-eye-slash" id="togglePassword"></i>
        <span id="password-error" class="error-message"></span>
      </div>
      
      <div class="formbold-mb-4">
        <label for="address" class="formbold-form-label"> Address <span class="hestrick">*</span> </label>
        <input type="text" name="address" id="address" class="formbold-form-input"/>
        <span id="address-error" class="error-message"></span>
      </div>
      
      <div>
        <label for="address" class="formbold-form-label"> Contact No. <span class="hestrick">*</span> </label>
        <input type="text" name="contactno" id="contactno" class="formbold-form-input"/>
        <span id="contactno-error" class="error-message"></span>
      </div>
	  <input type="hidden" name="action" value="Add">
      <button id="submitBtn" class="formbold-btn disabled">Register Now</button>
    </form>
  </div>
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