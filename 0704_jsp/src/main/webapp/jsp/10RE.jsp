<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>10RE.jsp</title>
	</head>
	<body>
		<%@ include file="./header.jsp" %>
		<!-- action = "http://localhost:8080/0704_jsp/RE10" -->
		<form action="../RE10" method="get">
			이름검색 : <input type="text" id="ename" name="ename">
			<hr>
			<button type="submit"> SEARCH </button>
			<%@ include file="./footer.jsp" %>
		</form>
	</body>
</html>