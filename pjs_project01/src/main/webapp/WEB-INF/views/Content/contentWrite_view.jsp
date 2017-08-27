<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
		<form method="post" name="frm" action = "contentWrite">
			<table>
				<tr>
					<th>코드</th>
					<td><input type="text" name="code"></td>
				</tr>
				<tr>
					<th>제목</th>
					<td><input type="text" name="title" size="80"></td>
				</tr>
				<tr>
					<th>작성자</th>
					<td><input type="text" name="userid"
						value="${ loginUser.userid}"></td>
				</tr>
				<tr>
					<th>사진</th>
					<td><input type="file" name="pictureUrl"><br>
						(주의사항 : 이미지를 변경하고자 할 경우만 선택하세요.)</td>
				</tr>
				<tr>
					<th>설명</th>
					<td><textarea cols="80" rows="10" name="description"></textarea>
					</td>
			</table>
			<input type="submit" value="등록">
			<input type="reset" value = "다시작성">
			<input type="button" value="목록" onclick="location.href='Movie'">
		</form>
	</div>

</body>
</html>