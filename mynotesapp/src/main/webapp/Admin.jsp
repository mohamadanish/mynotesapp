<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>
<nav>
		<div class="logo">
			<p>MYNOTESAPP</p>
		</div>
		<ul>
			<li><a href="<%=request.getContextPath()%>/userHome.jsp" class="active">Home</a></li>
			<li><a href="<%=request.getContextPath()%>/NotesServlet">Notes</a></li>
			<li><a href="<%=request.getContextPath()%>/RemindersServlet/dashboard">Reminders</a>
			<li><a href="<%=request.getContextPath()%>/AdminServlet/dashboard">Admin</a></li>
			<li><a href="<%=request.getContextPath()%>/logout">logout</a></li>
			<li><a href="<%=request.getContextPath()%>/ProfileServlet/profile"><%=session.getAttribute("username") %></a></li>
		</ul>
	</nav>
	<br>
	<h3 style="margin-left:45%;">List of Users</h3>
	
	<div class="row">
		<div class="container">
			
			<div class="container text-left">
				<!-- Add new user button redirects to the register.jsp page -->
				<a href="<%=request.getContextPath()%>/register.jsp"
					class="btn btn-warning">Add New User</a>
			</div>
			<br>
			<!-- Create a table to list out all current users information -->
			<table class="table table-light table-striped"  style="width:100%;">
				<thead class="thead-dark">
					<tr>
						<th>Name</th>
						<th>Password</th>
						<th>Email</th>
						<th>Address</th>
						<th>Phone</th>
						<th>Actions</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="user" items="${listUsers}">
						<!-- For each user in the database, display their
information accordingly -->
						<tr>
							<td><c:out value="${user.username}" /></td>
							<td><c:out value="${user.password}" /></td>
							<td><c:out value="${user.email}" /></td>
							<td><c:out value="${user.address}" /></td>
							<td><c:out value="${user.phone}" /></td>
							
							<!-- For each user in the database, Edit/Delete
buttons which invokes the edit/delete functions -->
							<td><a href="edit?id=<c:out value='${user.id}'/>">Edit</a>&nbsp;&nbsp;&nbsp;&nbsp; 
							<a href="delete?id=<c:out 
							value='${user.id}' />">Delete</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>

</body>
<style>
@import url('https://fonts.googleapis.com/css2?family=Poppins:wght@200;400;500&display=swap');
*{
	margin:0px;
	padding:0px;
	box-sizing: border-box;
	font-family: 'Poppins', sans-serif;
}
nav{
	width: 100%;
	height: 75px;
	background-color: #505d61;
	line-height: 75px;
	padding:0px 100px;
}
nav .logo{
	font-size: 30px;
	font-weight: bold;
	letter-spacing: 1.5px; 
}
nav .logo p{
	float: left;
	color:#fff;
	text-transform: uppercase;
}
nav ul{
	float: right;
}
nav ul li{
	display: inline-block;
	list-style: none;
}
nav ul li a{
	color:#fff;
	text-decoration: none;
	font-size: 18px;
	text-transform: uppercase;
	padding:0px 32px;
}
nav ul li a:hover{
	color:#c0d96f;
}
nav ul li .active{
	color:#c0d96f;
}
/* img{
	width: 30%;
	height: 0px auto;
	padding-top:1%;
	margin-left:35%;
}
.card {
  box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2);
  width: 50%;
  margin: auto;
  text-align: center;
  font-family: arial;
  margin-top: 2%;
} */
body {
  background-color: #088F8F;
} 
 </style>
</html>