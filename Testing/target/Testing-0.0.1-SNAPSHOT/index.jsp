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
	
<script type="text/javascript">
	 $(document).ready(function() { // When HTML DOM "click" event is invoked on element with ID "somebutton", execute the following function...
		    $.get("log", function(responseJson) {   // Execute Ajax GET request on URL of "someservlet" and execute the following function with Ajax response text...
		             var i=0;
		              var $div;
		              var $ul;
		              $.each(responseJson,function(index,product)
		               {
		                if(i<4)
		                 {
		                 if(i==0)
		                    	 {
		                    	 $div=$("<div class='active item'>").appendTo($("#active"));
				                 $ul = $("<ul class='thumbnails'>").appendTo($div);
				                 }
		                	  var $li=$("<li class='span3'>").appendTo($ul);
		                	  var $div=$("<div class='product-box'>").appendTo($li);
		                	  var $span=$("<span class='sale_tag'></span>").appendTo($div)
		                	  var $p=$("<p><a href='product_detail.html'>"+
		                			 "<img src='themes/images/ladies/1.jpg' alt='' /></a>"+
		                			 "</p><a href='product_detail.html' class='title'>"+product.productName+"</a><br/>"+
		                			 "<a href='products.html' class='category'>"+product.comapny+"</a>"+
		                			"<p class='price'>"+product.price+"</p></div></li></ul>").appendTo($div);
		                    }
		                     else
		                    	 {
		                    	if(i%4==0)
		                    		{
		                    		$div=$("<div class='item'>").appendTo($("#active"));
					                 $ul = $("<ul class='thumbnails'>").appendTo($div);
					                }
		                    	 var $li=$("<li class='span3'>").appendTo($ul);
			                	  var $div=$("<div class='product-box'>").appendTo($li);
			                	  var $span=$("<span class='sale_tag'></span>").appendTo($div)
			                	  var $p=$("<p><a href='product_detail.html'>"+
			                			 "<img src='themes/images/ladies/1.jpg' alt='' /></a>"+
			                			 "</p><a href='product_detail.html' class='title'>"+product.productName+"</a><br/>"+
			                			 "<a href='products.html' class='category'>Commodo consequat</a>"+
			                			"<p class='price'>$17.25</p></div></li></ul>").appendTo($div);
			                     }
		                     ++i;
		                    });
		                });
		            });
					
					
					

		</script>
		<!--[if lt IE 9]>			
			<script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
			<script src="js/respond.min.js"></script>
		<![endif]-->

  		<section  class="homepage-slider" id="home-slider">
				<div class="flexslider">
					<ul class="slides">
						<li>
							<img src="themes/images/carousel/banner-1.jpg" alt="" />
						</li>
						<li>
							<img src="themes/images/carousel/banner-2.jpg" alt="" />
							<div class="intro">
								<h1>Mid season sale</h1>
								<p><span>Up to 50% Off</span></p>
								<p><span>On selected items online and in stores</span></p>
							</div>
						</li>
					</ul>
				</div>			
			</section>
			<section class="header_text">
				We stand for top quality templates. Our genuine developers always optimized bootstrap commercial templates. 
				<br/>Don't miss to use our cheap abd best bootstrap templates.
			</section>
			<section class="main-content">
				<div class="row">
					<div class="span12">													
						<div class="row">
							<div class="span12">
								<h4 class="title">
									<span class="pull-left"><span class="text"><span class="line">Feature <strong>Products</strong></span></span></span>
									<span class="pull-right">
										<a class="left button" href="#myCarousel" data-slide="prev"></a><a class="right button" href="#myCarousel" data-slide="next"></a>
									</span>
								</h4>
								<div id="myCarousel" class="myCarousel carousel slide">
									<div id="active" class="carousel-inner">
										
									
									</div>							
								</div>
							</div>						
						</div>
						<br/>
					
			</section>
			<section class="our_client">
				<h4 class="title"><span class="text">Manufactures</span></h4>
				<div class="row">					
					<div class="span2">
						<a href="#"><img alt="" src="themes/images/clients/14.png"></a>
					</div>
					<div class="span2">
						<a href="#"><img alt="" src="themes/images/clients/35.png"></a>
					</div>
					<div class="span2">
						<a href="#"><img alt="" src="themes/images/clients/1.png"></a>
					</div>
					<div class="span2">
						<a href="#"><img alt="" src="themes/images/clients/2.png"></a>
					</div>
					<div class="span2">
						<a href="#"><img alt="" src="themes/images/clients/3.png"></a>
					</div>
					<div class="span2">
						<a href="#"><img alt="" src="themes/images/clients/4.png"></a>
					</div>
				</div>
			</section>
		<jsp:include page="footer.jsp"/>
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