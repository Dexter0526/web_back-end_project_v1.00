<%@page import="com.pjs.project01.memberdao.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.sql.Connection"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		MemberDao memDao = MemberDao.getInstance();
		Connection conn = memDao.getConnection();
		out.println("MemberDAO DataBaseConnectionPool 연동 성공");
	%>
</body>
</html>