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
<title>Add Product</title>
</head>
<body>

Add Product<br>
<form name="frm" method="post" enctype="multipart/form-data"action="${pageContext.request.contextPath}/LoadAddProduct">
<table>
Product IMG  :<input type="file" name="ProductPic"><br>
ProductName : <input type="text" name="ProductName"><br>
Amount : <input type="text" name="amount"><br>
Unit : <input type="text" name="unit"><br> 
Price : <input type="text" name="price"><br> 
Category:<select name="Category" id="Category">
  <option value="0">กรุณาเลือก</option>
  <option value="1">ลูกพันธุ์ปลา</option>
  <option value="2">สินค้าอื่นๆ</option>
</select><br>
<input type="submit" Value="Add"> <input type="reset">
</table>
</form>
<% 
	if (r == 1) {%>
	
			บันทึกสำเร็จ
	
	<% } else if (r == -1){%>
			เกิดข้อผิดพลาด ไม่สามารถบันทึกได้!!
	<%} %>

</body>
</html>