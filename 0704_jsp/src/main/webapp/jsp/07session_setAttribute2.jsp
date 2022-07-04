<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>07session_setAttribute2.jsp</title>
	</head>
	<body>
		<h1>07session_setAttribute2.jsp</h1>
		<h2>session.getArribute("session_date1") : 
			<%= session.getAttribute("session_data1")%> </h2>
		<h2>session.getArribute("session_time1") : 
			<%= session.getAttribute("session_time1")%> </h2>
		
	</body>
</html>