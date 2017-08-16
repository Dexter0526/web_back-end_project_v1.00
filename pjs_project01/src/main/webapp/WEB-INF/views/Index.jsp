<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/main.css">
<title>Index 페이지</title>
</head>
<body>
	<c:choose>
		<c:when test="${empty message }">
		</c:when>
		<c:otherwise>
			<script>
				alert("${message}")
			</script>
			<%
			HttpSession session2 = request.getSession();
			session2.setAttribute("message", "");
			%>
		</c:otherwise>
	</c:choose>

	<%@ include file="Header.jsp"%>

	<div class="container">
		<%@ include file="bar1.jsp"%>
	</div>

	<%@ include file="Footer.jsp"%>

</body>
</html>