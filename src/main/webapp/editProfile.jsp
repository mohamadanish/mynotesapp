<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<title>Your Profile</title>


<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	
</style>
</head>
<body>
<div style="background-image: url('bg.jpeg');">
</div>

	<nav class="navbar navbar-expand-md navbar-light">
		<div>
			<a class="navbar-brand"> Edit Profile</a>
		</div>
		<ul class="navbar-nav">
			<li><a
				href="<%=request.getContextPath()%>/ProfileServlet/profile"
				class="nav-link">Back to Profile</a></li>
		</ul>
	</nav>
	
	<%-- <nav>
		<div class="logo">
			<p>MYNOTESAPP</p>
		</div>
		<ul>
			<li><a href="http://localhost:8090/mynotesapp/userHome.jsp" class="active">Home</a></li>
			<li><a href="">Notes</a></li>
			<li><a href="">Reminders</a></li>
			<li><a href="AdminServlet/dashboard">Admin</a></li>
			<li><a href="logout">logout</a></li>
			<li><a href="<%=request.getContextPath()%>/ProfileServlet/profile"><%=session.getAttribute("username") %></a></li>
		</ul>
	</nav> --%>

	<div class="container col-md-6">
		<div class="card">
			
			<div class="card-body">
				<c:if test="${user != null}">
					<form action="update" method="post">
				</c:if>
				<caption>
					<h2>
						<c:if test="${user != null}">
							Edit User
						</c:if>
					</h2>
				</caption>
				<c:if test="${user != null}">
					<input type="hidden" name="id"
						value="<c:out
value='${user.id}' />" />
				</c:if>
				<fieldset class="form-group">
					<label>Username</label> <input type="text"
						value="<c:out
value='${user.username}' />" class="form-control"
						name="username" required>
				</fieldset>
				<fieldset class="form-group">
					<label>Password</label> <input type="text"
						value="<c:out
value='${user.password}' />" class="form-control"
						name="password" required>
				</fieldset>
				<fieldset class="form-group">
					<label>User Email</label> <input type="text"
						value="<c:out
value='${user.email}' />" class="form-control"
						name="email" required>
				</fieldset>
				<fieldset class="form-group">
					<label> Address</label> <input type="text"
						value="<c:out
value='${user.address}' />" class="form-control"
						name="address" required>
				</fieldset>
				<fieldset class="form-group">
					<label> Phone</label> <input type="text"
						value="<c:out
value='${user.phone}' />" class="form-control"
						name="phone" minlength="8" maxlength="8" required>
				</fieldset>
				<button type="submit" class="btn btn-warning">Save</button>
				</form>
			</div>
		</div>
	</div>
</body>
<style>
body {
  background-color: #088F8F;
} 
</style>
</html>