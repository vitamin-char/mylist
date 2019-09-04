/**
 * 회원가입 유효성 체크
 */
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
			url : path+"/checkUserID",
			data : userId,
			contentType : "application/json; charset=UTF-8",
			success : function(result) {
				if (result == 0) {
					flag = 1;
					alert("사용 가능한 아이디입니다.");
				} else if (result == 1) {
					flag = 0;
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
	var reg_pw = /^.*(?=.{8,20})(?=.*[0-9])(?=.*[a-zA-Z])(?=.*[~`!@#$%\\^&*()-]).*$/;

	if ($("#userName").val() == 0) {
		alert("이름을 입력해 주세요");
		$("#userName").focus();
		return false;
	}

	if ($("#userId").val() == "") {
		alert("아이디를 입력해 주세요");
		$("#userId").focus();
		return false;
	}

	if ($("#userPw").val() == 0) {
		alert("비밀번호를 입력해 주세요");
		$("#userPw").focus();
		return false;
	}

	if (!check(reg_pw, $("#userPw"),
			"패스워드는 8~20자의 영문 대소문자와 숫자, 특수문자를 혼합하여 입력하세요.")) {
		return false;
	}

	if ($("#userPw").val() != $("#rePw").val()) {
		alert("비밀번호가 다릅니다. 다시 확인해 주세요.");
		$("#rePw").val("");
		$("#rePw").focus();
		return false;
	}

	if (flag == 0) {
		alert("아이디 중복체크를 해주세요.");
	} else {
		$("#write").attr("action", path+"/userInsert");
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