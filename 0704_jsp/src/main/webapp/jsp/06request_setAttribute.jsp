<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>06request_setAttribute.jsp</title>
	</head>
	<body>
		<%@ include file="./header.jsp" %>
		<h1>jsp data의 전달범위</h1>
		<h2>page 범위 : jsp 페이지 내부에서만 의미있는 data : 
			해당 페이지를 벗어나면 data는 사라진다.</h2>
		<h2>request 범위 : request 내부에서 의미가 있는 data : 
			해당 reqeust를 벗어나면 data는 사라진다.</h2>
		<h2>session 범위 : session 내부에서 의미가 있는 data :
			해당 session을 벗어나면(웹브라우저를 꺼버릴 경우) data는 사라진다. </h2>
		<h2>application(context; 프로젝트 하나당 하나씩 생성.) 범위 : WAS가 살아있는동안 의미있는 데이터 : 
			서버를 끄면 data는 사라진다. </h2>
		<form action="./06request_setAttribute2.jsp">
			text data : <input type="text" name="txt" id="txt" value="text data">
			<hr>
			hidden data : <input type="hidden" name="hid" id="hid" value="hidden data">
			<hr>
			<button type="submit"> request의 범위 </button> 
		</form>
		<%@ include file="./footer.jsp" %>
	</body>
</html>