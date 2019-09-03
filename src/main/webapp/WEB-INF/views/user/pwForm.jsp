<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "../header.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>mylist</title>
<script src="<c:url value='/resources/js/jquery-3.4.1.min.js'/>"></script>
<link href="<c:url value='/resources/css/edit.css'/>" rel="stylesheet" type = "text/css">
</head>
<body>
 	<div class="side_menu">
        <div class="menu_item">
            <a  href="${path}/user/edit" class="menu_link">
            	<img src="<c:url value='/resources/img/user.png'/>" class="menu_img" >
             	회원 정보 수정
            </a>
        </div>
        <div class="menu_item">
            <a class="menu_link">
            	<img src="<c:url value='/resources/img/lock.png'/>" class="menu_img" >
         		비밀번호 변경
            </a>
        </div>
    </div>
    <div class="content_wrap">
 	<h2 class="form_title">비밀번호 변경</h2>
	<form id="write" method="post" action="${path}/user/pwUpdate">
        <div class="pw_wrap">
            <label>현재 비밀번호</label>
			<input type="password" name="userPw" id="userPw" class="pwInpt"
				required="required" maxlength="20" placeholder="현재 비밀번호 확인">
		</div>
		<div class="pw_wrap">
            <label>새 비밀번호</label>
			<input type="password" name="newPw" id="userPw" class="pwInpt"
				required="required" maxlength="20"  placeholder="새 비밀번호 (영문 대소문자와 숫자, 특수문자 혼합하여 8자 이상 입력)">
				
			<label>새 비밀번호 확인</label>
			<input type="password" name="rePw" id="rePw" class="pwInpt"
				required="required" maxlength="20"  placeholder="새 비밀번호 확인">
		</div>
		
		<div class="btn">
			<button id="editBtn">수정하기</button>
		</div>
		<div id="warning">
			<c:out value = "${warning}"/>
		</div>
	</form>
 </div>
</body>
</html>