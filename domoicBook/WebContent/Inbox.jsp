<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.*"%>
<%@page import="model.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Inbox</title>
<link rel="stylesheet" type="text/css" href="bootstrap.min.css"/>
<link rel="stylesheet" type="text/css" href="test.css"/>
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
		<center><h1><b>Inbox</b></h1></center>
  		<h3><center><div class="form">
  		 <table class="tg" ><thead>
		<%
int columnCount=4;
out.print("<tr><th class='tg-j10z'>"+"From"+"</th><th class='tg-j10z'>"+"Title"+"</th>"+"<th class='tg-j10z'>"+"Content"+"</th>"+"<th class='tg-j10z'>"+"Date"+"</th></tr></thead><tbody>");
Vector<PrivateMessage> receivedlist=(Vector<PrivateMessage>)request.getAttribute("inboxMessages");
for(int i=0;i<receivedlist.size();i++){
out.print("<tr>");
	PrivateMessage message=(PrivateMessage)receivedlist.get(i);
int from=message.getFlat1().getNumber();
String title=message.getTitle();
String content=message.getContent();
String date=message.getDate();
out.print("<td class='tg-bdyw'>"+from+"</td>"+"<td class='tg-bdyw'>"+title+"</td>"+"<td class='tg-bdyw'>"+content+"</td>"+"<td class='tg-bdyw'>"+date+"</td>");
out.print("</tr>");
}
%> 
        </tbody></table>
		</div>
		<p><input type="Submit"class="btn btn-danger btn-lg" value="New Message" onclick="window.location='New message.jsp';">
		<input type="Submit" class="btn btn-danger btn-lg"value="View Sent Messages" onclick="window.location='OutboxServlet';"></p><center></h3>
	</fieldset></center>


</body>
</html>