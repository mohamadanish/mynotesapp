<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<style>
.header {
	text-align: center;
}

.form {
	text-align: center;
}

.container {

}
</style>
<title>Insert title here</title>
</head>
<body>
	<div class="header">
		<h1>New Reminder</h1>
	</div>
	<div class="form">
		<form action="NewRemindersServlet" method="post">
			<div class="container">
				<br> <br> Start date: <input type="datetime-local"
					name="startdate"> <br> <br> End date: <input
					type="datetime-local" name="enddate"> <br> <br>
				Reminder: <input type="text" name="task"> <br> <br>
				<input type="submit" value="Add reminder" />
			</div>
		</form>
	</div>
</body>
</html>