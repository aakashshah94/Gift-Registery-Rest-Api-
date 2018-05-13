<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <jsp:include page="header.jsp"/>
    <script>
     $(document).ready(function() { // When HTML DOM "click" event is invoked on element with ID "somebutton", execute the following function...
		 $.get("../log", function(responseJson) {   
			 $.each(responseJson,function(index,product)
		    			{
		    		  
		    			    $('<tr id="'+product.productID+'"><td>'+product.productName+'</td>'
		    			    +'<td>'+product.price+'</td>'+
		    			    '<td>'+product.productDescription+'</td>'+
		    			    '<td>'+product.comapny+'</td>'+
		    			   '<td><button id="delete" onclick="remove(this)">Delete</button></tr>').appendTo($("#productTable"));
		    		         
		    			});	    
		    
		    });
     });
   
     function remove(id)
     {
    	 $(id).parent().parent().remove();
    	var thisid=$(id).parent().parent().attr('id');
    	$.post("../regs", {service:"deleteproduct" , data:thisid} , function(responseJson) {
               alert("success");
    	});
     }
	
   	</script>
		
		
    
    	
 <div align="center">
  <section >
  <h2>Menu</h2>
</section>
</div>



<input type="hidden" name="service" value="deleteproduct">
<table class="table" id="productTable" >
</table>
</div>
</div>
</div>
			
				
			
	</body>
</html>
    