<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.*"%>
<%@page import="model.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link rel="stylesheet" type="text/css" href="bootstrap.min.css"/>
	<link rel="stylesheet" type="text/css" href="test.css"/>
<title>All Payments</title>
<center><fieldset class="head"><p>
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
	</fieldset></center>
	<center><fieldset class="book">
		<center><h1><b>All Payments</b></h1></center>
  		<h3><center>	
  		<div class="form">
		<form name="paymentsInfo" action="UpdatePaymentServlet" method="post">
		<table class="tg" ><thead>
		<%
out.print("<tr><th class='tg-j10z'>"+"Id"+"</th><th class='tg-j10z'>"+"Flat"+"</th><th class='tg-j10z'>"+"Description"+"</th>"+"<th class='tg-j10z'>"+"Deadline"+"</th>"+"<th class='tg-j10z'>"+"Debt"+"</th>"+"<th class='tg-j10z'>"+"Date"+"</th>"+"<th class='tg-j10z'>"+"Status"+"</th>"+"<th class='tg-j10z'>" + "Choose"+"</th></tr></thead><tbody>");
Vector<Payment> receivedlist=(Vector<Payment>)request.getAttribute("allObligations");
for(int i=0;i<receivedlist.size();i++){
out.print("<tr>");
	Payment payment=(Payment)receivedlist.get(i);
int id=payment.getObligation().getId();
int flat=payment.getFlat().getNumber();
String title=payment.getObligation().getDescription();
String deadline=payment.getObligation().getDeadline();
Double debt=payment.getObligation().getDebt();
String status=payment.getPaymentStatus();
String date=payment.getPaymentDate();

out.print("<td class='tg-bdyw'>"+id+"</td>"+"<td class='tg-bdyw'>"+flat+"</td>"+"<td class='tg-bdyw'>"+title+"</td>"+"<td class='tg-bdyw'>"+deadline+"</td>"+"<td class='tg-bdyw'>"+debt+"</td>"+"<td class='tg-bdyw'>"+date+"</td>"+"<td class='tg-bdyw'>"+status+"</td>");
out.print("<td class='tg-bdyw'>"+"<input type='checkbox' name='choose' value="+id+"-"+flat+" unchecked>"+"</td>");
out.print("</tr>");
}
%> 
        </tbody></table>
		</div>
		
	<input type="Submit" class="btn btn-danger btn-lg" value="Pay"><center></p>
</form>

	</fieldset></center>
</head>
<body>

</body>
</html>