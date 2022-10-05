<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="bean.*,util.*,java.util.*"  %>
<% List<Product> list = (List<Product>) request.getAttribute("result");
  
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Search Product</title>
</head>
<body align="center">
<form name="frm" action="SearchProduct" method="POST">
	SearchProduct: <input type="text" name="search">
	<input type="submit" value="search" Onclick="return check(frm)">
</form>
	<%if(list != null){ %>
	<table border= "1">
	<tr><th>ProductID</th><th>ProductPic</th><th>ProductName</th><th>amount</th><th>unit</th><th>price</th></tr>
	<% 
	for (Product n : list){ %>
		<tr>
			<td><%= n.getProductID()%> </a></td>
			<td><img src="img/<%=n.getProductPic()%>" width="200"></td>
			<td><%=n.getProductName()%></td>
			<td><%=n.getAmount()%></td>
			<td><%=n.getUnit()%></td>
			<td><%=n.getPrice()%></td>
			<td><a href="loadEditProduct?proid=<%=n.getProductID()%>">แก้ไข</a> /
			<a href="DeleteProduct?proid=<%=n.getProductID()%>" onclick="return confirm('ต้องการลบข้อมูลนี้หรือไม่ ?');">ลบ</a></td>
		</tr>
		
	<%} %>
	</table>	
	
	<%	} %>
</body>
</html>