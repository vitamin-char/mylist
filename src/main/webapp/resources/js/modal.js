function modal_open(boardId){
	var music = [];
	$.ajax({
		type : "POST",
		url : path+"/listView",
		data : boardId,
		contentType : "application/json; charset=UTF-8",
		success : function(board) {
			$("#modal_name_wrap").attr("href", path+"/userPage?userId="+board.userId);
			document.getElementById("modal_name_wrap").innerHTML = board.userName;
			document.getElementById("modal_description_wrap").innerHTML = board.description;
			
			music = board.music;

			document.getElementById("music_content").innerHTML="";
			for(var i=0; i<music.length;i++){
				document.getElementById("music_content").innerHTML += "<div id='modal_music_wrap'>" + "<div id='modal_title_wrap'>"
				+ music[i].music_title + "</div><div id='modal_singer_wrap'>" +  music[i].music_singer +  "</div></div>";
			}
			
			$("#modal").css("top", (($(window).height()-300)/2+$(window).scrollTop())+"px"); //스크롤 내려도 같은 위치
			
			$("#modal").css("display", "block");
		}
	});	
}

$(document).on('click', '#modal_close_btn', function(){
	$("#modal").css("display", "none");
})

$(document).on('click', '.modal_layer', function(){
	$("#modal").css("display", "none");
})