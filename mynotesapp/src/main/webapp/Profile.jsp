<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Username: <%=session.getAttribute("id") %></h1>


 <%-- <table class="table">
				<thead>
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
					<c:forEach var="user" items="${listUser}">
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
						</tr>
					</c:forEach>
				</tbody>
			</table>  --%>
<input type = 'text' name ='username' value ='${username}' readonly>
  <input type = 'text' name ='password' value ='${password}'readonly>
   <input type = 'text' name ='email' value ='${email}'readonly>
   <input type = 'text' name ='address' value ='${address}'readonly>
   <input type = 'text' name ='phone' value ='${phone}'readonly> 
    <a type = 'submit' href="edit?id=<c:out  value='${id}'/>">Update</a> 
 
</body>
</html> 