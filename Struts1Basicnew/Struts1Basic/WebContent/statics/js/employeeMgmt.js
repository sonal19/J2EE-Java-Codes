/**
 * 
 */

window.onload = function() {
	var dropbox = document.getElementById("dropbox");
	dropbox.addEventListener("dragenter", noop, false);
	dropbox.addEventListener("dragexit", noop, false);
	dropbox.addEventListener("dragover", noop, false);
	dropbox.addEventListener("drop", dropUpload, false);
	// dropbox.addEventListener("click", click, false);
}
///var vdata;
function getFileData(myFile) {
	//alert(data);
	var file = myFile.files[0];
	var filename = file.name;
	//vdata = data;
	upload(file);
}
function noop(event) {
	event.stopPropagation();
	event.preventDefault();
}
/*function call(data) {
	vdata = data;
}*/
function dropUpload(event, data) {
	noop(event);
	var files = event.dataTransfer.files;

	for (var i = 0; i < files.length; i++) {
		upload(files[i]);
	}
}

function upload(file) {
	document.getElementById("status").innerHTML = "Uploading " + file.name;
	//alert(vdata);
	var formData = new FormData();
	formData.append("usersFile", file);

	var xhr = new XMLHttpRequest();
	xhr.upload.addEventListener("progress", uploadProgress, false);
	xhr.addEventListener("load", uploadComplete, false);
	xhr.open("POST", "usersFile", true);

	//xhr.open("POST", "../ImageMgmtServlet?userId=" + vdata, true); // If
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
	document.getElementById("fileDetails").innerHTML = event.target.responseText;
	//location.reload();
}

/*function edValueKeyPress() {
	var edValue = document.getElementById("username");
	var name = edValue.value;
	$.ajax({
		type : "post",
		url : "../CheckUserNameServlet", // this is my servlet
		data : {
			uname : name
		},
		success : function(msg) {
			if (msg.trim() === "Match") {
				alert("userName already Avaliable Try something else");

			}

		},
		error : function(msg) {
		}
	});

}
*/