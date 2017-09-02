
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<br class="clear" />
	
<div id="downloadButton">
		<button class="button4"><s:a href="download">Download CSV</s:a></button>
	</div>	

<center><h1>Employee Table</h1></center>

<table id="tableEdit" align="center">

	<thead>
		<tr>
			
			<th>Emp Id <a href="orderByEmpIdList">&#9660;</a><a href="showEmpList">&#8635;</a></th>
			<th>Name</th>
			<th>Location</th>
			<th>Email</th>
			<th>DOB</th>
			<th>Actions</th>
		</tr>
	</thead>

	<s:iterator value="employeeList">
		<tbody>
			<tr>

				<td  ref="type:text, name:empNo, class:empNoClasse, id:empNoId"><s:property value="empNumber" /></td>
				<td class="tdEdit" id="hidden"  ref="type:text, name:empNo, class:empNoClasse, id:empNoId"><s:property value="empNumber" /></td>
				<td class="tdEdit" ref="type:text, name:name, class:nameClasse, id:nameId"><s:property value="empName" /></td>
				<td class="tdEdit" ref="type:text, name:loc, class:locClasse, id:locId"><s:property value="empLocation" /></td>
				<td class="tdEdit" ref="type:text, name:email, class:emailClasse, id:emailId"><s:property value="empEmail" /></td>
				<td class="tdEdit" ref="type:text, name:dob, class:dobClasse, id:dobId"><s:property value="empDOB" /></td>

				<td><a href="javascript:;" class="btEdit">
				<span class="action" action="Edit"><img	src="statics/images/edit.png" /></span></a>
				<span class="action" action="Delete" ><img src="statics/images/delete.png" id="deleteEmp"/></span>
				
				</td>
			</tr>

		</tbody>
	</s:iterator>


</table>

<script type="text/javascript">
	$(document).ready(function() {
		// debugger;
		$('#tableEdit').a = abc();
		$('#tableEdit').paging({
			limit : 7
		});
	});
</script>

<%-- <script src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.11.2/jquery-ui.min.js"></script>
<script type="text/javascript" src="../static/js/paging.js"></script> 
 --%>
<%--  <script type="text/javascript">
            $(document).ready(function() {
                $('#tableEdit').paging({limit:5});
            });
        </script> --%>
<!-- <script src="../static/js/delEditHandler.js"></script> -->
<!-- 	<script src="../static/js/jquery-3.1.0.min.js"></script> -->

