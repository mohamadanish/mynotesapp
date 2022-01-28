<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="signup-form">
						<h2 class="form-title">Sign up</h2>
					
						<form method="post" action="RegisterServlet" class="register-form"
							id="register-form">
							<div class="form-group">
								<label for="username"><i
									class="zmdi zmdi-account material-icons-name"></i></label> <input
									type="text" name="username" id="username" placeholder="Your Username" />
							</div>
							<div class="form-group">
								<label for="password"><i class="zmdi zmdi-email"></i></label> <input
									type="password" name="password" id="password" placeholder="Your Password" />
							</div>
							<div class="form-group">
								<label for="cfmPassword"><i class="zmdi zmdi-lock"></i></label> <input
									type="password" name="cfmPassword" id="cfmPassword" placeholder="Confirm Password" />
							</div>
							<div class="form-group">
								<label for="email"><i class="zmdi zmdi-lock-outline"></i></label>
								<input type="email" name="email" id="email"
									placeholder="Your Email" />
							</div>
							<div class="form-group">
								<label for="phone"><i class="zmdi zmdi-lock-outline"></i></label>
								<input type="text" name="phone" id="phone"
									placeholder="Phone no" />
							</div>
							<div class="form-group">
								<label for="address"><i class="zmdi zmdi-lock-outline"></i></label>
								<input type="text" name="address" id="address"
									placeholder="Address" />
							</div>
							<div class="form-group form-button">
								<input type="submit" name="register" id="register"
									class="form-submit" value="Register" />
							</div>
						</form>
					</div>
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