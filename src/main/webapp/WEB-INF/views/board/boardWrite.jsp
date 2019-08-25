<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "../header.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>mylist</title>
<script src="<c:url value='/resources/js/jquery-3.4.1.min.js'/>"></script>
<script src="<c:url value='/resources/js/boardWrite.js'/>"></script>
<link href="<c:url value='/resources/css/boardWrite.css'/>" rel="stylesheet" type = "text/css">
</head>
<body>
	<div class="content_wrap">
        <form id="listForm">
            <h2>곡</h2>
            <div class="list_wrap">
            <div class="music_wrap">
                <div class="name_wrap">
                    <input type="text" name="musicName" id="musicName" class="musicInpt"
				    required="required" placeholder="제목">
                </div>
                <div class="singer_wrap">
                    <input type="text" name="singerName" id="singerName" class="singerInpt"
				    required="required" placeholder="가수">
                </div>
            </div>
            
            <div id="pre_set" style="display:none">
                <div class="music_wrap">
                    <div class="name_wrap">
                        <input type="text" name="musicName" id="musicName" class="musicInpt"
				    required="required" placeholder="제목">
                    </div>
                    <div class="singer_wrap">
                        <input type="text" name="singerName" id="singerName" class="singerInpt"
				    required="required" placeholder="가수">
                    </div>
                    
                    <div class="del_music">
                        <button class="del_btn" type="button" onclick="remove_item(this)">
                            <img src="<c:url value='/resources/img/x-mark.png'/>" class="del_img">
                        </button>
                    </div>
                </div>
            </div>
            
            <div id="field"></div> 
            
            <div class="add_music">
                <button class="add_btn" type="button" onclick="add_item()">
                    <img src="<c:url value='/resources/img/writeBtn.png'/>" class="add_img">
                </button>
            </div>
            </div>
            <h2>설명</h2>
            <div class="description_wrap">
                <textarea name="description" id="description" class="description" rows="4"
                placeholder="설명과 #태그를 입력해주세요" required="required"></textarea>
            </div>
            <div class="description_wrap">
                <button class="list_submit_btn" type="submit">공유하기</button>
            </div>
        </form>
    </div>
</body>
</html>