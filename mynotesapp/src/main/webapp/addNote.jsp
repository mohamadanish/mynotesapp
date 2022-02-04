<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
</head>
<body>
	<div class="container col-md-6">
		<div class="card">
			<div class="card-body">
				<h1>Add new note here</h1>
				<form action="AddNoteServlet" method="post">
					UserId:<input type="text" name="userid"><br>
					<br> Title: <input type="text" name="title"><br>
					<br> Note: <input type="text" name="note"><br>
					<br> <input type="submit" value="Add note" />
					</form>
			</div>
		</div>
	</div>

	<div class="container text-left">
		<!-- Add new note button redirects to the addNote.jsp page -->
			<a href="<%=request.getContextPath()%>/NotesServlet" class="btn btn-warning" >Back to List of Notes</a>
	</div>

</body>
</html>