<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/content.css">
<title>Insert title here</title>
</head>
<body>
	<div id="wrap" align="center">

		<form method="post" name="frm" action = "contentUpdate">
			<input type="hidden" name="code" value="${movie.code}"> 
			<input type="hidden" name="nonmakeImg" value="${movie.pictureUrl}">
			<table>
				<tr>
					<td><c:choose>
							<c:when test="${empty movie.pictureUrl}">
								<img src="upload/noimage.gif">
							</c:when>
							<c:otherwise>
								<img src="upload/${movie.pictureUrl}">
							</c:otherwise>
						</c:choose></td>
					<td>
						<table>
							<tr>
								<th style="width: 80px">제 목</th>
								<td><input type="text" name="title" value="${movie.title}"
									size="80"></td>
							</tr>
							<tr>
								<th>사 진</th>
								<td><input type="file" name="pictureUrl"><br>
									(주의사항 : 이미지를 변경하고자 할때만 선택하시오)</td>
							</tr>
							<tr>
								<th>설 명</th>
								<td><textarea cols="90" rows="10" name="description"> ${movie.description}</textarea></td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
			<p>
				<c:if test="${loginUser.admin == 1}">
					<input type="submit" value="수정">
					<input type="reset" value="다시 작성">
					<input type="button" value="목록" onclick="location.href='Movie'">
					<input type="button" value="삭제" onclick="location.href='contentDelete?code=${movie.code }'">
				</c:if>
		</form>
	</div>
</body>
</html>