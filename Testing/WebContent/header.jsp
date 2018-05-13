<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="utf-8">
		<title>GIftIt</title>
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<meta name="description" content="">
		<!--[if ie]><meta content='IE=8' http-equiv='X-UA-Compatible'/><![endif]-->
		<!-- bootstrap -->
		<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">      
		<link href="bootstrap/css/bootstrap-responsive.min.css" rel="stylesheet">
		
		<link href="themes/css/bootstrappage.css" rel="stylesheet"/>
		
		<!-- global styles -->
		<link href="themes/css/flexslider.css" rel="stylesheet"/>
		<link href="themes/css/main.css" rel="stylesheet"/>
		<link rel="stylesheet" href="https://cdn.datatables.net/1.10.16/css/jquery.dataTables.min.css" />
	    <style>
	    tfoot input {
        width: 100%;
        padding: 3px;
        box-sizing: border-box;
    }
	    </style>
		<!-- scripts -->
		<script src="themes/js/jquery-1.7.2.min.js"></script>
		<script src="bootstrap/js/bootstrap.min.js"></script>				
		<script src="themes/js/superfish.js"></script>	
		<script src="themes/js/jquery.scrolltotop.js"></script>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
		<!-- Latest compiled JavaScript -->
		<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
			</head>
  <body>		
		<div id="top-bar" class="container">
			<div class="row">
				<div class="span4">
					<form  action="" method="POST" >
						<input type="text"  >
					</form>
				</div>
				<div class="span8">
					<div class="account pull-right">
							<%
							  if (session.getAttribute("fname")!=null)
								{
						%>
						<%=session.getAttribute("fname") %>
						<%} %>
						<ul class="user-menu">				
							<%
							  if (session.getAttribute("fname")==null)
								{
								%>				
							<li><a href="register.jsp">My Account</a></li>
							<li><a href="register.jsp">Login</a></li>		
							<%}
						 else
                          {
								
                        	%>
                        	<li><a href="viewprofile.jsp">My Account</a></li>
							<li><form id="my_form" method="post" action="log"><input type="hidden" name="service" value="logout">
                        	<a href="javascript:{}" onclick="document.getElementById('my_form').submit(); return false;">Logout</a>
                        	</form>
                        	</li>
                        	<%
                        	}
							%>		
						
                        	
                          
						</ul>
					</div>
				</div>
			</div>
		</div>
		