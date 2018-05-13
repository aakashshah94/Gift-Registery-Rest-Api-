<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<jsp:include page="header.jsp"/>
<script>

</script>
	<section class="main-content">				
				<div class="row">
					<div class="span5">					
						<h4 class="title"><span class="text"><strong>Login</strong> Form</span></h4>
						<form id="form" action="regs" method="post">
								<input type="hidden" value="forgotpass" name="service">
									
							<fieldset>
									
								<div class="control-group">
									<label class="control-label">Question</label>
									<div class="controls">
										<p>${question}</p>
									</div>
								</div>
						
								<div class="control-group">
									<label class="control-label">Answer</label>
									<div class="controls">
										<input type="text" name="answer">
										
									</div>
								</div>
							<button>Submit</button> 
							</fieldset>
						</form>				
						
						<p>your pass will be displayed here</p>
						<p>${pass}</p>
					</div>
					</div>
					</section>
		
</body>
</html>