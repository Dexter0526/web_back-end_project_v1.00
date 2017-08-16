<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/js/member.js"></script>
<title>Insert title here</title>
</head>
<body>
	<h2>아이디 중복확인</h2>
	<form name = "frm" action = "idCheck_forward" method = "get">
		아이디 : <input type = "text" name = "userid">
		<input type = "submit" value = "중복 체크"><br>
		
		<c:if test = "${result ==1 }">
			<script type = "text/javascript">
				oener.document.frm.userid.value = "";
			
			alert("${userid }는 이미 사용 중인 아이디입니다.")
			</script>
		</c:if>
		<c:if test = "${result == -1 }">
			${userid }는 사용 가능한 아이디입니다.
			<input type ="button" value = "사용" class= "cancel" onclick = "idok('${userid}')">
		</c:if>
		
	</form>
</body>
</html>