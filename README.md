# DomoicBookProjectSAP
Web app developped for SAP Internship programme

Developped using the following:
- Eclipse Mars (Java EE)
- Apache Tomcat 7.0
- JPA(Java Persistence API)
- Servlets
- JSP(Java Server Pages)

The idea of this application was to act as an online domoic book for condominuims.
The information in such a document is supposed to be private and visible only to residents, so this application employs password hashing and doesn`t let the user browse any information other than the Home page before logging in.

Authentication consists of a resident`s flat number and password. The database(MySQL) supports 8 tables:
- Flats
- People (Residents)
- Private messages
- Notifications
- Discussions
- Answers
- Obligations
- Payments

Potentially there could be improvements and future versions...



