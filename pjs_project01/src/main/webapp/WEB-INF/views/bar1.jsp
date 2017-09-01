<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/main.css">
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/js/member.js"></script>
<title>Insert title here</title>
</head>
<body>
	<div class="category">

		<div class="log">

			<c:choose>

				<c:when test="${empty loginUser }">
					<form name="frm" action="login" method="post">
						ID : <input type="text" name="userid">
						<p>
							PW : <input type="password" name="pwd">
						<p>
							<input type="submit" value="로그인" onclick="return loginCheck()">&nbsp;
							<input type="reset" value="취소"> &nbsp; <input
								type="button" value="회원가입" onclick="location.href='join_view'">
						<p>
					</form>
				</c:when>
				<c:otherwise>
					<form action="logout">
						${loginUser.name}(${loginUser.userid})님
						<p>
							<input type="submit" value="로그아웃"> &nbsp; <input
								type="button" value="회원정보변경" onclick="location.href='memberUpdate_view?userid=${loginUser.userid}'">
					</form>
				</c:otherwise>
			</c:choose>

		</div>
		<br>

		<center class="top">카테고리</center>
		<ol class="top">
			<li><a href="Movie?userid = ${loginUser.userid }">영화 </a></li>
			<li><a href="Variety?userid = ${loginUser.userid }"> 예능 </a></li>
			<li><a href="News?userid = ${loginUser.userid }"> 시사 </a></li>
			<li><a href="Docu?userid = ${loginUser.userid }"> 다큐 </a></li>
			<li><a href="board?userid = ${loginUser.userid }"> 게시판 </a></li>
			<c:if test="${loginUser.admin == 1}">
				<li><a href="contentWrite_view"> 등록 </a></li>
			</c:if>
		</ol>
	</div>
</body>
</html>