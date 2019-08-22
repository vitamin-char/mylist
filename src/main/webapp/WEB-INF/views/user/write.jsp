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
</head>
<body>
	<form id="write" method="post">
		<div class="title">*이름</div>
		<input type="text" name="userName" id="userName" class="inpt name"
			required="required" maxlength="16"> <br>

		<div class="title">*아이디</div>
		<input type="text" name="userId" id="userId" class="inpt id"
			required="required" maxlength="20"> 
			<a href="#" id="user_id_checkBtn" class="ck">중복확인</a> <br>
		<div class="text">*아이디는 4~20자의 영문 대소문자와 숫자로만 입력하세요.</div>

		<div class="title">*비밀번호</div>
		<input type="password" name="userPw" id="userPw" class="inpt pw"
			required="required" maxlength="20"> <br>
		<div class="text">*패스워드는 10~20자의 영문 대소문자와 숫자, 특수문자를 혼합하여 입력하세요.</div>
		<div class="title">*비밀번호 확인</div>
		<input type="password" name="rePw" id="rePw" class="inpt pw"
			required="required" maxlength="20"> <br>
		
		<div class="btn">
			<ul>
				<li class="item"><a href="${path}/">취소</a></li>
				<li class="item"><a href="#" id="signUpBtn">회원가입</a></li>
			</ul>
		</div>
	</form>

</body>
</html>