<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="bean.*,util.*,java.util.*"  %>
        <%
        Register re = (Register) session.getAttribute("User");
    String err ="";
     	try{
   			err = (String) session.getAttribute("login");
   			session.setMaxInactiveInterval(1);
   			session.removeAttribute("login");
   		}catch(Exception e){
   			err ="";
   		}
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>เข้าสู่ระบบ</title>
</head>
<script  type="text/javascript">
function validateForm(frm){
	 document.getElementById('username').innerHTML = "";
		if(frm.username.value == ""){
			document.getElementById('username').innerHTML = "*กรุณากรอกชื่อผู้ใช้งาน";
			frm.username.focus();
			return false;
		}
		
		document.getElementById('password').innerHTML = "";
		if (frm.password.value == ""){
			document.getElementById('password').innerHTML = "*กรุณากรอกรหัสผ่าน";
			frm.password.focus();
			return false;
		}
	}
 </script>	
<body>
<form action="loadlogin" method="post" name="frm2">

<div class="login-user">
	<div class="container">
		<div class="row">
		<p>เข้าสู่ระบบ</p>
		ชื่อผู้ใช้งาน <input type="text" name="Email" id="Email"> <br>
		รหัสผ่าน <input type="password" name="Password" id="Password"><br>
		<% if (err != null){ %>
	<%=	err %>
	<% } %><br>
		<input type="submit" value="เข้าสู่ระบบ" OnClick="return validateForm(frm2)"><br>
		ยังไม่มีบัญชี สมัครตรงนี้ได้เลย<a href="LoadAddRegister">สมัครสมาชิก</a>
		
		</div>
	</div>
</div>
</form>
</body>
</html>