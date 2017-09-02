<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<div class="form">

	<ul class="tab-group">
		<li class="tab active"><a href="#login">Log In</a></li>
		<li class="tab"><a href="#signup">Sign Up</a></li>
	</ul>

	<div class="tab-content">

		<s:include value="/html/login.html"></s:include>
		<s:include value="/html/register.html"></s:include>

	</div>
	<!-- tab-content -->

	<s:include value="/html/forgetPassword.html"></s:include>

</div>
<!-- /form -->
