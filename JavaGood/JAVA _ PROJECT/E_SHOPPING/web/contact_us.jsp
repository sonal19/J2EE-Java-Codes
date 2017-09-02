<%-- 
    Document   : contact_us
    Created on : Aug 28, 2012, 5:44:56 AM
    Author     : ACER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <style type="text/css" media="screen" id="internalStyle">
		div {
			border: 0px solid blue;
			position: relative;
		}
		div img {
			vertical-align: top;
		}
		div > span {
			display: block;
			width: 400px;
			height: 30px;
			position: absolute;
			bottom: 0px;
			left: 110px;
			font-size: 18px;
			font-weight: bold;
			font-family: Arial, "MS Trebuchet", sans-serif;
			-webkit-transition: all .3s linear;

		}
		div:hover > span {
			-webkit-transform: scale(2) translate(150px,-10px);

		}
		#world {
			margin: 0px auto;
			width: 600px;
			height: 600px;
			-webkit-transition: all 1s ease-in-out;

		}
		#images {
			position: relative;
			width: 400px;
			height: 400px;
			-webkit-transform: translate(100px, -300px);

		}
		#images img {
			position: absolute;
			top: 0px;
			left: 0px;
			-webkit-transition: all 1s ease-in-out;

		}
		#imgOne {
			-webkit-transform: rotate(00deg);

		}
		#imgTwo {
			-webkit-transform: rotate(-90deg);

		}
		#imgThree {
			-webkit-transform: rotate(-180deg);

		}
		#imgFour {
			-webkit-transform: rotate(-270deg);

		}

		#world.normal {
			-webkit-transform: rotate(0deg);

		}
		#world.normal #imgOne {
			opacity: 1.0;
		}
		#world.normal #imgTwo {
			opacity: 0.0;
		}
		#world.normal #imgThree {
			opacity: 0.0;
		}
		#world.normal #imgFour {
			opacity: 0.0;
		}

		#world.left_to_top {
			-webkit-transform: rotate(90deg);

		}
		#world.left_to_top #imgOne {
			opacity: 0.0;
		}
		#world.left_to_top #imgTwo {
			opacity: 1.0;
		}
		#world.left_to_top #imgThree {
			opacity: 0.0;
		}
		#world.left_to_top #imgFour {
			opacity: 0.0;
		}

		#world.bottom_to_top {
			-webkit-transform: rotate(180deg);

		}
		#world.bottom_to_top #imgOne {
			opacity: 0.0;
		}
		#world.bottom_to_top #imgTwo {
			opacity: 0.0;
		}
		#world.bottom_to_top #imgThree {
			opacity: 1.0;
		}
		#world.bottom_to_top #imgFour {
			opacity: 0.0;
		}

		#world.right_to_top {
			-webkit-transform: rotate(270deg);

		}
		#world.right_to_top #imgOne {
			opacity: 0.0;
		}
		#world.right_to_top #imgTwo {
			opacity: 0.0;
		}
		#world.right_to_top #imgThree {
			opacity: 0.0;
		}
		#world.right_to_top #imgFour {
			opacity: 1.0;
		}

		#one {
			height: 100px;
			width: 500px;
			cursor: pointer;
		}
		#two {
			height: 100px;
			width: 500px;
			cursor: pointer;
			-webkit-transform: rotate(-90deg) translate(-200px,-200px);

		}
		#three {
			height: 100px;
			width: 500px;
			cursor: pointer;
			-webkit-transform: rotate(-180deg) translate(-100px,-300px);

		}
		#four {
			height: 100px;
			width: 500px;
			cursor: pointer;
			-webkit-transform: rotate(-270deg) translate(-100px,-300px);

		}
	</style>
	<script type="text/javascript">
	//<![CDATA[

		function init() {
			world = document.getElementById("world");
			image = document.getElementById("image");

			one = document.getElementById("one");
			one.addEventListener('click', showTop, false);
			two = document.getElementById("two");
			two.addEventListener('click', showLeft, false);
			three = document.getElementById("three");
			three.addEventListener('click', showBottom, false);
			four = document.getElementById("four");
			four.addEventListener('click', showRight, false);

			function showTop() {
				world.className = "normal";
			}

			function showLeft() {
				world.className = "left_to_top";
			}

			function showBottom() {
				world.className = "bottom_to_top";
			}

			function showRight() {
				world.className = "right_to_top";
			}

		}

	//]]>
	</script>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
   <body onload="init()">
         <%@include file="header.html" %>

         <font face="comic sans ms" color="white" size="4">
<CENTER><h1><U>CONTACT US</U></h1>
        <P>
      IF YOU HAVE A QUERY,CONTACT US ON THE FOLLOWING PHONE NUMBER AND WE WILL RESPOND WITHIN 24 HOURS.
       </CENTER> </font>
         <br><br><br><br>

         <div id="world" class="normal">
		<div id="one" title="click 8882413728">
			<img src="images/tom.jpg" width="100" height="100" alt="tom preview" />
			<span><font face="comic sans ms" color="white">RICKTAM</font></span>
		</div>
		<div id="two" title="click 8800419887">
			<img src="images/dev.jpg" width="100" height="100" alt="dev preview"  />

			<span><font face="comic sans ms" color="white">DEVENDER</font></span>
		</div>
		<div id="three" title="click 7827910036">
			<img src="images/tarun.jpg" width="100" height="100" alt="trn preview"  />
			<span><font face="comic sans ms" color="white">TARUN</font></span>
		</div>
		<div id="four" title="click 9953527157">
			<img src="images/joji.jpg" width="100" height="100" alt="joji preview"  />

			<span><font face="comic sans ms" color="white">ARINDAM</font></span>
		</div>
		<div id="images">
			<img id="imgFour" src="images/joji.jpg" width="400" height="400" alt="arindam" />
			<img id="imgThree" src="images/tarun.jpg" width="400" height="400" alt="tarun" />
			<img id="imgTwo" src="images/dev.jpg" width="400" height="400" alt="Devender" />
			<img id="imgOne" src="images/tom.jpg" width="400" height="400" alt="Ricktam" />
		</div>

	</div>

         
         <%@include file="footer.html" %>
    </body>
</html>
