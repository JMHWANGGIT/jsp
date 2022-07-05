<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>10RE_err_page.jsp</title>
	</head>
	<body>
		<%@ include file="./header.jsp" %>
		<%-- jsp 여러줄 주석 : 서버에서 서블릿 변환시에 삭제 : 클라이언트에서 안보임 --%>
		<h1><%= session.getAttribute("err_msg") %></h1>
		<%@ include file="./footer.jsp" %>
	</body>
</html>