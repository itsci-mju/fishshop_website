<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ page import="bean.*,util.*,java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <% 
    Register re2 = (Register) session.getAttribute("User");
    
    int r = 0;
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
<title>Address</title>
</head>
<body>

Address<br>
<% if (re2 != null)  { %>
<form name="frm" method="post" enctype="multipart/form-data"action="${pageContext.request.contextPath}/LoadisAddress?Email=<%=re2.getEmail() %>">
<table>
TrackNo:<input type="text" name="TrackNo"><br>
Street : <input type="text" name="Street"><br>
SubDistrict : <input type="text" name="SubDistrict"><br>
District : <input type="text" name="District"><br> 
Province : <input type="text" name="Province"><br> 
ZipCode : <input type="text" name="ZipCode"><br> 
TelNo : <input type="text" name="TelNo"><br> 
<input type="submit" Value="Add"> <input type="reset">
</table>
</form>
<%} %>
<!--
<% 
	if (r == 1) {%>
			บันทึกสำเร็จ
	
	<% } else if (r == -1){%>
			เกิดข้อผิดพลาด ไม่สามารถบันทึกได้!! 
	<%} %>-->

</body>
</html>