$(document).ready(function() {

	$('#firstname').on('input', function() {
		validateName('firstname');
		checkFormValidity();
	});

	$('#lastname').on('input', function() {
		validateName('lastname');
		checkFormValidity();
	});

	$('#username').on('input', function() {
		validateUserName();
	});

	$('#password').on('input', function() {
		validatePassword();
		checkFormValidity();
	});

	$('#address').on('input', function() {
		validateAddress();
		checkFormValidity();
	});

	$('#contactno').on('input', function() {
		validateContact();
	});


	$('input').on('keydown', function(event) {
		if (event.keyCode == 13) {
			event.preventDefault();
			return false;
		}
	});

	// function to validate first name and last name
	function validateName(fieldId) {
		var fieldValue = $('#' + fieldId).val();
		var isNameValid = /^[a-zA-Z]+$/.test(fieldValue);

		if (fieldValue === '') {
			$('#' + fieldId + '-error').text(fieldId === 'firstname' ? 'First name cannot be empty.' : 'Last name cannot be empty.');
			$('#' + fieldId).addClass('error');
		} else if (!isNameValid) {
			$('#' + fieldId + '-error').text(fieldId === 'firstname' ? 'First name can only contain alphabets.' : 'Last name can only contain alphabets.');
			$('#' + fieldId).addClass('error');
		} else if (fieldValue.length < 2) {
			$('#' + fieldId + '-error').text(fieldId === 'firstname' ? 'First name must be at least 2 characters long.' : 'Last name must be at least 2 characters long.');
			$('#' + fieldId).addClass('error');
		} else if (fieldValue.length > 30) {
			$('#' + fieldId + '-error').text(fieldId === 'firstname' ? 'First name must not be longer than 30 characters.' : 'Last name must not be longer than 30 characters.');
			$('#' + fieldId).addClass('error');
		} else {
			$('#' + fieldId + '-error').text('');
			$('#' + fieldId).removeClass('error');
		}
	}

	// function to validate username by sending ajax request to servlet file
	function validateUserName() {
		var username = $('#username').val();

		$.ajax({
			type: "POST",
			url: "CheckUsername",
			data: { username: username },
			success: function(response) {
				if (response.trim() !== "") {
					// if response is not empty, it means there's an error
					$('#username-error').text(response);
					$('#username').addClass('error');
				} else {
					// if response is empty, means no error so remove error class
					$('#username-error').text('');
					$('#username').removeClass('error');
				}
				checkFormValidity();
			},
			error: function(xhr, status, error) {
				// Handle error if AJAX request fails
				console.error(xhr.responseText);
			}
		});
	}

	// function to vlidate password
	function validatePassword() {
		var password = $('#password').val();
		var isPasswordValid = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]+$/.test(password);

		if (password === '') {
			$('#password-error').text('Password cannot be empty.');
			$('#password').addClass('error');
		} else if (!isPasswordValid) {
			$('#password-error').text('Password must contain at least one upper-case, lower-case, digit and special character');
			$('#password').addClass('error');
		} else if (password.length < 8) {
			$('#password-error').text('Password must be at least 8 characters long.');
			$('#password').addClass('error');
		} else if (password.length > 20) {
			$('#password-error').text('Password must not be longer than 20 characters.');
			$('#password').addClass('error');
		} else {
			$('#password-error').text('');
			$('#password').removeClass('error');
		}
	}

	// function to validate address
	function validateAddress() {
		var address = $('#address').val();
		var isAddressContainAlphabets = /[a-zA-Z]{4,}/.test(address);     // expression for address to must contain at least 4 alphabets characters

		if (address === '') {
			$('#address-error').text('Address cannot be empty.');
			$('#address').addClass('error');
		} else if (address.length < 4) {
			$('#address-error').text('Address must be at least 4 characters long.');
			$('#address').addClass('error');
		} else if (!isAddressContainAlphabets) {
			$('#address-error').text('Address must contain at least 4 alphabetic characters.');
			$('#address').addClass('error');
		} else if (address.length > 70) {
			$('#address-error').text('Address must not be longer than 70 characters.');
			$('#address').addClass('error');
		} else {
			$('#address-error').text('');
			$('#address').removeClass('error');
		}
	}

	// function to validate contact number by sending ajax request to servlet file 
	function validateContact() {
		var contact = $('#contactno').val();

		$.ajax({
			type: "POST",
			url: "CheckContactNumber",
			data: { contact, contact },
			success: function(response) {
				if (response.trim() !== "") {
					// if response is not empty, it means there's an error
					$('#contactno-error').text(response);
					$('#contactno').addClass('error');
				} else {
					// if response is empty, means no error so remove error class
					$('#contactno-error').text('');
					$('#contactno').removeClass('error');
				}
				checkFormValidity();
			},
			error: function(xhr, status, error) {
				// Handle error if AJAX request fails
				console.error(xhr.responseText);
			}
		});
	}

	// Function to check if all fields are valid and enable form submission
	function checkFormValidity() {
		var isValid = true;
		$('.formbold-form-input').each(function() {
			if ($(this).hasClass('error') || $(this).val().trim() === '') {
				isValid = false;
				return false;  // Exit loop early if any field is invalid
			}
		});

		if (isValid) {
			$('button').removeClass('disabled').addClass('clickable'); // make submit button clickable
		} else {
			$('button').removeClass('clickable').addClass('disabled');
		}

		return isValid;
	}

	// function to handle show and hide functionality for password
	$('#togglePassword').click(function() {
		var passwordField = $('#password');
		var fieldType = passwordField.attr('type');
		passwordField.attr('type', fieldType === 'password' ? 'text' : 'password');
		$(this).toggleClass('bi-eye bi-eye-slash');
	});

	// handle form submission
	$('form').submit(function(event) {
		event.preventDefault(); // Prevent default form submission

		showAlert();
	});

	// Function to show alert modal
	function showAlert() {
		document.getElementById("customAlertMessage").textContent = 'Details saved successfully!';
		$('#customAlertModal').modal('show');
	}

	// Function to handle OK button click in alert modal
	$('#okButton').click(function() {
		$('#customAlertModal').modal('hide'); // Hide the modal
		submitForm(); // Submit the form
	});

	// Function to submit the form
	function submitForm() {
		$('form')[0].submit(); // Submit the form
	}

});
