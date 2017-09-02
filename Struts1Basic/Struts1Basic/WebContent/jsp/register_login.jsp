<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

  		<div class="form">

			<ul class="tab-group">
				<li class="tab active"><a href="#login">Log In</a></li>
				<li class="tab"><a href="#signup">Sign Up</a></li>
			</ul>

			<div class="tab-content">

				<%@include file="../html/login.html"%>
				<%@include file="../html/register.html"%>

			</div>
			<!-- tab-content -->

			<%@include file="../html/forgetPassword.html"%>

		</div>
		<!-- /form -->

	
	<%-- <main>
	<div class="innertube">
		<div class="form">

			<ul class="tab-group">
				<li class="tab active"><a href="#login">Log In</a></li>
				<li class="tab"><a href="#signup">Sign Up</a></li>
			</ul>

			<div class="tab-content">

				<%@include file="../html/login.html"%>
				<%@include file="../html/register.html"%>

			</div>
			<!-- tab-content -->

			<%@include file="../html/forgetPassword.html"%>

		</div>
		<!-- /form -->

	</div>
	</main> --%>

