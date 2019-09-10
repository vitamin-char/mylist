<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "header.jsp" %>
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
<script src="<c:url value='/resources/js/switch.js'/>"></script>
<link href="<c:url value='/resources/css/home.css'/>" rel="stylesheet" type = "text/css">
</head>
<body>
	<div class="switch-wrapper">
		<form id="switchForm">		
		  	<input id="switchCheckbox" type="checkbox">
		  	<span class="switch-label">인기순</span>
		  	<label for="switchCheckbox" class="switch"></label>
		 	<span class="switch-label">최신순</span>
	 	</form>
	 </div>
	<%@ include file = "list.jsp" %>
</body>
</html>
