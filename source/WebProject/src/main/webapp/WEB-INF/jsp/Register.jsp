<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ page import="org.itsci.fishshop.model.*,org.itsci.fishshop.dao.*,java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <% int r = 0;
try{
	 r=(int) request.getAttribute("result");
	} 
catch(Exception e){
	e.printStackTrace();
}
%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register</title>
</head>
<body>
<table>
Register<br>
<form name="frm" method="post" enctype="multipart/form-data"action="${pageContext.request.contextPath}/LoadAddRegister">
FristName  :<input type="text" name="FristName"><br>
LastName : <input type="text" name="LastName"><br>
PhoneNo : <input type="text" name="PhoneNo"><br>
Email : <input type="text" name="Email"><br> 
PassWord : <input type="text" name="PassWord"><br> 
<input type="submit" Value="Add"> <input type="reset">
</form>
<% 
	if (r == 1) {%>
			บันทึกสำเร็จ
	
	<% } else if (r == -1){%>
			เกิดข้อผิดพลาด ไม่สามารถบันทึกได้!!
	<%} %>
</table>
</body>
</html>