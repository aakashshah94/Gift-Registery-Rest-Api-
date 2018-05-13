<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<jsp:include page="header.jsp"/>

	<section class="main-content">				
				<div class="row">
					<div class="span5">					
						<h4 class="title"><span class="text"><strong>Enter</strong> Username</span></h4>
						<form action="regs" method="post">
								<input type="hidden" value="getquestion" name="service">
									
							<fieldset>
								<div class="control-group">
									<label class="control-label">Enter username:</label>
									<div class="controls">
										<input type="text" name="username">
										
									</div>
								</div>
							<button>Submit</button> 
							</fieldset>
						</form>				
					</div>
					</div>
					</section>
		
</body>
</html>