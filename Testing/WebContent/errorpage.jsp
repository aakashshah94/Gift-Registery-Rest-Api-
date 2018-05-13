<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<jsp:include page="header.jsp"/>
		<div id="wrapper" class="container">
			<section class="navbar main-menu">
				<div class="navbar-inner main-menu">				
					<a href="index.jsp" class="logo pull-left"><img src="themes/images/giftItlogo.png" class="site_logo" alt=""></a>
			<nav id="menu" class="pull-right">
						<% if(session.getAttribute("fname")!=null) 
						{%>
						<ul>
							<li><a href="createregistry.jsp">Create New Registry</a></li>															
							<li><a href="seeall.jsp">View Own Registries</a></li>			
							<li><a href="seeshared.jsp">View Shared Registries</a></li>							
							<li><a href="seepublic.jsp">Browse Public Registries</a></li>
						</ul>
						<%}
						else{
						%>
											<ul>
							<li><a href="register.jsp">Create New Registry</a></li>															
							<li><a href="register.jspl">View Own Registries</a></li>			
							<li><a href="register.jsp">View Shared Registries</a></li>							
							<li><a href="register.jsp">Browse Public Registries</a></li>
						</ul>
					<%} %>
				
					</nav>
		
				</div>
			</section>
	
	<p>Sorry some error code try going back</p>
	</div>
	
		<script src="themes/js/common.js"></script>
		<script src="themes/js/jquery.flexslider-min.js"></script>
		<script type="text/javascript">
			$(function() {
				$(document).ready(function() {
					$('.flexslider').flexslider({
						animation: "fade",
						slideshowSpeed: 4000,
						animationSpeed: 600,
						controlNav: false,
						directionNav: true,
						controlsContainer: ".flex-container" // the container that holds the flexslider
					});
				});
			});
		</script>
    </body>
</html>