<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body>

	<input type="hidden" id="status"
		value="<%=request.getAttribute("status")%>">
	<div class="main">
		<section class="signup">
			<div class="container">
				<div class="signup-content">



					<div class="signup-form">
						<h2 class="form-title">Sign Up</h2>

						<form method="post" action="RegisterServlet" class="register-form"
							id="register-form" name="myForm">
							<div class="form-group">
								<label for="username"><i
									class="zmdi zmdi-account material-icons-name"></i></label> <input
									type="text" name="username" id="username" required
									placeholder="Your Username" />
							</div>
							<div class="form-group">
								<label for="password"><i class="zmdi zmdi-email"></i></label> <input
									type="password" name="password" id="password" required
									placeholder="Your Password" />
							</div>
							<div class="form-group">
								<label for="cfmPassword"><i class="zmdi zmdi-lock"></i></label>
								<input type="password" name="cfmPassword" id="cfmPassword"
									required placeholder="Confirm Password" />
							</div>
							<div class="form-group">
								<label for="email"><i class="zmdi zmdi-lock-outline"></i></label>
								<input type="email" name="email" id="email" required
									placeholder="Your Email" />
							</div>
							<div class="form-group">
								<label for="phone"><i class="zmdi zmdi-lock-outline"></i></label>
								<input type="text" name="phone" id="phone" required
									minlength="8" maxlength="8" placeholder="Phone no" />
							</div>
							<div class="form-group">
								<label for="address"><i class="zmdi zmdi-lock-outline"></i></label>
								<input type="text" name="address" id="address" required
									placeholder="Address" />
							</div>
							<div class="form-group form-button">
								<input type="submit" name="register" id="register"
									class="form-submit" value="Register" />
							</div>
						</form>
					</div>
					<div class="signup-image">
						<figure>
							<img src="images/notesapp.png" alt="sign up image">
						</figure>
						<a href="login.jsp" class="signup-image-link">I am already a
							user</a>
					</div>
				</div>
			</div>
		</section>
	</div>

	<script src="vendor/jquery/jquery.min.js"></script>
	<script src="js/main.js"></script>
	<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
	<link rel="stylesheet" href="alert/dist/sweetalert.css">
	<script type="text/javascript">
	
	var status = document.getElementById("status").value;
	if (status == "success") {
		swal("Congratulations", "You have create an account successfully",
				"success");
	}
		var password = document.getElementById("password"), confirm_password = document
				.getElementById("cfmPassword");

		function validatePassword() {
			if (password.value != confirm_password.value) {
				confirm_password.setCustomValidity("Passwords Don't Match");
			} else {
				confirm_password.setCustomValidity('');
			}
		}

		password.onchange = validatePassword;
		confirm_password.onkeyup = validatePassword;
	</script>
	<!-- <form action ="RegisterServlet" method = "post">
	Name: <input type="text" name = "userName">
	Password: <input type="password" name = "password">
	Confirm Password: <input type="password" name = "confirmPassword">
	Email: <input type="text" name="email">
	address: <input type="text" name="phone">
	Phone: <input type="text" name="phone">
	
	
	<input type="submit" value="Call Servlet"/>
</form> -->

</body>
</html>