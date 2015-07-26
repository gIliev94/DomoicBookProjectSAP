<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link rel="stylesheet" type="text/css" href="bootstrap.min.css"/>
	<link rel="stylesheet" type="text/css" href="test.css"/>
<title>Add Flat</title>
</head>
<body>
<center><fieldset class="head">
  		<center><p> 
		<input type="Submit" class="btn btn-danger btn-lg"value="Home" onclick="window.location='index.jsp';" >
        <input type="Submit" class="btn btn-danger btn-lg" value="Discussions" onclick="window.location='GetAllDiscussionsServlet';">
        <input type="Submit" class="btn btn-danger btn-lg"value="Obligations" onclick="window.location='CheckObligationServlet';">
        <input type="Submit" class="btn btn-danger btn-lg"value="Messages" onclick="window.location='InboxServlet';">
        <input type="Submit" class="btn btn-danger btn-lg"value="Notifications" onclick="window.location='GetAllNotificationsServlet';">
		<input type='Submit' class='btn btn-danger btn-lg' value='Flats' onclick='window.location=\"New apartment.jsp\";'>

  		<input type="Submit" class="btn btn-danger btn-lg"value="Logout" onclick="window.location='LogoutServlet';">
  		</p></center>
	</fieldset></center>
	
	<center><fieldset class="book">
	<form action="AddFlatServlet" method="post">
		<center><h1><b>Add Flat</b></h1></center>
  		<h3><center><p><label class="field" for="Flat Number">Flat Number:</label><input type="text" name="flatNumber"/></p>
  		<p><label class="field" for="Flat Surface">Flat Surface:</label><input type="text" name="flatSurface"/></p>
  		<p><label class="field" for="Password">Password:</label><input type="password" name="password"/></p>
        <p><label class="field" for="Room Count">Room Count:</label><input type="text" name="roomCount"/></p>
        <p><label class="field" for="Status">Status:</label><input type="text" name="status"/></p>
  		<p><input type="Submit" class="btn btn-danger btn-lg"value="Add"></p><center><h3>
	</fieldset></center>
</body>
</html>