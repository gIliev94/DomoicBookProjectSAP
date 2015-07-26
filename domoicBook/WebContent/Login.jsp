<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link rel="stylesheet" type="text/css" href="bootstrap.min.css"/>
	<link rel="stylesheet" type="text/css" href="test.css"/>
<title>Login</title>
</head>
<body>
<center><fieldset class="head">
  		<center><p>
		<input type="Submit" class="btn btn-danger btn-lg"value="Home" onclick="window.location='index.jsp';">
        <input type="Submit" class="btn btn-danger btn-lg" value="Discussions" onclick="window.location='GetAllDiscussionsServlet';">
        <input type="Submit" class="btn btn-danger btn-lg"value="Obligations" onclick="window.location='CheckObligationServlet';">
        <input type="Submit" class="btn btn-danger btn-lg"value="Messages" onclick="window.location='InboxServlet';">
        <input type="Submit" class="btn btn-danger btn-lg"value="Notifications" onclick="window.location='GetAllNotificationsServlet';">
  		
  		</p></center>
	</fieldset></center>
	
    
	<center><fieldset class="book">
	<form action="LoginServlet" method="post">
		<center><h1><b>Domoic book</b></h1></center>
  		<h3><center><p><label class="field" for="Flat number">Flat number:</label><input type="text" name="flatNumber"/></p>
  		<p><label class="field" for="password">Password:</label><input type="password" name="password"/></p><h3>
  		<p><input type="Submit" class="btn btn-danger btn-lg" value="Log in"></p><center>
	</fieldset></center>
	</form>
</body>
</html>