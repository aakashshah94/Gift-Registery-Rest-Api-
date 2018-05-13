<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

 <% if (session.getAttribute("fname")==null)
  {
	             String redirectURL = "http://localhost:8090/Testing/register.jsp";
	  	        response.sendRedirect(redirectURL);
  }
%>							


<jsp:include page="header.jsp"></jsp:include>
		<script>
$(document).ready(function() { 
    $.get("log", function(responseJson) {   
             var i=0;
              var $div;
              var $ul;
              $.each(responseJson,function(index,product)
               {                    
            	  $('<option>').val(product.productID).text(product.productName).appendTo('#slt');
            	  
                  });
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
				<div class="row">
					<div class="span20">					
						<h4 class="title"><span class="text"><strong>Create</strong>Registry</span></h4>
			<form action="log" method="post">
    <input type="hidden" name="service" value="createregistry"/>
    <div class="form-group">
      <label for="email">Name of Registry</label>
      <input type="text" class="form-control" id="registryName" placeholder="Enter name for registry" name="registryName">
    </div>
    <div class="form-group">
      <label>Access mode:</label>
      <input type="radio" id="private" name="privacy"  value=1 checked>Private
      <input type="radio" name="privacy" id="public" value=0 >Public
    </div>
    <div id="sharedDiv">
    <br></br>
       	  <table id="table" class="table" border="true" style="width:50%;">
				<thead>
						<th>UserName</th>
				</thead>
				<tbody id="contactUs" style="widht:40%">
					<tr class="tblRow">
						<td><input type="text" class="userName" name="username"/></td>
						<td><button id="delete" type="button"  onclick="remove(this)" type="button" class="btn-warning"><b>Delete user</b></button></td>
					</tr>
				</tbody>
			</table>
	<button class="btn btn-primary btn-block" type="button" id="add" style="width:40%;">Add user</button>
 
    </div>
   
    <br>
    
    <div class="form-group">
    <label>select items to add</label>
    <select class="menu" class="items" id="slt" name="items" multiple>
    </select>
    
     <br>
     <br>
    <button  id="submit" class="btn btn-default">Submit</button>
  </form>
					</div>
<jsp:include page="footer.jsp"/>
		</div>
		<script src="themes/js/common.js"></script>
		<script>
			$(document).ready(function() {
				$('#checkout').click(function (e) {
					document.location.href = "checkout.html";
				})
			});
		</script>		
		
		<script>
		$(document).ready(function(){
			  $("#public").click(function(){
			    $("#sharedDiv").hide();
			  });
			  $("#private").click(function(){
			    $("#sharedDiv").show();
			  });
			  $("#add").click(function(event){
				  $("#table tbody").append('<tr> class="tblRow"'+
				  '<td><input type="text" class="userName" name="username"/></td>'+
				  
				  '<td><button type="button" onclick="remove(this)" class="btn-warning">'+
				  '<b>Delete User</b></button></td></tr>');

				});
			  $("#delete").click(function(event){

				  $(this).parent().parent().remove();

				});

			 


		});
		function remove(id)
		{
		$(id).parent().parent().remove();
		}


		</script>

		</script>
    </body>
</html>