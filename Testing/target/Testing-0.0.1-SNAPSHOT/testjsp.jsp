<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>WEB SEARCH ENGINE:SEARCH</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<script  type="text/javascript" src="jquery-1.12.3.js"></script>
<script  type="text/javascript" src="jquery.dataTables.min.js"></script>
<script  type="text/javascript" src="typeahead.bundle.js"></script>

<link rel="stylesheet" type="text/css" href="jquery.dataTables.min.css">

 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
<%@ page import="java.util.ArrayList" %>


<script type="text/javascript">
$(document).ready(function(){
    // Defining the local dataset
   var colArray = new Array();
<%
ArrayList<String> aaray = (ArrayList<String>)request.getAttribute("res");
if(aaray!=null)
{
for (int i=0; i<aaray.size(); i++) { %>
colArray[<%= i %>] = "<%= aaray.get(i) %>"; 
<% } 
}
%>
    
    // Constructing the suggestion engine
    var colArray = new Bloodhound({
        datumTokenizer: Bloodhound.tokenizers.whitespace,
        queryTokenizer: Bloodhound.tokenizers.whitespace,
        local: colArray
    });
    
    // Initializing the typeahead
    $('.typeahead').typeahead({
        hint: true,
        highlight: true, /* Enable substring highlighting */
        minLength: 1 /* Specify minimum characters required for showing result */
    },
    {
        name: 'colArray',
        source: colArray
    });
});  
    
    
   $("#ButtonText").click(function () {
	   document.getElementById("newForm").value = 
	   document.getElementById("newForm").submit();
  });
    
    
</script>
<style type="text/css">
.bs-example {
	font-family: sans-serif;
	position: relative;
	margin: 50px;
	font-size: 15px;
	margin-bottom: 10px;
}
.typeahead, .tt-query, .tt-hint {
	border: 2px solid #CCCCCC;
	border-radius: 8px;
	font-size: 15px; /* Set input font size */
	height: 30px;
	line-height: 30px;
	outline: medium none;
	
	width: 396px;
}
.fsSubButton
{
padding: 10px 15px 11px !important;
font-size: 18px !important;
background-color: #57d6c7;
font-weight: bold;
text-shadow: 1px 1px #57D6C7;
color: #ffffff;
border-radius: 5px;
-moz-border-radius: 5px;
-webkit-border-radius: 5px;
border: 1px solid #57D6C7;
cursor: pointer;
box-shadow: 0 1px 0 rgba(255, 255, 255, 0.5) inset;
-moz-box-shadow: 0 1px 0 rgba(255, 255, 255, 0.5) inset;
-webkit-box-shadow: 0 1px 0 rgba(255, 255, 255, 0.5) inset;
}
.typeahead {
	background-color: #FFFFFF;
}
.typeahead:focus {
	border: 2px solid #0097CF;
}
.tt-query {
	box-shadow: 0 1px 1px rgba(0, 0, 0, 0.075) inset;
}
.tt-hint {
	color: #999999;
}
.tt-menu {
	background-color: #FFFFFF;
	border: 1px solid rgba(0, 0, 0, 0.2);
	border-radius: 8px;
	box-shadow: 0 5px 10px rgba(0, 0, 0, 0.2);
	margin-top: 12px;
	padding: 8px 0;
	width: 422px;
}
.tt-suggestion {
	font-size: 22px;  /* Set suggestion dropdown font size */
	padding: 3px 20px;
}
.tt-suggestion:hover {
	cursor: pointer;
	background-color: #0097CF;
	color: #FFFFFF;
}
.tt-suggestion p {
	margin: 0;
}
</style>
</head>
<body>
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">WEB SEARCH ENGINE</a>
    </div>
    <ul class="nav navbar-nav">
      <li><a href="newlogin.jsp" class="active">Home</a></li>
      <li><a href="index.jsp">Insert</a></li>
     
    </ul>
  </div>
</nav>


<form action="${pageContext.request.contextPath}/Index" name="newForm">

 <div class="bs-example" align="center">
		<h2>Type word(s) to search: </h2>
        <input type="text" required class="typeahead tt-query" placeholder="Enter Keywords to Search" autocomplete="off" spellcheck="false" id="textSearch" name="textSearch">
        <!-- <input type="Button" name="ButtonText"  id="ButtonText" onclick="alert(document.getElementById('hello').value);"> -->
    </div>
    
  <div align="center">
   <INPUT TYPE="radio" NAME="radios" VALUE="OR" CHECKED>
   OR
   <INPUT TYPE="radio" NAME="radios" VALUE="AND">
   AND
   
   <INPUT TYPE="radio" NAME="radios" VALUE="NOT">
   NOT
   <BR>
   <INPUT TYPE="submit" class="fsSubButton" VALUE="Submit" style="margin-top: 10px">
  <input type="hidden" name="actionParameter" value="searchMultiLines"/>
   <input type="hidden" name="textVal" id="textVal" value=""/>
</div>
</form>


</br>
</br>

	<table id="example" class="display" width="100%" cellspacing="0" >
        <thead>
            <tr>
                <th>Index</th>
                <th>URL</th>
                <th>Description</th>
                <th>Frequency</th>
               	<th>Priority</th>
                <!--  <th>Header 6</th> -->
            </tr>
        </thead>
       
        <tbody>

		<c:forEach items="${finalEntries}" var="finalEntries" varStatus="loop1">
			
            <tr>
            	<td>${loop1.index +1}</td>
                <td><a href="${finalEntries.url }" target="_blank">${finalEntries.url }</a></td>
                <td>${finalEntries.data }</td>
                <td>${finalEntries.frequency }</td>
                <td>${finalEntries.priority }</td>
            </tr>
            
			</c:forEach>
			
			 </tbody>
            </table>
   
</body>

<script type="text/javascript">
$(document).ready(function() {
    $('#example').DataTable();
} );
</script> 


</html> 