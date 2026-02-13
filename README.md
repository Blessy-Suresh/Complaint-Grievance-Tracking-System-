 **Complaint & Grievance Tracking System**

The Complaint & Grievance Tracking System is a web-based application developed using Java, Servlets, JSP, JDBC, and Oracle Database.

This system allows users to:

* Add new complaints
* View a specific complaint
* View all complaints

It follows a layered architecture using:

* **Bean Layer**
* **DAO Layer**
* **Service Layer**
* **Servlet Controller**
* **JSP View**



**Project Architecture**

```
com.wipro.complaint
│
├── bean
│   └── ComplaintBean.java
│
├── dao
│   └── ComplaintDAO.java
│
├── service
│   └── Administrator.java
│
├── servlets
│   └── MainServlet.java
│
├── util
│   ├── DBUtil.java
│   └── InvalidInputException.java
│
├── JSP Pages
│   ├── addComplaint.jsp
│   ├── viewComplaint.jsp
│   ├── viewAllComplaints.jsp
│   ├── displayComplaint.jsp
│   ├── displayAllComplaints.jsp
│   ├── success.html
│   ├── error.html
│   └── menu.html
```

**Features**

* Add Complaint
* Auto Complaint ID Generation
* Duplicate Record Check
* View Single Complaint
* View All Complaints
* Status automatically set to "OPEN"

<img width="953" height="349" alt="image" src="https://github.com/user-attachments/assets/edbe2d3f-e154-4029-8966-4a4cab474739" />

<img width="959" height="490" alt="image" src="https://github.com/user-attachments/assets/239bb519-c3cd-4d1a-b833-9ebcfeb218a4" />

<img width="965" height="212" alt="image" src="https://github.com/user-attachments/assets/c39589a2-fbd1-40bb-b422-c70ede0f6936" />

<img width="964" height="344" alt="image" src="https://github.com/user-attachments/assets/a0af8fd4-b4f5-4213-ba9e-c4b8afef6a9c" />

<img width="963" height="718" alt="image" src="https://github.com/user-attachments/assets/ad108279-4019-459a-8fc1-a01b4d55dc95" />

<img width="1469" height="217" alt="image" src="https://github.com/user-attachments/assets/5d6568e4-1135-4fc3-9bf2-489576d5a215" />












* Input Validation

