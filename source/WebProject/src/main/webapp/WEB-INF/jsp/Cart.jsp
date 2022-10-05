<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="bean.*,util.*,java.util.*"  %>
        <% List<Product> list = (List<Product>) request.getAttribute("result");
   int r = 0;
   try{
		r = (int) request.getAttribute("ProductID");
   }catch(Exception e){}

%>

<%@ page import="java.text.DecimalFormat"%>  

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ตะกร้า</title>
</head>
<script type="text/javascript">
function myFunction() {
	  var qt =0;
	  var total =0;
	  document.getElementById("demo").innerHTML = "ราคา: " + x +"บาท";
	  document.getElementById("qty").innerHTML = qty;
	  total = qty * x;
	  document.getElementById("total").innerHTML = total;
	}

</script>
	<script type="text/javascript">
function Cal(frm2) {
	  var qty = document.getElementById("qty").value;
	  var Price = document.getElementsByName("Price")[0].value;
	  var total =0;
	  total = Price*qty;
	  document.getElementById("total").innerHTML = total;
	}
	</script>
<body>
<form action="loadcart" name="frm2" method="POST">

	<h4 style="text-align:center">ตะกร้าสินค้า </h4>
	<table border="1" align="center" class="table" style="width:600px ; text-align:center">
		<tr>
			<th>ทื่</th>
			<th>ชื่อสินค้า</th>
			<th>ราคา</th>
			<th>จำนวน</th>
			<th>รวม</th>
		</tr>
		<% for (int i = 0; i<list.size();i++) {%>
		<td><input type="hidden" value="<%=list.get(i).getProductID() %>" name="ProductID">
		<input type="hidden" value="<%=list.get(i).getProductName() %>" name="ProductName">
		<input type="hidden" value="<%=list.get(i).getAmount() %>" name="Quantity">
		<input type="hidden" value="<%=list.get(i).getPrice() %>" name="Price">
		<%=i+1 %>
		</td>
		<td><%=list.get(i).getProductName() %></td>
		<td><%=list.get(i).getPrice()%>บาท</td>
		<td><input type="text" name="qty" id="qty"></td>
		<td><p id="total"></p></td>
		<% } %>
	</table>
	
	<br>
		<a href="loadAllProduct"><p>[ เลือกสินค้าเพิ่มเติม ] </p></a>
		
	<input type="button" value="คำนวณ" name="cal" OnClick="Cal(frm2)">
	<input type="submit" value="ยืนยันการสั่งซื้อ" name="Confirm">
	<input type="reset" value="ยกเลิก" name="cancel">
</form>
</body>
</html>