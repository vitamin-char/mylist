<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>mylist</title>
<script src="<c:url value='/resources/js/jquery-3.4.1.min.js'/>"></script>
<script>
	flag = 0;
	$(document).ready(function() {
		$("#user_id_checkBtn").unbind("click").click(function(e) {
			e.preventDefault();
			fn_userIDCheck();
		});
	});
	
	function fn_userIDCheck() {
		reg = /^[a-zA-Z0-9]{4,12}$/
		if (!check(reg, $("#userId"), "아이디는 4~12자의 영문 대소문자와 숫자로만 입력하세요.")) {
			return false;
		} 
		userId = $("#userId").val();
		
		if (userId.length < 1) {
			alert("아이디를 입력해주시기 바랍니다.");
		} else {
			$.ajax({
				type : "POST",
				url : "${path}/user/checkUserID",
				data: userId,
				contentType : "application/json; charset=UTF-8",
				success : function(result) {
					if (result == 0) {
						flag=1;
						alert("사용 가능한 아이디입니다.");
					} else if (result == 1) {
						flag=0;
						alert("이미 사용중인 아이디입니다.");
					} else {
						alert("에러가 발생하였습니다.");
					}
				},
				error : function(request, status, error) {
					alert("code:" + request.status + "\n" + "message:"
							+ request.responseText + "\n" + "error:" + error);
				}
			});
		}
	}
	$(document).ready(function() {
		$("#signUpBtn").unbind("click").click(function(e) {
			e.preventDefault();
			fn_signUp();
		});
	});

	function fn_signUp() {
		var reg_pw = /^.*(?=.{10,20})(?=.*[0-9])(?=.*[a-zA-Z]).*$/;
		
		if($("#userName").val() == 0){
	        alert("이름을 입력해 주세요"); 
	        $("#userName").focus();
	        return false;
	    }
		
		if($("#userId").val()==""){
	        alert("아이디를 입력해 주세요"); 
	        $("#userId").focus();
	        return false;
	    }
	    
	    if($("#userPw").val() == 0){
	        alert("비밀번호를 입력해 주세요"); 
	        $("#userPw").focus();
	        return false;
	    }
	    
		if(!check(reg_pw, $("#userPw"),"패스워드는 10~20자의 영문 대소문자와 숫자, 특수문자를 혼합하여 입력하세요.")) {
	           return false;
	    }
		
		if($("#userPw").val() != $("#rePw").val()) {
	           alert("비밀번호가 다릅니다. 다시 확인해 주세요.");
	           $("#rePw").val("");
	           $("#rePw").focus();
	           return false;
	    }
	    
		if (flag==0) {
			alert("아이디 중복체크를 해주세요.");
		} 
		else {
			$("#write").attr("action", "${path}/user/insert");
			$("#write").submit();
		}
	}

	function check(re, what, message) {
		if (re.test(what.val())) {
			return true;
		}
		alert(message);
		what.value = "";
		what.focus();
	}
</script>
</head>
<body>
	<form id="write" method="post">
		<div class="title">*이름</div>
		<input type="text" name="userName" id="userName" class="inpt name"
			required="required" maxlength="16"> <br>

		<div class="title">*아이디</div>
		<input type="text" name="userId" id="userId" class="inpt id"
			required="required" maxlength="20"> 
			<a href="#" id="user_id_checkBtn" class="ck">중복확인</a> <br>
		<div class="text">*아이디는 4~20자의 영문 대소문자와 숫자로만 입력하세요.</div>

		<div class="title">*비밀번호</div>
		<input type="password" name="userPw" id="userPw" class="inpt pw"
			required="required" maxlength="20"> <br>
		<div class="text">*패스워드는 10~20자의 영문 대소문자와 숫자, 특수문자를 혼합하여 입력하세요.</div>
		<div class="title">*비밀번호 확인</div>
		<input type="password" name="rePw" id="rePw" class="inpt pw"
			required="required" maxlength="20"> <br>
		
		<div class="btn">
			<ul>
				<li class="item"><a href="${path}/">취소</a></li>
				<li class="item"><a href="#" id="signUpBtn">회원가입</a></li>
			</ul>
		</div>
	</form>

</body>
</html>