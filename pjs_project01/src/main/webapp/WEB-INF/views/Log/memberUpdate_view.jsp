<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/js/member.js"></script>
<title>Insert title here</title>
</head>
<body>
	<center>
		<h2>회원 수정</h2>
		<form name="frm" action="update" method="post">
			<table>
				<tr>
					<td>이름</td>
					<td><input type="text" name="name" size="20"
						value="${loginUser.name}" readonly></td>
				</tr>
				<tr>
					<td>아이디</td>
					<td><input type="text" name="userid" size="20"
						value="${loginUser.userid}" readonly></td>
				</tr>
				<tr>
					<td>암 &nbsp; 호</td>
					<td><input type="password" name="pwd" size="20">*</td>
				</tr>
				<tr height="30">
					<td width="80">암호 확인</td>
					<td><input type="password" name="pwd_check" size="20">
						*</td>
				</tr>
				<tr>
					<td>이메일</td>
					<td><input type="text" name="email" size="20"
						value="${loginUser.email}"></td>
				</tr>
				<tr>
					<td>전화번호</td>
					<td><input type="text" name="phone" size="20"
						value="${loginUser.phone}"></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="submit" value="확인"
						onclick="return joinCheck()">
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input type="reset" value="취소">
					</td>
				</tr>
			</table>
		</form>
	</center>
</body>
</html>