# DomoicBookProjectSAP
<p><h6>( Web app developped for SAP Internship programme )</h6></p>

<p>Developped using the following:</p>
<ul>
<li>Eclipse Mars (Java EE)</li>
<li>Apache Tomcat 7.0</li>
<li>JPA(Java Persistence API)</li>
<li>Servlets</li>
<li>JSP(Java Server Pages)</li>
</ul>

<h5>
The idea of this application was to act as an online domoic book for condominiums.
The information in such a document is supposed to be private and visible only to residents, so this application employs password hashing and doesn`t let the user browse any information other than the Home page before logging in.
</h5>

<p>Authentication consists of a resident`s flat number and password. The database(MySQL) supports 8 tables:</p>
<ul>
<li>Flats (Accounts)</li>
<li>People (Residents)</li>
<li>Private messages</li>
<li>Notifications</li>
<li>Discussions</li>
<li>Answers</li>
<li>Obligations</li>
<li>Payments</li>
</ul>

<p>The application works with 2 types of accounts - <b><i>NORMAL</i></b> accounts (the flats of regular residents) and an <b><i>ADMIN</b></i> account(the flat manager/housekeeper)</p>

<p>The <b><i>NORMAL</b></i> type logged flats can mostly browse/read, but on some pages also comment or send messages
The <b><i>ADMIN</b></i> has all the other options and his function is mostly to add/append/manage content.</p> 

<p>Potentially there could be improvements and future versions...</p>
