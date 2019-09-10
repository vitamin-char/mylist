<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "../header.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>mylist</title>
<script>var path = "${path}";</script>
<script>var login = "${user}";</script>
<script src="<c:url value='/resources/js/jquery-3.4.1.min.js'/>"></script>
<script src="<c:url value='/resources/js/likeAction.js'/>"></script>
<script src="<c:url value='/resources/js/modal.js'/>"></script>
<link href="<c:url value='/resources/css/home.css'/>" rel="stylesheet" type = "text/css">
<link href="<c:url value='/resources/css/userPage.css'/>" rel="stylesheet" type = "text/css">
</head>
<body>
	<div class="profile_wrap">
        <div class="profile_cover">
        <c:if test="${user.userId != '' && user.userId eq User.userId }">
        <div class="setting_wrap">
            <a href="${path}/user/edit" class="add_btn">
           		<img src="<c:url value='/resources/img/setting.png'/>" class="setting_img">
            </a>
        </div>
        </c:if>
        <div class="user_name_wrap">
        	${User.userName}
        </div>
        <div class="activity_wrap">
            <div class="activity_cout_wrap">
                <p class="activity_label">활동</p>
                <a href="${path}/userPage?userId=${User.userId}" class="count_btn">${write_cnt}</a>
            </div>
            <div class="activity_cout_wrap">
                <p class="activity_label">좋아요</p>
                <a href="${path}/userPage?userId=${User.userId}&srt=2" class="count_btn">${like_cnt}</a>
            </div>
        </div>
        </div>
    </div>
   <%@ include file = "../list.jsp" %>
</body>
</html>