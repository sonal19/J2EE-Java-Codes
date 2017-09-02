window.onload = function() {
	var dropbox = document.getElementById("dropbox");
	dropbox.addEventListener("dragenter", noop, false);
	dropbox.addEventListener("dragexit", noop, false);
	dropbox.addEventListener("dragover", noop, false);
	dropbox.addEventListener("drop", dropUpload, false);

	$(document).on('click', '[action=Edit]', EditUser);
	$(document).on('click', '[action=Delete]', DeleteUser);

	$('#btnCancel').bind('click', CancelUser);
	$('form').on('click', '#btnSave', SaveUser);

}

var vdata;
function getFileData(myFile, data) {
	// alert(data);
	var file = myFile.files[0];
	var filename = file.name;
	vdata = data;
	upload(file);
}
function noop(event) {
	event.stopPropagation();
	event.preventDefault();
}
function call(data) {
	vdata = data;
}
function dropUpload(event, data) {
	noop(event);
	var files = event.dataTransfer.files;

	for (var i = 0; i < files.length; i++) {
		upload(files[i]);
	}
}

function upload(file) {
	document.getElementById("status").innerHTML = "Uploading " + file.name;
	// alert(vdata);
	var formData = new FormData();
	formData.append("file", file);

	var xhr = new XMLHttpRequest();
	xhr.upload.addEventListener("progress", uploadProgress, false);
	xhr.addEventListener("load", uploadComplete, false);
	xhr.open("POST", "../ImageMgmtServlet?userId=" + vdata, true); // If
	// async=false,
	// then
	// you'll
	// miss progress bar support.
	xhr.send(formData);
}

function uploadProgress(event) {
	// Note: doesn't work with async=false.
	var progress = Math.round(event.loaded / event.total * 100);
	document.getElementById("status").innerHTML = "Progress " + progress + "%";
	var elem = document.getElementById("myBar");
	document.getElementById("myProgress").style.display = 'block';
	elem.style.width = progress + '%';
	document.getElementById("label").innerHTML = progress * 1 + '%';
	/*
	 * var elem = document.getElementById("myBar"); var width = progress; var id =
	 * setInterval(frame, 10); function frame() { if (width >= 100) {
	 * clearInterval(id); } else { width++; elem.style.width = width + '%';
	 * document.getElementById("label").innerHTML = width * 1 + '%'; } }
	 */
}

function uploadComplete(event) {
	document.getElementById("status").innerHTML = event.target.responseText;
	location.reload();
}

function EditUser() {

	var image = {}, $selectedRow;
	$selectedRow = $(this).closest('tr');
	image.uid = parseInt($selectedRow.attr('ImageId'), 10);
	image.id = $selectedRow.find('td:nth-child(1)').html();
	image.name = $selectedRow.find('td:nth-child(2)').html();
	image.size = $selectedRow.find('td:nth-child(3)').html();
	image.hiddenId = $selectedRow.find('td:nth-child(4)').html();
	PreparePopup(image);
	// $UserFT.html('Edit Image Form');
	TogglePopup();

}
function CancelUser() {
	TogglePopup();
}
function DeleteUser() {
	if (confirm("Sure are you want to delete the Item?")) {
		$(this).closest('tr').remove();

		$.ajax({
			type : "post",
			url : "../DeleteImageServlet", // this is my servlet
			data : {
				imageId : $(this).closest('tr').find('td:nth-child(4)').html()
			},
			success : function(msg) {
				alert("File deleted from Database");
			}
		});

		location.reload();
	}
}

function TogglePopup() {
	$('#popup').toggle();
	$('#overlay').toggle();
}

function SaveUser() {
	var image = {}, $row;
	image.hiddenId = parseInt($('#hiddenUserId').val(), 10);
	image.name = $('#txtName').val();

	if (image.name) {

		UpdateTr(image);

		TogglePopup();
	} else {
		alert("Name can't be empty");
	}
}
function UpdateTr(image) {

	$.ajax({
		type : "post",
		url : "../EditImageServlet", // this is my servlet
		data : {
			imageId : image.hiddenId,
			editedName : image.name
		},
		success : function(msg) {
			alert("File updated In Database");
		}
	});

	location.reload();
	// $(this).closest('tr').find('td:nth-child(2)').html(image.name);

}
function PreparePopup(image) {
	$('#hiddenUserId').val(image.hiddenId);
	$('#txtName').val(image.name);

}
