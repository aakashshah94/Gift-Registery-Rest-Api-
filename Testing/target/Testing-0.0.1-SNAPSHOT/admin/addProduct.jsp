<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<jsp:include page="header.jsp"/>
<body>
<form action="../log" method="post">
<input type="hidden" name="service" value="addProduct">

<label class="control-label">Product Name:</label>
<input type="text" class="form-control" name="productName">

<label class="control-label">Product Price</label>
<input type="text" class="form-control" name="price">

<label class="control-label">Description:</label>
<input type="text" class="form-control" name="productDescription">

<label class="control-label">Company</label>
<input type="text" class="form-control" name="company">

<label class="control-label">Image Path</label>
<input type="text" class="form-control" name="image">

<input type="submit"/>
</form>


</body>
</html>