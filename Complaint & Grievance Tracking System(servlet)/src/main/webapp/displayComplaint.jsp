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
ComplaintBean bean =
(ComplaintBean) request.getAttribute("complaint");

if (message != null) {
%>
<h3><%= message %></h3>
<%
} else if (bean != null) {
%>

Complaint ID: <%= bean.getComplaintId() %><br>
Complaint: <%= bean.getComplainant() %><br>
Title: <%= bean.getTitle() %><br>
Department: <%= bean.getDepartment() %><br>
Date: <%= bean.getComplaintDate() %><br>
Status: <%= bean.getStatus() %><br>
Remarks: <%= bean.getRemarks() %><br>

<%
}
%>

<br>
<a href="menu.html">Back to Menu</a>

</body>
</html>