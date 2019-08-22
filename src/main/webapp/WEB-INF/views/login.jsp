<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="<c:url value='/resources/css/login.css'/>" rel="stylesheet" type = "text/css">
</head>
<body>
 <div class="inner_wrap">
 	<h1 class="logo_title">MYLIST</h1>
 	<h2 class="login_title">로그인</h2>
	<form id="loginForm" name="login" class="signUp" action="${path}/loginCheck" method="post">
		<div class="inpt_wrap">
		<input type="text" name="userId" id="userId" 
		class="idinpt" required="required" placeholder="아이디"> 
		</div>
		
		<input type="password" name="userPw" id="userPw" class="pwinpt"
		required="required" placeholder="비밀번호">
		
		<input type="submit" value="로그인" id="btnLogin" class="submit">
	</form>
	
	<div id="join_section">
		회원이 아니신가요? <a class="join" href = "${path}/user/write">회원가입</a>
	</div>
	
	<div id="warning">
		<c:out value = "${msg}"/>
	</div>
 </div>
</body>
</html>