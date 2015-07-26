<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.*"%>
<%@page import="model.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
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
		<center><h1><b>Discussion info:</b></h1></center>
  		<h3><center><div class="form">
  		<p>All comments:</p>
		<table class="tg" ><thead>
		<%
out.print("<tr><th class='tg-j10z'>"+"Content"+"</th><th class='tg-j10z'>"+"From"+"</th>"+"<th class='tg-j10z'>"+"Date"+"</th></tr></thead><tbody>");
Vector<Answer> receivedlist=(Vector<Answer>)request.getAttribute("discussionInfo");
for(int i=0;i<receivedlist.size();i++){
out.print("<tr>");
Answer answer=(Answer)receivedlist.get(i);
String content=answer.getContent();
int from=answer.getFlat().getNumber();
String date=answer.getDate();
out.print("<td class='tg-bdyw'>"+content+"</td>"+"<td class='tg-bdyw'>"+from+"</td>"+"<td class='tg-bdyw'>"+date+"</td>");
out.print("</tr>");
}
%> 
        </tbody></table>
		<form name="sendAnswer" action="AddAnswerServlet" method="post">
		<p>Post yout comment here:</p>
		<p><textarea name="content" rows="10" cols="30" ></textarea></p>
		<p><input type="Submit" class="btn btn-danger btn-lg" value="Post">
</form>
		</div><center></h3>
	</fieldset></center>

</body>
</html>