<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<jsp:include page="header.jsp"/>
  <% if (session.getAttribute("fname")==null)
  {
	             String redirectURL = "http://localhost:8090/Testing/register.jsp";
	  	        response.sendRedirect(redirectURL);
  }
%>							
<script type="text/javascript">
	 $(document).ready(function() { // When HTML DOM "click" event is invoked on element with ID "somebutton", execute the following function...
		  $.get("HandleShared", function(responseJson) {   // Execute Ajax GET request on URL of "someservlet" and execute the following function with Ajax response text...

			  $.each(responseJson,function(index,product)
		               {
				        $('<form id="my_form" method="post" action="HandleShared"><input type="hidden" name="service" value="regSharedDetail">'+product+'<input type="hidden" name="regname" value="'+product+'"/> <button type="submit">View Directory</button></form>').appendTo($("#allregs"));
		               });  
		       $('<a href="viewown.jsp?regname=\"'+product+'\"">click me</a>').appendTo($("#allregs"));
		  });
	 });
		           
					
					
					

		</script>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

</head>
<body>
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
			<section class="main-content">
				<table id="example" class="display" width="100%"></table>
				<div id="allregs"></div>	
			</section>

</body>
</html>