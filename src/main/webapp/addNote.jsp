<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<meta charset="ISO-8859-1">
<style type="text/css">
#header {
	font-size: 40px;
}

.dark {
	color: blue;
}

.cardborder {
	color: red;
}

.centralise {
	margin-left: 45px;
}
.image{
	text-align:center;
	display: inline-block;
	vertical-align:middle;
	hoziontal-align:middle:
}
</style>

</head>
<br>
<br>
<br>
<body>
	<div class="container col-md-6" align="left">
		<div class="card">
			<div class="card-body"
				style='border: 3px solid #008000; float: left; height: 100%; width: 100%;'>
				<h1 class="dark" align="center">
					<img class="image" src ="images/newicon.jpg" /><br>
					<b><font style="text-decoration: underline;">Add A New Note Here:</font></b><br>
				</h1>
				
				<br>
				<form action="AddNoteServlet" method="post">
					<!--UserId:<input type="text" name="userid"><br>  -->
					<b class="centralise">Title: </b> <input class="centralise"
						type="text" name="title" style="width: 585px;"><br>
					<!-- Call a class within title and note to centralise the text boxes-->
					<br>
					<b class="centralise">Note: </b><input class="centralise"
						type="text" name="note" style="width: 585px;"><br>
					<div class="container text-center">
						<br><br> <input type="submit" class="btn btn-danger"
							value="Add note" style="width: 200px;" />
					</div>
				</form>
			</div>
		</div>
	</div>
	<br>
	<br>
	<br>
	<br>

	<div class="container text-center">
		<!-- Add back button to get back to note management -->
		<a href="<%=request.getContextPath()%>/NotesServlet"
			class="btn btn-secondary" style="width: 200px;"><b>Back to
				List of Notes</b></a>
	</div>

</body>
</html>