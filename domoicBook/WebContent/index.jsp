<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link rel="stylesheet" type="text/css" href="bootstrap.min.css"/>
	<link rel="stylesheet" type="text/css" href="test.css"/>
<title>Home</title>
</head>
<body>
<center><fieldset class="head">
  		<center><p>
		<input type="Submit" class="btn btn-danger btn-lg"value="Home" onclick="window.location='index.jsp';" >
        <input type="Submit" class="btn btn-danger btn-lg" value="Discussions" onclick="window.location='GetAllDiscussionsServlet';">
        <input type="Submit" class="btn btn-danger btn-lg"value="Obligations" onclick="window.location='CheckObligationServlet';">
        <input type="Submit" class="btn btn-danger btn-lg"value="Messages" onclick="window.location='InboxServlet';">
        <input type="Submit" class="btn btn-danger btn-lg"value="Notifications" onclick="window.location='GetAllNotificationsServlet';">
        
  		</p></center>
	</fieldset></center>
	<center><fieldset class="book">
  		<center><center><font color="rgb(102, 0, 0)"><h3><p><b> Domoic Book is a web application to guide every housekeeper in his successfull work. With Domoic Book's assistence, anyone could easily manage to cover up the needs of all occupants in the building. The application consists of:</b></p>
		<p><b>- Forum, so you could easily tell all of the residents what's new.</b></p>
		<p><b>- Obligaions page, to easily show what has to be done.</b></p>
		<p><b>- Private messages platform, so the residents could easily find each other and discuss topics.</b></p></h3></font></center><center>
	</fieldset></center>

</body>
</html>