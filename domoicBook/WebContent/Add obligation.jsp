<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link rel="stylesheet" type="text/css" href="bootstrap.min.css"/>
	<link rel="stylesheet" type="text/css" href="test.css"/>
<title>New Obligation</title>
</head>
<body>
	<center><fieldset class="head">
  		<center><p>
		<input type="Submit" class="btn btn-danger btn-lg"value="Home" onclick="window.location='index.jsp';" >
        <input type="Submit" class="btn btn-danger btn-lg" value="Discussions" onclick="window.location='GetAllDiscussionsServlet';">
        <input type="Submit" class="btn btn-danger btn-lg"value="Obligations" onclick="window.location='CheckObligationServlet';">
        <input type="Submit" class="btn btn-danger btn-lg"value="Messages" onclick="window.location='InboxServlet';">
        <input type="Submit" class="btn btn-danger btn-lg"value="Notifications" onclick="window.location='GetAllNotificationsServlet';">
       	<% if(request.getSession().getAttribute("flatStatus").equals("ADMIN")){
  			out.print("<input type='Submit' class='btn btn-danger btn-lg' value='Flats' onclick='window.location=\"New apartment.jsp\";'>");
  		}
  		%>
       <input type="Submit" class="btn btn-danger btn-lg"value="Logout" onclick="window.location='LogoutServlet';">	 
  		</p></center>
	</fieldset></center>
	<center><fieldset class="book">
	<form action="SetObligationServlet" method="post">
		<center><h1><b>Add Obligation</b></h1></center>
  		<h3><center >
  		<p><label class="field" for="Obligation">Description:</label><input type="text" name="description"/></p>
  		<p><label class="field" for="Amount">Amount:</label><input type="text" name="debt"/></p>
  		<p><label class="field" for="Deadline">Deadline:</label><input type="text" name="deadline"/></p>
  		<p><input type="Submit" class="btn btn-danger btn-lg" value="Create"></p><center></h3>
  			</form>
	</fieldset></center>
</body>
</html>