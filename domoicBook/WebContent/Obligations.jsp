<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="java.util.*"%>
<%@page import="model.*"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="bootstrap.min.css"/>
<link rel="stylesheet" type="text/css" href="test.css"/>
<title>Obligations</title>
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
		<center><h1><b>All obligations</b></h1></center>
  		<h3><center><div class="form">
	    <table class="tg"><thead>
		<%
int columnCount=5;
out.print("<tr><th class='tg-j10z'>"+"Id"+"</th><th class='tg-j10z'>"+"Description"+"</th>"+"<th class='tg-j10z'>"+"Deadline"+"</th>"+"<th class='tg-j10z'>"+"Debt"+"</th><th class='tg-j10z'>"+"Status"+"</th></tr></thead><tbody>");
@SuppressWarnings("unchecked")
Vector<Payment> receivedlist=(Vector<Payment>)request.getAttribute("obligations");
for(int i=0;i<receivedlist.size();i++){
out.print("<tr>");
	Payment element=(Payment)receivedlist.get(i);
int id=element.getObligation().getId();
String description=element.getObligation().getDescription();
String deadline=element.getObligation().getDeadline();
Double debt=element.getObligation().getDebt();
String status=element.getPaymentStatus();
out.print("<td class='tg-bdyw'>"+id+"</td>"+"<td class='tg-bdyw'>"+description+"</td>"+"<td class='tg-bdyw'>"+deadline+"</td>"+"<td class='tg-bdyw'>"+debt+"</td>"+"<td class='tg-bdyw'>"+status+"</td>");
}
out.print("</tr>");
%> 
        </tbody></table>
        
    <% if(request.getSession().getAttribute("flatStatus").equals("ADMIN")){
	out.print("<input type='Submit' class='btn btn-danger btn-lg' value='View all payments' onclick='window.location=\"PayObligationServlet\";'>");
    	out.print("<input type='Submit' class='btn btn-danger btn-lg' value='Add Obligation' onclick='window.location=\"Add obligation.jsp\";'>");
	}
	%>
	</div><center></h3>
	</fieldset></center>
</body>
</html>