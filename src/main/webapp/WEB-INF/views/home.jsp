<%@page import="com.vitaminchar.mylist.vo.UserVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="path" value="${pageContext.request.contextPath}" />
<%UserVO login = (UserVO)session.getAttribute("login"); %>
<html>
<head>
<title>Home</title>
</head>
<body>
	<h1>Hello world!</h1>

	<P>The time on the server is ${serverTime}.</P>

	<%if(login == null){ %>
		<ul class="sign">
			<li><a id="login" href = "${path}/login"><strong>로그인</strong></a></li>
			<li><a id="join" href = "${path}/user/write"><strong>회원가입</strong></a></li>
		</ul>
	<%}else{ %>
		<ul class="sign">
			<li><a id="logout" href = "${path}/logout"><strong>로그아웃</strong></a></li>
		</ul>
	<%} %>
</body>
</html>
