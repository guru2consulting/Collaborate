<html>
<head>
<title>AcunnoConnect - Login/Register</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="AcunnoConnect" />
<script type="application/x-javascript"> 
addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } 
</script>

<link href="resources/css/bootstrap.css" rel='stylesheet' type='text/css' />

<!--Custom-Theme-files-->
	<link href="resources/css/style.css" rel='stylesheet' type='text/css' />	
	<script src="resources/js/jquery.min.js"> </script>
	<script src="resources/js/acunnoconnectbase.js"> </script>
<!--/script-->

<script type="text/javascript" src="resources/js/move-top.js"></script>
<script type="text/javascript" src="resources/js/easing.js"></script>
<script type="text/javascript">
			jQuery(document).ready(function($) {
				$(".scroll").click(function(event){		
					event.preventDefault();
					$('html,body').animate({scrollTop:$(this.hash).offset().top},900);
				});
			});
</script>

</head>
<body>
	<div class="h-top" id="home">
			   <div class="top-header">
			   <ul class="cl-effect-16 top-nag-left">
			   			<li><a href="/" data-hover="AcunnoConnect">AcunnoConnect</a></li>
			   		</ul>
						<ul class="cl-effect-16 top-nag">
					  		<li><a href="about.html" data-hover="About">About</a></li>
							<li><a href="services.html" data-hover="SERVICES">SERVICES</a></li>
							<li><a href="login.html" data-hover="Login">Login</a></li>
							<li><a href="contact.html" data-hover="CONTACT">Contact</a></li>
						</ul>
						<div class="clearfix"></div>
					</div>
	       </div>
	       
		<!-- div class="full">
			<div class="col-md-3 top-nav login">
				     <div class="logo">
						<h1></h1>
					</div>
					<div class="top-menu">
					 <span class="menu"> </span>
					
					<script>
						$( "span.menu" ).click(function() {
						  $( ".top-menu ul" ).slideToggle(300, function() {
							// Animation complete.
						  });
						});
					</script>
				 	
					<ul class="side-icons">
							<li><a class="fb" href="#"></a></li>
							<li><a class="twitt" href="#"></a></li>
							<li><a class="goog" href="#"></a></li>
							<li><a class="drib" href="#"></a></li>
					   </ul>
			    </div>
			</div>
		</div-->
	<div class="col-md-9 main-login">
	<!-- login-page -->
	<h3 class="tittle">AcunnoConnect<i class="glyphicon glyphicon-road"></i></h3>
					<p>AcunnoConnect is a collaboration platform that offers group messaging and forums, individual messaging, document sharing voice and video calling option.</p>
	<div class="login">
		<div class="login-grids">
			<div class="col-md-6 log">
					 <h3 class="tittle">Login <i class="glyphicon glyphicon-lock"></i></h3>
					 <p>If you already have login ?</p>
					 <form method="post" action="/acunnoconnect/userLogin">
						 <h5>User Id:</h5>	
						 <input type="text" value="mukul.raizada@gmail.com" name="emailId" id="username">
						 <h5>Password:</h5>
						 <input type="password" value="password" name="password" id="userpassword">					
						 <input type="submit" value="Login">
					 </form>
					 
					<a href="#">Forgot Password ?</a>
			</div>
			<div class="col-md-6 login-right">
			   <h3 class="tittle">Registration <i class="glyphicon glyphicon-file"></i></h3>
				<div class="sign-up">
					 <h3 class="tittle reg">Personal Information <i class="glyphicon glyphicon-user"></i></h3>
					<div class="sign-u">
						<div class="sign-up1">
							<h4 class="a">First Name* :</h4>
						</div>
						<div class="sign-up2">
							<form>
								<input type="text" id="registerfirstname" class="text" value="firstname" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Name';}">
							</form>
						</div>
						<div class="clearfix"> </div>
					</div>
					<div class="sign-u">
						<div class="sign-up1">
							<h4 class="b">Last Name* :</h4>
						</div>
						<div class="sign-up2">
							<form>
									<input type="text" id="registerlastname" class="text" value="lastname" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Last Name';}">
							</form>
						</div>
						<div class="clearfix"> </div>
					</div>
					<div class="sign-u">
						<div class="sign-up1">
							<h4 class="c">Email Address* :</h4>
						</div>
						<div class="sign-up2">
							<form>
								 <input type="text" id="registeremailid" class="text" value="mukul.raizada@gmail.com" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Email Address';}">
							</form>
						</div>
						<div class="clearfix"> </div>
					</div>
					 <h3 class="tittle reg">Login Information <i class="glyphicon glyphicon-off"></i></h3>
					<div class="sign-u">
						<div class="sign-up1">
							<h4 class="d">Password*:</h4>
						</div>
						<div class="sign-up2">
							<form>
								 <input type="password" id="registerpassword" class="Password" value="password" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Password';}">
							</form>
						</div>
						<div class="clearfix"> </div>
					</div>
					<div class="sign-u">
						<div class="sign-up1">
							<h4>Confirm Password*:</h4>
						</div>
						<div class="sign-up2">
							<form>
								<input type="password" class="Password" id="registerpasswordconfirm" value="password" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Confirm Password';}">
							</form>
						</div>
						<div class="clearfix"> </div>
					</div>
					<span id="errormessage" class="errormessage-registeruser"></span>
					<input type="button" value="Submit" onclick="registerNewUser()" id="userRegistrationBtn">
				</div>
			
			<div class="clearfix"></div>
		</div>
	</div>
<!-- //login-page -->
			<div class="clearfix"> </div>
	<!--/footer-->
	     <div class="footer">
				 <div class="footer-top">
				    <div class="col-md-4 footer-grid">
					     <h4>Lorem sadipscing </h4>
				          <ul class="bottom">
							 <li>Consetetur sadipscing elitr</li>
							 <li>Magna aliquyam eratsed diam</li>
						 </ul>
				    </div>
					  <div class="col-md-4 footer-grid">
					     <h4>Message Us Now</h4>
				            <ul class="bottom">
						     <li><i class="glyphicon glyphicon-home"></i>Available 24/7 </li>
							 <li><i class="glyphicon glyphicon-envelope"></i><a href="mailto:info@example.com">mail@example.com</a></li>
						   </ul>
				    </div>
					<div class="col-md-4 footer-grid">
					     <h4>Address Location</h4>
				           <ul class="bottom">
						     <li><i class="glyphicon glyphicon-map-marker"></i>2901 Glassgow Road, WA 98122-1090 </li>
							 <li><i class="glyphicon glyphicon-earphone"></i>phone: (888) 123-456-7899 </li>
						   </ul>
				    </div>
					<div class="clearfix"> </div>
				 </div>
	     </div>
		<div class="copy">
		    <p>&copy; 2015 All Rights Reserved | Design by <a href="http://acunnotech.com/">AcunnoTech</a> </p>
		</div>
	 <div class="clearfix"> </div>
	</div>
	<div class="clearfix"> </div>
</div>	
		<!--//footer-->
			<!--start-smooth-scrolling-->
						<script type="text/javascript">
									$(document).ready(function() {
										/*
										var defaults = {
								  			containerID: 'toTop', // fading element id
											containerHoverID: 'toTopHover', // fading element hover id
											scrollSpeed: 1200,
											easingType: 'linear' 
								 		};
										*/
										
										$().UItoTop({ easingType: 'easeOutQuart' });
										
									});
								</script>
		<a href="#home" id="toTop" class="scroll" style="display: block;"> <span id="toTopHover" style="opacity: 1;"> </span></a>


</body>
</html>