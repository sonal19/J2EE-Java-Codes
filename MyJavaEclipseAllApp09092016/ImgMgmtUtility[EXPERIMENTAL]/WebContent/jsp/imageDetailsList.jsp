<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home Page</title>


<link rel="stylesheet" type="text/css" href="../static/css/Design.css"></link>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%
	String userId = request.getParameter("userId");
%>
</head>
<body>

	<script>
		$(function() {
			$("#tableEdit").tableEdit({
				columnsTr : "1,2,3", //null = all columns editable
				enableDblClick : true, //enable edit td with dblclick
				callback : function(e) {
					alert(e.city);
					console.log(e.age);
					/*
					 * code for ajax
					 */
				},
				activeMasks : function() {
					console.log("function enable masks");
					/*
					 * function for active masks
					 */
				}
			});

		})
	</script>
</head>

<%-- Using JSTL forEach and out to loop a list and display items in table --%>

<table id="tableEdit" align="center">

	<c:set var="totalSize" value="0" scope="page" />
	<%--<c:forEach items="${requestScope.imageData}" var="imgData" varStatus="id">
 <c:set var="totalSize" value="${totalSize + imgData.size}" scope="page"/>
</c:forEach>

<c:if test="${totalSize < 10}">  --%>

	<c:set var="totalSizeNew" value="0" scope="page" />
	<thead>
		<tr>
			<th>ID</th>
			<th>Name</th>
			<th>Size</th>
			<th>Preview</th>
			<th>Actions</th>
		</tr>
	</thead>
	<c:forEach items="${requestScope.imageData}" var="imgData"
		varStatus="id">
		<tbody>
			<tr>
				<td><a href="javascript:;" class="btEdit"><span
						class="action" action="Edit"><img
							src="../static/images/edit.png" /></span></a></td>
				<td class="tdEdit"><c:out value="${id.count}"></c:out></td>
				<td class="tdEdit"><c:out value="${imgData.name}"></c:out></td>

				<td><c:out value="${imgData.size} MB"></c:out></td>

				<td class="hidden"><c:out value="${imgData.userId}"></c:out></td>

				<td><img
					src="${pageContext.servletContext.contextPath}/RetreiveImageServlet?imageId=${imgData.userId}"
					width="100" height="100" /></td>
				<td><span class="action" action="Edit"><img
						src="../static/images/edit.png" /></span> <span class="action"
					action="Delete"><img src="../static/images/delete.png" /></span></td>

			</tr>
			<c:set var="totalSizeNew" value="${totalSizeNew + imgData.size}"
				scope="page" />
		</tbody>
	</c:forEach>

	<tr>
		<td><c:out value="${totalSizeNew} MB"></c:out></td>
	</tr>


</table>
<div id="overlay">
	<div id="popup">
		<fieldset id="fieldPop">
			<legend id="userFormTitle">USER EDIT FORM</legend>
			<form>
				<input type="hidden" id="hiddenUserId" />

				<div>
					<label for="txtName">Name:</label> <input id="txtName" value=""
						type="text" />
				</div>

				<div>
					<input id="btnSave" value="Save" type="button" /> <input
						id="btnCancel" value="Close" type="button" />
				</div>
			</form>
		</fieldset>
	</div>
</div>


<script src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.11.2/jquery-ui.min.js"></script>
<script type="text/javascript" src="../static/js/paging.js"></script> 
<script type="text/javascript">
            $(document).ready(function() {
                $('#tableEdit').paging({limit:5});
            });
        </script>
<!-- <script src="../static/js/delEditHandler.js"></script> -->
<!-- 	<script src="../static/js/jquery-3.1.0.min.js"></script> -->
</body>
</html>