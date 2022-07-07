<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>17fb_write.jsp</title>
</head>
<body>
	<%@include file="./header.jsp" %>
	<form id="form1" action="<%=rootPath%>/FBList17" method="post">
	<input type="hidden" name="cmd" value="write">
	<table class="table table-hover">
		<tbody>
			<tr>
				<td>제목</td>
				<td>
					<input type="text" id="title" name="title" maxlength="50"
						class="form-control">
				</td>
			</tr>
			<tr>
				<td>작성자</td>
				<td>
					<input type="text" id="writer" name="writer" maxlength="20"
						class="form-control">
				</td>
			</tr>
			<tr>
				<td>내용</td>
				<td>
					<textarea rows="20" cols="10" id="cnts" name="cnts"
						class="form-control"></textarea>
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<button type="button" id="btn1"
						class="btn btn-success float-right"> 글 쓰 기 </button>
				</td>
			</tr>
		</tbody>
	</table>
	</form>
	<%@include file="./footer.jsp" %>
	<script type="text/javascript">
	$(document).ready(function() {
		$("#btn1").click(function() {
			if($.trim($("#title").val()) == ""){
				alert("제목을 입력하세요");
				return;
			}//title
			if($.trim($("#writer").val()) == ""){
				alert("작성자를 입력하세요");
				return;
			}//writer
			if($.trim($("#cnts").val()) == ""){
				alert("내용을 입력하세요");
				return;
			}//cnts
			
			$("#form1").submit();
		});//click
	});//ready
	</script>
</body>
</html>