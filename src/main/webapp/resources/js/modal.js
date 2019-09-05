function modal_open(boardId){
	var music = [];
	$.ajax({
		type : "POST",
		url : path+"/listView",
		data : boardId,
		contentType : "application/json; charset=UTF-8",
		success : function(board) {
			document.getElementById("modal_name_wrap").innerHTML = board.userId;
			document.getElementById("modal_description_wrap").innerHTML = board.description;
			
			music = board.music;

			document.getElementById("music_content").innerHTML="";
			for(var i=0; i<music.length;i++){
				document.getElementById("music_content").innerHTML += "<div id='modal_music_wrap'>" + "<div id='modal_title_wrap'>"
				+ music[i].music_title + "</div><div id='modal_singer_wrap'>" +  music[i].music_singer +  "</div></div>";
			}
			$("#modal").attr("style", "display:block");
		}
	});	
}

$(document).on('click', '#modal_close_btn', function(){
    $("#modal").attr("style", "display:none");
})