<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<jsp:include page="header.jsp"/>
		<div id="wrapper" class="container">
			<section class="navbar main-menu">
				<div class="navbar-inner main-menu">				
								<a href="index.jsp" class="logo pull-left"><img src="themes/images//giftItlogo.png" class="site_logo" alt=""></a>
					<nav id="menu" class="pull-right">
						<% if(session.getAttribute("fname")!=null) 
						{%>
						<ul>
							<li><a href="createregistry.jsp">Create New Registry</a></li>															
							<li><a href="./products.html">View Own Registries</a></li>			
							<li><a href="./products.html">View Shared Registries</a></li>							
							<li><a href="./products.html">Browse Public Registries</a></li>
						</ul>
						<%}
						else{
						%>
											<ul>
							<li><a href="register.jsp">Create New Registry</a></li>															
							<li><a href="./products.html">View Own Registries</a></li>			
							<li><a href="./products.html">View Shared Registries</a></li>							
							<li><a href="./products.html">Browse Public Registries</a></li>
						</ul>
					<%} %>
				
					</nav>
					</div>
			</section>			
			<section class="header_text sub">
			<img class="pageBanner" src="themes/images/pageBanner.png" alt="New products" >
				<h4><span>Login or Regsiter</span></h4>
			</section>			
			<section class="main-content">				
				<div class="row">
					<div class="span5">					
						<h4 class="title"><span class="text"><strong>Login</strong> Form</span></h4>
						<form action="log" method="post">
							<input type="hidden" name="service" value="login">
							<fieldset>
							<p>${message}</p>
								<div class="control-group">
									<label class="control-label">Username</label>
									<div class="controls">
										<input type="text" placeholder="Enter your username" id="username" name="username" class="input-xlarge">
									</div>
								</div>
								<div class="control-group">
									<label class="control-label">Password</label>
									<div class="controls">
										<input type="password" placeholder="Enter your password" id="password" name="password" class="input-xlarge">
									</div>
								</div>
								<div class="control-group">
									<input tabindex="3" class="btn btn-inverse large" type="submit" value="Sign into your account">
									<hr>
									<p class="reset">Recover your <a tabindex="4" href="enterusername.jsp" title="Recover your username or password">password</a></p>
								</div>
							</fieldset>
						</form>				
					</div>
					<div class="span7">					
						<h4 class="title"><span class="text"><strong>Register</strong> Form</span></h4>
						<form action="log" method="post" class="form-stacked">
							<fieldset>
							<input type="hidden" name="service" value="register"/>
								<div class="control-group">
									<label class="control-label">First Name</label>
									<div class="controls">
										<input type="text" placeholder="Enter your First Name" class="input-xlarge" name="fname">
									</div>
								</div>
								<div class="control-group">
									<label class="control-label">Last Name</label>
									<div class="controls">
										<input type="text" placeholder="Enter your last Name" class="input-xlarge" name="lname">
									</div>
								</div>
							
								<div class="control-group">
									<label class="control-label">Email address/Username:</label>
									<div class="controls">
										<input type="email" placeholder="Enter your email address" name="username" class="input-xlarge">
									</div>
								</div>
								<div class="control-group">
									<label class="control-label">Password:</label>
									<div class="controls">
										<input type="password" placeholder="Enter your password" name="password" class="input-xlarge">
									</div>
								</div>
								<div class="control-group">
									<label class="control-label">Select A Security Question:</label>
									<div class="controls">
											<select name="security_que">
  												  <option value=1>Name of your first School?</option>
												  <option value=2>Name of your first pet?</option>
												  <option value=3>Your mother's given name?</option>
												  <option value=4>Name of your best friend?</option>
												</select>
								
									</div>
								</div>
									<div class="control-group">
									<label class="control-label">Answer:</label>
									<div class="controls">
										<input type="text" placeholder="Enter answer to security question" name="security_answer"class="input-xlarge">
									</div>
								</div>
														                            
															                            
								<hr>
								<div class="actions"><input tabindex="9" class="btn btn-inverse large" type="submit" value="Create your account"></div>
							</fieldset>
						</form>						
					</div>				
				</div>
			</section>			
			<jsp:include page="footer.jsp"></jsp:include>
		</div>
		<script src="themes/js/common.js"></script>
		<script>
			$(document).ready(function() {
				$('#checkout').click(function (e) {
					document.location.href = "checkout.html";
				})
			});
		</script>		
    </body>
</html>