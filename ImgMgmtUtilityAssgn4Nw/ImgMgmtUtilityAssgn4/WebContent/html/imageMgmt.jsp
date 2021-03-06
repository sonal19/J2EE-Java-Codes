<!DOCTYPE html>
<html lang="en">
<head>
<title>HTML5 drag'n'drop file upload with Servlet</title>
<link rel="stylesheet" type="text/css" href="../static/css/imageMgmt.css" ></link>
<script src="../static/css/imageMgmt.js"></script>

</head>
<body>
<legend>Image Uploader</legend>
<fieldset>
	<div id="dropbox" align="center">
		Drag and drop a file here... <br /> Or
		<br /> Click here<br />
		<br />

		<div class="image-upload">
			<label for="file-input"> <img src="add.png" />
			</label> <input id="file-input" type="file" onchange="getFileData(this)" />
		</div>
		<br/>
		<div id="status"></div>
		<div id="myProgress">
			<div id="myBar">
				<div id="label"></div>
			</div>
		</div>
	</div>
</fieldset>
</body>
</html>