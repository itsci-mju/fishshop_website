<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="bean.*,util.*,java.util.*"  %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<% 
	Register n = (Register) session.getAttribute("User");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Profile Page</title>
<h1>โปรไฟล์ของฉัน</h1>
</head>
<body>
	<%if (n != null) {%>
			<b>ชื่อ : </b><%=n.getFirstName()%><br>	
			<b>นามสกุล</b>  :<%=n.getLastName()%><br>
			<b>เบอร์โทร</b> :<%=n.getPhoneNo()%><br>
			<b>อีเมลล์</b>: <%=n.getEmail()%><br>	
<!--  <a href="loadEditRegister?User=<%=n.getMemberID()%>">แก้ไขข้อมูลส่วนตัว </a>-->		
<%}	%>
		

	
</body>
</html>