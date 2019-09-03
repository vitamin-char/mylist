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
            <a class="menu_link">
            	<img src="<c:url value='/resources/img/user.png'/>" class="menu_img" >
             	회원 정보 수정
            </a>
        </div>
        <div class="menu_item">
            <a href="${path}/user/passWord" class="menu_link">
            	<img src="<c:url value='/resources/img/lock.png'/>" class="menu_img" >
         		비밀번호 변경
            </a>
        </div>
    </div>
    <div class="content_wrap">
 	<h2 class="form_title">회원 정보 수정</h2>
	<form id="write" method="post" action="${path}/user/update" >
        <div class="id_wrap">
            <label>아이디</label>
			<input type="text" name="userId" id="userId" class="idInpt"
			maxlength="20" value="${user.userId}" readonly="readonly"> 
		</div>
		<div class="name_wrap">
            <label>이름</label>
			<input type="text" name="userName" id="userName" class="nameInpt"
				required="required" maxlength="20" value="${user.userName}">
		</div>
		
		<div class="btn">
			<button id="editBtn">수정하기</button>
		</div>
	</form>
 </div>
</body>
</html>