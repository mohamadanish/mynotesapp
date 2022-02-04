<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<title>My Notes App</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<meta charset="ISO-8859-1">
<title>Notes</title>
</head>
<body>
	<nav class="navbar navbar-expand-md navbar-light">
		<div>
			<a class="navbar-brand"> Edit Notes </a>
		</div>
		<ul class="navbar-nav">
			<li><a href="<%=request.getContextPath()%>/NotesServlet"
				class="nav-link">Back to List of Notes</a></li>
		</ul>
	</nav>
	<div class="container col-md-6">
		<div class="card">
			<div class="card-body">
				<c:if test="${note != null}">
					<form action="update" method="post">
				</c:if>
				<c:if test="${note == null}">
					<form action="insert" method="post">
				</c:if>
				<caption>
					<h2>
						<c:if test="${note != null}">
Edit Note
</c:if>
						<c:if test="${user == null}">
Add New Note
</c:if>
					</h2>
				</caption>

					<input type="hidden" name="id"
						value="<c:out
value='${note.id}' />" />

				<fieldset class="form-group">
					<label>Title</label> <input type="text"
						value="<c:out
value='${note.title}' />" class="form-control"
						name="title" required="required">
				</fieldset>
				<fieldset class="form-group">
					<label>Note</label> <input type="text"
						value="<c:out
value='${note.note}' />" class="form-control"
						name="note">
				</fieldset>
				<button type="submit" class="btn btn-success">Save</button>
				</form>
			</div>
		</div>
	</div>

</body>
</html>