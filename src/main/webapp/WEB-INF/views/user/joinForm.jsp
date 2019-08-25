<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>mylist</title>
<script>var path = "${path}";</script>
<script src="<c:url value='/resources/js/jquery-3.4.1.min.js'/>"></script>
<script src="<c:url value='/resources/js/joinCheck.js'/>"></script>
<link href="<c:url value='/resources/css/login.css'/>" rel="stylesheet" type = "text/css">
</head>
<body>
 <div class="inner_wrap">
 	<h1 class="logo_title">
 		<a href="${path}/">MYLIST</a>
 	</h1>
 	<h2 class="form_title">회원가입</h2>
	<form id="write" method="post">
		<div class="name_wrap">
			<input type="text" name="userName" id="userName" class="nameInpt"
				required="required" maxlength="20" placeholder="이름">
		</div>
		
		<div class="id_wrap">
			<input type="text" name="userId" id="userId" class="idInpt"
			required="required" maxlength="20" placeholder="아이디 (4~20자의 영문 대소문자와 숫자로만 입력)"> 
			<div class="check_wrap">
				<a href="#" id="user_id_checkBtn" class="ck">중복확인</a>
			</div>
		</div>
			
		<div class= "pw_wrap">
			<input type="password" name="userPw" id="userPw" class="pwInpt"
				required="required" maxlength="20"  placeholder="비밀번호 (영문 대소문자와 숫자, 특수문자 혼합하여 10자 이상 입력)">
	
			<input type="password" name="rePw" id="rePw" class="pwInpt"
				required="required" maxlength="20"  placeholder="비밀번호 확인">
		</div>
		
		<div class="btn">
			<button id="signUpBtn">회원가입</button>
		</div>
	</form>
 </div>
</body>
</html>