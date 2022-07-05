<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page errorPage="./11err_handling.jsp" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>11err_test.jsp</title>
	</head>
	<body>
		<%-- 의도적인 에러 발생 -> errorPage로 이동 --%>
		<%
			String tmp = null;
			out.print(tmp.length());
		%>
	</body>
</html>