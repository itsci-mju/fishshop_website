<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="bean.*,util.*,java.util.*"  %>
<% List<Product> list = (List<Product>) request.getAttribute("resultProduct");
  
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Show Product</title>
</head>
<body align="center">
<form name="frm" action="SearchProduct" method="POST">
	SearchProduct: <input type="text" name="search">
	<input type="submit" value="search" Onclick="return check(frm)">
</form>
<tr>
<%if(list != null){ %>
	<table border= "1">
	<tr><th>ProductID</th><th>ProductPic</th><th>ProductName</th><th>amount</th><th>unit</th><th>price</th></tr>
	<% 
	for (Product n : list){ %>
		<tr>
			<td><%= n.getProductID()%> </a></td>
			<td><img src="<%=n.getProductPic()%>" width="200"></td>
			<td><%=n.getProductName()%></td>
			<td><%=n.getAmount()%></td>
			<td><%=n.getUnit()%></td>
			<td><%=n.getPrice()%></td>
			<td><a href="Cart?ProductID=<%=n.getProductID()%>">เพิ่มใส่ตะกร้า</a>/
			<a href="loadProductDetail?proid=<%=n.getProductID()%>">เข้าชมสินค้า</a></td> 
		</tr>
		
	<%} %>
	</table>	
	
	<%	} %>
</body>
</html>