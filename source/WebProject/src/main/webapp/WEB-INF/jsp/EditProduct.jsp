<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="org.itsci.fishshop.model.*,org.itsci.fishshop.dao.*,java.util.*"  %>
<% List<Product> list = (List<Product>) request.getAttribute("result");
   int r = 0;
   try{
		r = (int) request.getAttribute("editresult");
   }catch(Exception e){
	   
   }

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Page</title>
</head>
<body>
	<form name="frm" method="post" action="${pageContext.request.contextPath}/loadEditProduct">
	<table border="1">
		<% if (list != null){
		   for(Product p : list){ %>
		 <tr>
			<td>Product ID : </td>
			<td><input type="text" name="ProductID" value="<%=p.getProductID()%>"></td>
		</tr>
		 <tr>
			<td>Product Pic : </td>
			<td><input type="text" name="ProductPic" value="<%=p.getProductPic()%>"></td>
		</tr>
		 <tr>
		<tr>
			<td>ProductName : </td>
			<td><input type="text" name="ProductName" value="<%=p.getProductName()%>"></td>
		</tr>
		<tr>
			<td>Amount : </td>
			<td><input type="text" name="Amount" value="<%=p.getAmount()%>"></td>
		</tr>
		<tr>
			<td>Unit : </td>
			<td><input type="text" name="Unit" value="<%=p.getUnit()%>"></td>
		</tr>
		<tr>
			<td>Price : </td>
			<td><input type="text" name="Price" value="<%=p.getPrice()%>"></td>
		</tr>
		<% } 
		   } %>
		<tr>
			<td> <input type="submit" value="แก้ไข"></td>
		  <td> <input type="reset" value="ยกเลิก"></td>
		</tr>
	</table>
	</form>
</body>
</html>