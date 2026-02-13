<%@ page import="java.util.List" %>
<%@ page import="com.wipro.complaint.bean.ComplaintBean" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
String message = (String) request.getAttribute("message");
List<ComplaintBean> list =
(List<ComplaintBean>) request.getAttribute("complaintList");

if (message != null) {
%>
<h3><%= message %></h3>
<%
} else if (list != null) {

for (ComplaintBean bean : list) {
%>

<hr>
Complaint ID: <%= bean.getComplaintId() %><br>
Complainant: <%= bean.getComplainant() %><br>
Title: <%= bean.getTitle() %><br>
Department: <%= bean.getDepartment() %><br>
Date: <%= bean.getComplaintDate() %><br>
Status: <%= bean.getStatus() %><br>
Remarks: <%= bean.getRemarks() %><br>

<%
}
}
%>

<br>
<a href="menu.html">Back to Menu</a>

</body>
</html>