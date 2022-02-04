<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="NewRemindersServlet" method="post">
User ID: <input type="text" name="userid">
Start date: <input type="datetime-local" name="startdate">
End date: <input type="datetime-local" name="enddate">
Reminder: <input type="text" name="task">
<input type="submit" value="Call Servlet" />
</form>
</body>
</html>