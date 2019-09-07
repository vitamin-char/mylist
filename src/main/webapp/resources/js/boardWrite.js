function add_item() {
	var div = document.createElement('div');
	div.className = "music_wrap";
	var str = '<div class="name_wrap">' + 	
	'<input type="text" name="music_title" class="musicInpt" required="required" placeholder="제목">' +
	'</div>' + 
	'<div class="singer_wrap">' +
	'<input type="text" name="music_singer" class="singerInpt" required="required" placeholder="가수">' +
	'</div>';
		
	str += '<div class="del_music"> <button class="del_btn" type="button" onclick="remove_item(this)">' + 
	'<img src="../resources/img/x-mark.png" class="del_img"> </button> </div>';
	div.innerHTML = str;
	
	document.getElementById('field').appendChild(div);
}

function remove_item(obj) {
	$(obj).parent().parent().remove();
}

function replace_name(){
	$('.music_wrap').each(function(index){
		$(this).find("input[name=music_title]").attr("name", "music[" + index + "].music_title");
		$(this).find("input[name=music_singer]").attr("name", "music[" + index + "].music_singer");

	});
}