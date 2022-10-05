<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="bean.*,util.*,java.util.*"  %>
        <%List<Payment> lg = (List<Payment>) request.getAttribute("Payment"); %>
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

<title>ชำระเงิน</title>
</head>
<body>
<form name="frm" method="post" enctype="multipart/form-data"action="${pageContext.request.contextPath}/LoadPayment"> 
    <div style="text-align:center">
   ชำระเงิน<br>
   เมื่อโอนเงินสำเร็จ กรุณาอัพโหลดรูปสลิปของท่าน<input style="text-align:center" type="file" name="PaymentPic"><br>
   เวลาที่โอน <input type="text" name="times"><br> 
   ชื่อเจ้าของบัตร/บัญชี <input type="text" name="PaymentName"><br>
   เลขท้ายหลังบัญชี 4 หลัก <input type="text" name="PaymentNum"><br>
   
   <input type="submit" value="ชำระเงิน" OnClick="return validateForm(frm1)"><input type="reset" value="reset">
	</div>
 </form>
</body>
</html>