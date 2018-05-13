<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
  pageEncoding="ISO-8859-1"%>
 <% if (session.getAttribute("fname")==null)
  {
	             String redirectURL = "http://localhost:8090/Testing/register.jsp";
	  	        response.sendRedirect(redirectURL);
  }
%>							

<jsp:include page="header.jsp"/>
<script>
$(document).ready(function() {
	$.post("log",{ service:"getprofile"}, function(responseJson) {
	
		var obj = JSON.parse(responseJson);
		$("#fname").val(obj.name);
		$("#lname").val(obj.lname);
	
	});
});
</script>
		<div id="wrapper" class="container">
			<section class="navbar main-menu">
				<div class="navbar-inner main-menu">				
								<a href="index.jsp" class="logo pull-left"><img src="themes/images//giftItlogo.png" class="site_logo" alt=""></a>
						<nav id="menu" class="pull-right">
								<% if(session.getAttribute("fname")!=null) 
						{%>
						<ul>
							<li><a href="createregistry.jsp">Create New Registry</a></li>															
							<li><a href="seeall.jsp">View Own Registries</a></li>			
							<li><a href="seeshared.jsp">View Shared Registries</a></li>							
							<li><a href="viewpublic.jsp">Browse Public Registries</a></li>
						</ul>
						<%}
						else{
						%>
											<ul>
							<li><a href="register.jsp">Create New Registry</a></li>															
							<li><a href="register.jsp">View Own Registries</a></li>			
							<li><a href="register.jsp">View Shared Registries</a></li>							
							<li><a href="register.jsp">Browse Public Registries</a></li>
						</ul>
					<%} %>
					</nav>
	
					
				</div>
			</section>
	<section class="main-content">
	<p> ${error}</p>
	<form action="regs" method="post">
	<input type="hidden" name="service" value="editprofile">
	
	<label>Name:</label>
	<input type="text" id="fname" name="fname">
	
	<label>last name:</label>
	<input type="text" id="lname" name="lname">
	
	
	<br>
	<button>Save</button>
	</form>
	
    </section>
</div>
</body>
</html>