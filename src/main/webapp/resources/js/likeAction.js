function fn_likeChk(boardId,idx) {
	btnName = $('#like_btn_'+idx).attr('name');
	if(btnName == "like_"+idx){
		fn_like(boardId,idx);
	}else{
		fn_dislike(boardId,idx);
	}
}
function fn_like(boardId,idx) {
	if(login  == ""){
		alert("로그인 후 이용해주세요");
	}else{
	     $.ajax({
	         type :'POST',
	         url : path+"/board/like",
	         data : boardId,
	         contentType : "application/json; charset=UTF-8",
	         success : function(data){
	        	 document.getElementById("like_btn_"+idx).innerHTML = "<img src='./resources/img/like.png' id='like_img' >";
	        	 $('#like_btn_'+idx).attr('name',"dislike_"+idx);
	             
	             document.getElementById("cnt_wrap_"+idx).innerHTML = data;
	         }
	     });
	}
}
function fn_dislike(boardId,idx) {
     $.ajax({
         type :'POST',
         url : path+"/board/dislike",
         data : boardId,
         contentType : "application/json; charset=UTF-8",
         success : function(data){
        	 document.getElementById("like_btn_"+idx).innerHTML = "<img src='./resources/img/dislike.png' id='like_img' >";
        	 $('#like_btn_'+idx).attr('name',"like_"+idx);
             
             document.getElementById("cnt_wrap_"+idx).innerHTML = data;
         }
     });
}
