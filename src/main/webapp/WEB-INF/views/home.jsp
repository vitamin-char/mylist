<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "header.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>mylist</title>
<script src="<c:url value='/resources/js/jquery-3.4.1.min.js'/>"></script>
<link href="<c:url value='/resources/css/home.css'/>" rel="stylesheet" type = "text/css">
</head>
<body>
	<div class="content_wrap">
	<c:forEach items="${list }" var="row">
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
                    <a href="#"><img src="<c:url value='/resources/img/dislike.png'/>" id='like_img'></a>
                    <span class="cnt_wrap">${row.board_cnt}</span>
                </div>
                <div class="user_wrpap">
                    <a class="name_wrap">영일이삼사</a>
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
