<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="bean.*,util.*,java.util.*"  %>
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
<title>ProductDetail</title>
</head>
<body>
	<form name="frm" method="post" action="${pageContext.request.contextPath}/loadProductDetail">
	<table border="1">
		<% if (list != null){
		   for(Product p : list){ %>
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
		<td><a href="Cart?ProductID=<%=p.getProductID()%>">เพิ่มใส่ตะกร้า</a>
		<% } 
		   } %>
		<tr>		
		</tr>
	</table>
	</form>
</body>
</html>