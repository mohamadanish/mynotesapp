
<!DOCTYPE html>
<html>
<head>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<title>User Management Application</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<nav class="navbar navbar-expand-md navbar-light">
		<div>
			<a class="navbar-brand"> User Management Application </a>
		</div>
		<ul class="navbar-nav">
			<li><a
				href="<%=request.getContextPath()%>/ProfileServlet/profile"
				class="nav-link">Back to Dashboard</a></li>
		</ul>
	</nav>

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
						name="username" required="required">
				</fieldset>
				<fieldset class="form-group">
					<label>Password</label> <input type="text"
						value="<c:out
value='${user.password}' />" class="form-control"
						name="password">
				</fieldset>
				<fieldset class="form-group">
					<label>User Email</label> <input type="text"
						value="<c:out
value='${user.email}' />" class="form-control"
						name="email">
				</fieldset>
				<fieldset class="form-group">
					<label> Address</label> <input type="text"
						value="<c:out
value='${user.address}' />" class="form-control"
						name="address">
				</fieldset>
				<fieldset class="form-group">
					<label> Phone</label> <input type="text"
						value="<c:out
value='${user.phone}' />" class="form-control"
						name="phone">
				</fieldset>
				<button type="submit" class="btn btn-success">Save</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>