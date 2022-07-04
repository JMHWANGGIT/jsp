<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<h1>memver variable</h1>
		<h2>&lt! 로 선언된 변수는 멤버변수가 된다. </h2>
		<h2>&lt% 로 선언된 변수는 지역변수가 된다. </h2>
		<%! String str1 = new String("hello"); %>
		<% String str1 = new String("how are you"); %>
		<h2>멤버변수 출력 : <%= this.str1 %></h2>
		<h2>지역변수 출력 : <%= str1 %></h2>
		<h2>jsp의 출력태그 내부는 ; 을 생략한다. </h2>
		
	</body>
</html>