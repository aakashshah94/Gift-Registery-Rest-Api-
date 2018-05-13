<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<%if(session.getAttribute("usertype")==null)
    		{
    	response.sendRedirect("http://localhost:8090/Testing");
    		}
    else if(!session.getAttribute("usertype").equals("admin"))
    {
    	response.sendRedirect("http://localhost:8090/Testing");
        	
    }
   	%>
	<head>
		<title>Admin</title>
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<!-- Latest compiled and minified CSS -->

		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

		<link rel="stylesheet" href="../css/admin-index-style.css" />
		
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
		<!-- Latest compiled JavaScript -->
		<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
		<script >
	
		</script>
<body >
    	    <nav class="navbar navbar-inverse">
		      <div class="container-fluid">
		         <div class="navbar-header">
		           <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
		             <span class="icon-bar"></span>
		             <span class="icon-bar"></span>
		             <span class="icon-bar"></span>
		           </button>
		         </div>
		         <div class="collapse navbar-collapse" id="myNavbar">
		           <ul class="nav navbar-nav">
		             <li class="active"><a href="index.jsp">Home</a></li>
		            <li><a href="addProduct.jsp">Add Product</a></li>
		           </ul>
		             <div align="right">
		             <h3 style="color:blue;">Hey admin</h3>
		             <form id="my_form" method="post" action="../log"><input type="hidden" name="service" value="logout">
                        	<a href="javascript:{}" onclick="document.getElementById('my_form').submit(); return false;">Logout</a>
                        	</form>
                        	</div>
                 </div>
		       </div>
  		    </nav>
		</head>

