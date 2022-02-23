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
<style type="text/css">
.body {
  background-color: #088F8F;
}
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
img{
	width: 20%;
	height: 0px auto;
	margin-left:40%;
	margin-top:10%;
}
body {
  background-color: #088F8F;
} 
h1 {
font-size:370%;
font-family:Copperplate;
text-align:center;
color:white;
}
 </style>
 
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
	<div class="row">
		<div class="container">
			<h3 class="text-center">List of Reminders</h3>
			<hr>
			<div class="container text-left">
				<!-- Add new user button redirects to the register.jsp page -->
				<a href="<%=request.getContextPath()%>/NewReminders.jsp"
					class="btn btn-success">Add New Reminders</a>
			</div>
			<br>
			<!-- Create a table to list out all current users information -->
			<table class="table table-light table-striped" style="width:1000px;" >
				<thead class="thead-dark">
					<tr>
						<th>Start Date</th>
						<th>Due Date</th>
						<th>Task</th>
						<th>Action</th>
					</tr>
				</thead>
				<!-- Pass in the list of users receive via the Servlet’s response to a loop
-->
				<tbody>
					<c:forEach var="reminder" items="${listReminders}">
						<!-- For each user in the database, display their
information accordingly -->
						<tr>
							<td><c:out value="${reminder.startdate}" /></td>
							<td><c:out value="${reminder.enddate}" /></td>
							<td><c:out value="${reminder.task}" /></td>
							<!-- For each user in the database, Edit/Delete
buttons which invokes the edit/delete functions -->
							<td><a href="edit?id=<c:out value='${reminder.id}'
/>">Edit</a>
								&nbsp;&nbsp;&nbsp;&nbsp; <a
								href="delete?id=<c:out
value='${reminder.id}' />">Delete</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</body>