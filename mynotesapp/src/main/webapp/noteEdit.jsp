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
<style type="text/css">
#header
{
font-size:40px;
}
.dark
{
color:blue;
}
.cardborder
{
color:red;
}
.body {
  background-color: #088F8F;
 }

</style>
<title>Notes</title>
</head>
<body>
	<nav class="navbar navbar-expand-md navbar-light">
		<div>
			<a class="navbar-brand"></a>
		</div>
		<ul class="navbar-nav">
		<b><h2>NOTES</h2></b>
			<li><a href="<%=request.getContextPath()%>/NotesServlet"
				class="nav-link">Back to List of Notes</a></li>
		</ul>
	</nav>
	<div class="container col-md-6">
		<div class="card">
			<div class="card-body" style= 'border:3px solid #000000;float:left;height:100%;width:100%;'>
				<c:if test="${note != null}">
					<form action="update" method="post">
				</c:if>
				<c:if test="${note == null}">
					<form action="insert" method="post">
				</c:if>
				<caption>
					<h2><font style="text-decoration: underline;">
						<c:if test="${note != null}">
						<div class="dark" align="center">
						
Edit Note
</c:if>
</div>
						<!--<c:if test="${user == null}">
Add New Note
</c:if>-->
</font>
					</h2>
				</caption>

					<input type="hidden" name="id"
						value="<c:out
value='${note.id}' />" />

				<fieldset class="form-group">
					<label><h2><b>Title:</b></h2></label> <input type="text"
						value="<c:out
value='${note.title}' />" class="form-control"
						name="title" required="required">
				</fieldset>
				<fieldset class="form-group">
					<label><h2><b>Note:</b></h2></label> <input type="text"
						value="<c:out
value='${note.note}' />" class="form-control"
						name="note">
				</fieldset>
				<button type="submit" class="btn btn-success" >Save</button>
				</form>
			</div>
		</div>
	</div>

</body>
</html>