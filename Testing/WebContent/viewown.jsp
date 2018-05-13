<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<jsp:include page="header.jsp"/>
		<script src="//code.jquery.com/jquery-1.12.4.js"></script>
		<script src="https://cdn.datatables.net/1.10.16/js/jquery.dataTables.min.js"></script>
	

<script>


  
/* $(document).ready(function() {
  /*   var table = $('#example').DataTable();
     
    // Event listener to the two range filtering inputs to redraw on input
    $('#min, #max').keyup( function() {
        table.draw();
    } ); 
    console.log('Ready');
} ); */

</script>

<script>


 $.fn.dataTable.ext.search.push(
	    function( settings, data, dataIndex ) {
	        var min = parseInt( $('#min').val(), 10 );
	        var max = parseInt( $('#max').val(), 10 );
	        var age = parseFloat( data[2] ) || 0; // use data for the age column
	 
	        if ( ( isNaN( min ) && isNaN( max ) ) ||
	             ( isNaN( min ) && age <= max ) ||
	             ( min <= age   && isNaN( max ) ) ||
	             ( min <= age   && age <= max ) )
	        {
	            return true;
	        }
	        return false;
	    }
	); 
	
$(document).ready(function() {
	
	
	    $.each(${jsonstring} ,function(index,product)
	              {
	    	         
	    	            $('<tr><td>'+product.productName+'</td>'
	    	            	+'<td>'+product.productDescription+'</td>'
	    	            	+'<td>'+product.price+'</td>'
	    	            	+'<td>'+product.company+'</td></tr>').appendTo($("#example"));
	    	             
	            
	              });
	    
	    $('#example tfoot th').each( function () {
	        var title = $(this).text();
	        $(this).html( '<input type="text" placeholder="Search '+title+'" />' );
	    } );
	 
	    // DataTable
	    var table = $('#example').DataTable();
	 
	    // Apply the search
	    table.columns().every( function () {
	        var that = this;
	 
	        $( 'input', this.footer() ).on( 'keyup change', function () {
	            if ( that.search() !== this.value ) {
	                that
	                    .search( this.value )
	                    .draw();
	            }
	        } );
	    } );
	    // Event listener to the two range filtering inputs to redraw on input
	     $('#min, #max').keyup( function() {
	        table.draw();
	    }); 
	    console.log('Ready');
	    
	   
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
							<li><a href="seepublic.jsp">Browse Public Registries</a></li>
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
			 	<table cellspacing="5" cellpadding="5" border="0">
        <tbody><tr>
            <td>Minimum Price:</td>
            <td><input id="min" name="min" type="text"></td>
        </tr>
        <tr>
            <td>Maximum Price:</td>
            <td><input id="max" name="max" type="text"></td>
        </tr>
    </tbody></table>
    <table id="example" class="display" cellspacing="0" width="100%">
    <caption> ${regname} </caption>
		
        <thead>
            <tr>
                <th>Name</th>
                <th>Description</th>
                <th>Price</th>
                <th>Company</th>
            </tr>
        </thead>
          <tfoot>
            <tr>
                <th>Name</th>
                <th>Description</th>
                <th>Price</th>
                <th>Company</th>
             </tr>
        </tfoot>
        <tbody>
			 	
	 	
	</table>	
	</section>
						
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

		
    </body>
</html>