<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
	<html>
	<head>
		<meta charset="UTF-8">
		<title>05scriptlet2.jsp</title>
	</head>
	<body>
		<table border="1">
		
		<%
			for(int i = 1; i <= 10; i++){
		%>
				<tr><td><%= i %></tr></td>
		<%
			}
		%>
		
		</table>
	</body>
</html>