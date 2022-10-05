<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="bean.*,util.*,java.util.*"%>
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
<html lang="en">
<head>
<body>
<table>
<form name="frm" method="post" enctype="multipart/form-data"action="${pageContext.request.contextPath}/LoadAddNews">

NewsPic : <input type="file" name="NewsPic"><br>
NewsName : <input type="text" name="NewsName"><br> 
NewsDetail : <textarea id="NewsDetail" name="NewsDetail" rows="5" cols="60"></textarea><br>
<input type="submit" Value="Add"> <input type="reset">

</form>
    

<% 
	if (r == 1) {%>a
			บันทึกสำเร็จ
	
	<% } else if (r == -1){%>
			เกิดข้อผิดพลาด ไม่สามารถบันทึกได้!!
	<%} %>
</table>
</body>
</html>