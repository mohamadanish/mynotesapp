<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	if(session.getAttribute("username")==null) {
		response.sendRedirect("login.jsp"); 
	}
	%>
    
<!DOCTYPE html>
<html>
<head>

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
<meta charset="UTF-8">
<title>Home</title>
</head>
<body>
<!-- 
<div style="background-image: url('/images/bg.jpeg');">
</div>  -->

<nav>
		<div class="logo">
			<p>MYNOTESAPP</p>
		</div>
		<ul>
			<li><a href="userHome.jsp" class="active">Home</a></li>
			<li><a href="">Notes</a></li>
			<li><a href="">Reminders</a></li>
			<li><a href="AdminServlet/dashboard">Admin</a></li>
			<li><a href="logout">logout</a></li>
			<li><a href="ProfileServlet/profile"><%=session.getAttribute("username") %></a></li>
		</ul>
	</nav>
	<img src="<%=request.getContextPath() + "/images/notesapp.png"%>">
	<h1>Welcome To MyNotesApp</h1>
	<div style="margin-top:50%;">HIBYE</div>
</body>

</html>