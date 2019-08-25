function add_item() {
	var div = document.createElement('div');
	div.innerHTML = document.getElementById('pre_set').innerHTML;
	document.getElementById('field').appendChild(div);
}

function remove_item(obj) {
	document.getElementById('field').removeChild(obj.parentNode.parentNode.parentNode);
}
