<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form id="loginForm" name="login" class="signUp" action="${contextPath}/loginCheck" method="post">
		<label class="id" for="userId"></label> 
		<input type="text" name="userId" id="userId" 
		class="idinpt" required="required" placeholder="아이디"> 
		
		<label class="pw" for="userPw"></label>
		<input type="password" name="userPw" id="userPw" class="pwinpt"
		required="required" placeholder="비밀번호">
		
		<input type="submit" value="로그인" id="btnLogin" class="submit">
	</form>
	
	<section id="warning">
		<c:out value = "${msg}"/>
	</section>

</body>
</html>