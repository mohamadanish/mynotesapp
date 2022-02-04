<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<meta charset="ISO-8859-1">
<title>All notes</title>
</head>
<body>
	<div class="row">
		<div class="container">
			<h3 class="text-center">List of Notes</h3>
			<hr>
			<div class="container text-left">
				<!-- Add new note button redirects to the addNote.jsp page -->
				<a href="<%=request.getContextPath()%>/addNote.jsp" 
					class="btn btn-success">Add New Note</a>
			</div>
			<br>
			<!-- Create a table to list out all current notes information -->
			<table class="table">
				<thead>
					<tr>
						<th>Title</th>
						<th>Note</th>
					</tr>
				</thead>
				<!-- Pass in the list of notes receive via the Servlet’s response to a loop
-->
				<tbody>
					<c:forEach var="notes" items="${listNotes}">
						<!-- For each user in the database, display their
information accordingly -->
						<tr>
							<td><c:out value="${notes.title}" /></td>
							<td><c:out value="${notes.note}" /></td>
							<!-- For each note in the database, Edit/Delete
buttons which invokes the edit/delete functions -->
							<td><a href="edit?note=<c:out value='${notes.note}'
/>">Edit</a>
								&nbsp;&nbsp;&nbsp;&nbsp; <a
								href="delete?note=<c:out
value='${notes.note}' />">Delete</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>

</body>
</html>