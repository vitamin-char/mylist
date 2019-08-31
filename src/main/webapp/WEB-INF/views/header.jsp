<%@page import="com.mylist.vo.UserVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<%UserVO login = (UserVO)session.getAttribute("login");
%>
<c:set var="user" value="${login}"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="<c:url value='/resources/css/header.css'/>" rel="stylesheet" type="text/css">
</head>
<body>
	<div class="inner_wrap">
		<div class="inner">
			<h1 class="logo_wrap">
				<a href="${path}/" id="logo">MYLIST</a>
			</h1>
			<div class="search_wrap">
				<form id="searchForm" name="search" class="search" action="${path}/search" method="post">
					<input type="text" name="keyword" id="keyword" class="keyword" 
					required="required" placeholder="곡 제목, 가수, 태그를 검색하세요">
					<input type="submit" value="검색" id="btnSearch" class="submit">
				</form>
			</div>
			
			<%if(login == null){ %>
				<ul class="sign">
					<li><a href="${path}/login">로그인</a></li>
					<li><a href="${path}/user/write">회원가입</a></li>
				</ul>
			<%}else{ %>
				<ul class="sign">
					<li><a href = "${path}/userPage?userId=<%=login.getUserId()%>">마이페이지</a></li>
					<li><a href = "${path}/logout">로그아웃</a></li>
				</ul>
			<%} %>
		</div>
	</div>
</body>
</html>