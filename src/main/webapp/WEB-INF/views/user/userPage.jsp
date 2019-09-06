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
    <div class="content_wrap">
	<c:forEach items="${list}" var="row" varStatus="status">
        <div class="list_wrap">
            <a href="#" class="movoe_modal">
            <c:forEach items="${row.music }" var="music">
            <div class="music_wrap">
                <div class="title_wrap">
                    ${music.music_title }
                </div>
                <div class="singer_wrap">
                   	${music.music_singer }
                </div>
            </div>
            </c:forEach>
            </a>
            <div class="information_wrap">
                <div class="heart_wrap">
                	<c:choose>
                	<c:when test="${row.like_plag eq 0}">
                   		<button class="like_btn" type="button" id="like_btn_${status.index}"
                   		name="like_${status.index}" onclick="fn_likeChk('${row.boardId}','${status.index}')">
                    		<img src="<c:url value='/resources/img/dislike.png'/>" id="like_img" >
                    	</button>
                    </c:when>
                    <c:otherwise>
                    	<button class="like_btn" type="button" id="like_btn_${status.index}"
                    	name="dislike_${status.index}" onclick="fn_likeChk('${row.boardId}','${status.index}')">
                    		<img src="<c:url value='/resources/img/like.png'/>" id="like_img">
                    	</button>
                    </c:otherwise>
                    </c:choose>
                    <span class="cnt_wrap" id="cnt_wrap_${status.index}">${row.board_cnt}</span>
                </div>
                <div class="user_wrpap">
                    <a class="name_wrap">${row.userName}</a>
                </div>
                
                <div class="description_wrap">
                   ${row.description}
                </div>
            </div>
        </div>
        </c:forEach>
    </div>
    <div class="upload_btn_wrap">
       <a href="${path}/board/write" class="add_btn">
           <img src="<c:url value='/resources/img/writeBtn.png'/>" class="add_img">
        </a>
    </div>
</body>
</html>