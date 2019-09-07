<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "header.jsp" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
</head>
<body>
	<div class="content_wrap">
	<c:forEach items="${list}" var="row" varStatus="status">
        <div class="list_wrap">
            <a onclick="modal_open('${row.boardId}')">
            <c:forEach items="${row.music}" var="music">
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
                <c:if test="${login.userId eq row.userId}">
                <div class="option_wrap">
                	<a class="option_menu_btn">
                		<img src="<c:url value='/resources/img/option.png'/>" id="option_img">
                	</a>
                	<ul>
                		<li>
                			<a href="${path}/board/edit?boardId=${row.boardId}">
                			<img src="<c:url value='/resources/img/edit.png'/>" id="edit_img">수정
                			</a>
                		</li>
                		<li>
                			<a href="${path}/board/delete?boardId=${row.boardId}">
                			<img src="<c:url value='/resources/img/delete.png'/>" id="delete_img">삭제
                			</a>
                		</li>
                	</ul>
                </div>
                </c:if>
                <div class="user_wrap">
                    <a href="${path}/userPage?userId=${row.userId}" class="name_wrap">${row.userName}</a>
                </div>
                <div class="description_wrap">
                   ${row.description}
                </div>
                <div class="date_wrap">
                <fmt:formatDate value="${row.board_date}" pattern="yyyy.MM.dd"/>
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
    
	<div id="modal">
    <div class="modal_content">
        <button type="button" id="modal_close_btn">
        	<img src="<c:url value='/resources/img/x-mark.png'/>" class="close_btn">
        </button>
        <div class="modal_information_wrap">
            <div class="user_wrap">
                <a id="modal_name_wrap"></a>
            </div>
            <div id="modal_description_wrap">
            </div>
       </div>
       <div id="music_content">
       </div>
    </div>
    <div class="modal_layer"></div>
	</div>
</body>
</html>
