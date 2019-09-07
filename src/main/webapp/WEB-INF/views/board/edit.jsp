<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "../header.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>mylist</title>
<script>var path = "${path}";</script>
<script src="<c:url value='/resources/js/jquery-3.4.1.min.js'/>"></script>
<script src="<c:url value='/resources/js/boardWrite.js'/>"></script>
<link href="<c:url value='/resources/css/boardWrite.css'/>" rel="stylesheet" type = "text/css">
</head>
<body>
	<div class="content_wrap">
        <form onsubmit="return replace_name()" action="${path}/board/update" id="listForm" method="post">
        	<input type="hidden" name="boardId" value="${board.boardId}">
            <h2>곡</h2>
            <div class="list_wrap">
            <c:forEach items="${board.music}" var="row" varStatus="status">
            <div class="music_wrap" id="music_wrap">
                <div class="name_wrap">
                    <input type="text" name="music_title" class="musicInpt" 
                    required="required" placeholder="제목" value="${row.music_title}">
                </div>
                <div class="singer_wrap">
                    <input type="text" name="music_singer" class="singerInpt" 
                    required="required" placeholder="가수" value="${row.music_singer}">
                </div>
                <c:if test="${status.count > 3}">
	            <div class="del_music"> 
	            	<button class="del_btn" type="button" onclick="remove_item(this)">
	            		<img src="<c:url value='/resources/img/x-mark.png'/>" class="del_img"> 
	            	</button> 
	            </div>
           		 </c:if>
            </div>
            </c:forEach>
            
            <div id="field"></div> 
            
            <div class="add_music">
                <button class="add_btn" type="button" onclick="add_item()">
                    <img src="<c:url value='/resources/img/writeBtn.png'/>" class="add_img">
                </button>
            </div>
            </div>
            
            <h2>설명</h2>
            <div class="description_wrap">
                <textarea name="description" class="description" rows="4"
                required="required" placeholder="설명과 #태그를 입력해주세요">${board.description}</textarea>
            </div>
            <div class="description_wrap">
            	<input type="submit" class="list_submit_btn" value="수정하기">
            </div>
        </form>
    </div>
</body>
</html>