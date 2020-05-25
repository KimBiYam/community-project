<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/resources/css/default.css" />
</head>
<body>
	home
	<br>
	<sec:authorize access="isAnonymous()">
		<a href="/member/login">로그인 페이지</a>
		<a href="/member/join">회원가입 페이지</a>
	<br>
	</sec:authorize>

	<sec:authorize access="isAuthenticated()">
		<a href="/member/logout">로그아웃</a>
	</sec:authorize>

</body>
</html>