function add_item() {
	var div = document.createElement('div');
	div.className = "music_wrap";
	var str = '<div class="del_music"> <button class="del_btn" type="button" onclick="remove_item(this)">' + 
	'<img src="../resources/img/x-mark.png" class="del_img"> </button> </div>';
	div.innerHTML = document.getElementById('music_wrap').innerHTML + str;

	document.getElementById('field').appendChild(div);
}

function remove_item(obj) {
	document.getElementById('field').removeChild(obj.parentNode.parentNode);
}
