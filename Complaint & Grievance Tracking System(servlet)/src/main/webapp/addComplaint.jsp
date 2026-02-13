<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>Add Complaint</h2>

<form action="MainServlet" method="post">
<input type="hidden" name="operation" value="newRecord">

Complainant Name:
<input type="text" name="complainant"><br><br>

Title:
<input type="text" name="title"><br><br>

Department:
<input type="text" name="department"><br><br>

Complaint Date:
<input type="date" name="complaintDate"><br><br>

Remarks:
<input type="text" name="remarks"><br><br>

<input type="submit" value="Add Complaint">
</form>

</body>
</html>