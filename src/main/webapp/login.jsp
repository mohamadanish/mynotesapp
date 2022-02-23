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
		<section class="sign-in">
			<div class="container">
				<div class="signin-content">
					<div class="signin-content">
						<div class="signin-image">
							<figure>
								<img src="images/notesapp.png" alt="sign up image">
							</figure>
							<a href="register.jsp" class="signup-image-link">Create
								an account</a>
						</div>




						<div class="signin-form">
							<h2 class="form-title">Sign in</h2>
							<form method="post" action="Login" class="register-form" name="myForm"
								id="login-form">
								<div class="form-group">
									<label for="username"><i
										class="zmdi zmdi-account material-icons-name"></i></label> <input
										type="text" name="username" id="username" required
										placeholder="Your Name" />
								</div>
								<div class="form-group">
									<label for="password"><i class="zmdi zmdi-lock"></i></label> <input
										type="password" name="password" id="password" required
										placeholder="Password" />
								</div>
								<div class="form-group form-button">
									<input type="submit" name="signin" id="signin"
										class="form-submit" value="Log in"/>
								</div>
							</form>
						</div>
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
		if (status == "failed") {
			swal("Sorry", "Invalid Username or Password!", "error");
		}
		
		function validate() {
			var username = document.myForm.value;
			if(username="") {
				alert("Username cannot be empty!");
				document.myForm.username.focus();
				return false;
			}
			
			var password = document.myForm.password.value;
			if(password=""){
				alert("Password cannot be empty!");
				document.myForm.upassword.focus();
				return false;

			}
		}
	</script>

</body>
</html>