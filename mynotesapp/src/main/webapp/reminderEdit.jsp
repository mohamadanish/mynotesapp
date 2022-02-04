<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<title>User Management Application</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<nav class="navbar navbar-expand-md navbar-light">
		<div>
			<a class="navbar-brand"> User Management Application </a>
		</div>
		<ul class="navbar-nav">
			<li><a
				href="<%=request.getContextPath()%>/RemindersServlet/dashboard"
				class="nav-link">Back to Dashboard</a></li>
		</ul>
	</nav>
	<div class="container col-md-6">
		<div class="card">
			<div class="card-body">
				<c:if test="${reminder != null}">
					<form action="update" method="post">
				</c:if>
				<c:if test="${reminder == null}">
					<form action="insert" method="post">
				</c:if>
				<caption>
					<h2>
						<c:if test="${reminder != null}">
Edit Reminder
</c:if>
						<c:if test="${reminder == null}">
Add New Reminder
</c:if>
					</h2>
				</caption>
				<c:if test="${reminder != null}">
					<input type="hidden" name="startdate"
						value="<c:out
value='${reminder.startdate}' />" />
				</c:if>
				<fieldset class="form-group">
					<label>Start Date</label> <input type="datetime-local"
						value="<c:out
value='${reminder.enddate}' />"
						class="form-control" name="enddate" required="required">
				</fieldset>
				<fieldset class="form-group">
					<label>Due date</label> <input type="datetime-local"
						value="<c:out
value='${reminder.task}' />" class="form-control"
						name="task">
				</fieldset>
				<fieldset class="form-group">
					<label>Task</label>
				</fieldset>
				<button type="submit" class="btn btn-success">Save</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>