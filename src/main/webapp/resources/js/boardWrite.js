function add_item() {
	var div = document.createElement('div');
	div.className = "music_wrap";
	var str = document.getElementById('music_wrap').innerHTML;
	
	
	str += '<div class="del_music"> <button class="del_btn" type="button" onclick="remove_item(this)">' + 
	'<img src="../resources/img/x-mark.png" class="del_img"> </button> </div>';
	div.innerHTML = str;
	
	document.getElementById('field').appendChild(div);
}

function remove_item(obj) {
	document.getElementById('field').removeChild(obj.parentNode.parentNode);
}

function replace_name(){
	$('.music_wrap').each(function(index){
		$(this).find("input[name=music_title]").attr("name", "music[" + index + "].music_title");
		$(this).find("input[name=music_singer]").attr("name", "music[" + index + "].music_singer");

	});
}