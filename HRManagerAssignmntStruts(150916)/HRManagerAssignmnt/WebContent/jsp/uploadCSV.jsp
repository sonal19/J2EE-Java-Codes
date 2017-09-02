<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<br /></br>
<center><h1>Upload Employee Details</h1></center>
<legend>File Uploader</legend>
<fieldset>
	<div id="dropbox" align="center">
		Drag and drop a file here... <br /> Or <br /> Click here<br /> <br /><br/>

		<div class="image-upload">

			<label for="file-input"> <img src="statics/images/add.png" />
			</label><input type="file" id="file-input" name="usersFile"
				onchange="getFileData(this)"
				accept=".csv, application/vnd.openxmlformats-officedocument.spreadsheetml.sheet, application/vnd.ms-excel" />
		</div>
		<br />
		<div id="status"></div>
		<div id="myProgress">
			<div id="myBar">
				<div id="label"></div>
			</div>
		</div>
	</div>
	
</fieldset>

<br/><br/>
<div id="uploaded"><p id="fileDetails"></p></div>
	