<%@page import="java.util.ArrayList"%>
<%@page import="java.util.HashMap,java.util.HashSet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%><%--반드시 필요한 선언 --%>
<%-- response.setcontentType("text/html; charset=UTF-8"); --%>
<%-- response.setCharacterEncoding("UTF-8"); --%>
<!DOCTYPE html>
<html>
<head>
		<meta charset="UTF-8">
		<title>01start.jsp</title>
	</head>
	<body>
		<%-- 01start.jsp -> 01start_jsp.java(서블릿파일) -> 01start_jsp.class --%>    
		<%--
			jsp 주석 	: 여러줄 주석 가능 
			: jsp주석은 client에서 보이지 않는다. (jsp는 servlet이므로 )  
		--%>
		<%-- jsp의 html코드들은 서블릿으로 변환되어 out.print("html code");로 실행된다. --%>
		<%-- jsp 주석은 서블릿으로 변환되면서 사라지기 때문에 클라이언트에서 보이지 않음 --%>
		jsp태그 내부에 서블릿 코딩을 한다. 
		<h2>jsp태그는 &lt%로 시작하고, %&gt로 끝난다.</h2>
		<h2>&lt% jsp 서블릿 코딩 태그 %&gt</h2>
		<h2>&lt%! jsp에 멤버변수 /메소드 선언태그 %&gt </h2>
		<h2>&lt%= jsp 출력 태그 %&gt</h2>
		<h2>&lt%@ jsp 페이지선언 태그 %&gt</h2>
		<h2>&lt%-- jsp 주석태그 %&gt</h2>
		
		<hr>
		
		<%!String memStr = "자바 문자열 변수 선언"; %>
		<h2><%=memStr %></h2>
		<%!
			private String sayHello(){
				return "hi";	
			}
		%>
		<h2><%=sayHello() %></h2>
		
		<%
			String localStr = "문자열 지역 변수";
// 			private int plus(int a, int b){//error - 메소드는 &lt! 에서 선언. 
// 				return a + b;
// 			}
			
		%>
		<h2><%= localStr %></h2>
		
		<%
			ArrayList<String> list = new ArrayList<String>();
			HashMap<String, String> map = new HashMap<String, String>();
			HashSet<String> set = new HashSet<String>();
		%>
	</body>
</html>