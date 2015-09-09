# DomoicBookProjectSAP
Web app developped for SAP Internship programme

Developped using the following:
- Eclipse Mars (Java EE)
- Apache Tomcat 7.0
- JPA(Java Persistence API)
- Servlets
- JSP(Java Server Pages)

The idea of this application was to act as an online domoic book for condominiums.
The information in such a document is supposed to be private and visible only to residents, so this application employs password hashing and doesn`t let the user browse any information other than the Home page before logging in.

Authentication consists of a resident`s flat number and password. The database(MySQL) supports 8 tables:
- Flats (Accounts)
- People (Residents)
- Private messages
- Notifications
- Discussions
- Answers
- Obligations
- Payments

The application works with 2 types of accounts - NORMAL accounts (the flats of regular residents) and an ADMIN account(the flat manager/housekeeper)

The NORMAL type logged flats can mostly browse/read, but on some pages also comment or send messages
The ADMIN has all the other options and his function is mostly to add/append/manage content. 

Potentially there could be improvements and future versions...



