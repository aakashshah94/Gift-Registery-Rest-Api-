<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<jsp:include page="header.jsp">
<script type="text/javascript">
	 $(document).ready(function() { // When HTML DOM "click" event is invoked on element with ID "somebutton", execute the following function...
		    $.get("regs", function(responseJson) {
		    	// Execute Ajax GET request on URL of "someservlet" and execute the following function with Ajax response text...
		    	
		             		                    });
		                });
		           
					
					
					

		</script>

		<div id="wrapper" class="container">
			<section class="navbar main-menu">
				<div class="navbar-inner main-menu">				
					<a href="index.html" class="logo pull-left"><img src="themes/images//giftItlogo.png" class="site_logo" alt=""></a>
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
			
			<div id="regs">
			
			</div>	

<body>

</body>
</html>