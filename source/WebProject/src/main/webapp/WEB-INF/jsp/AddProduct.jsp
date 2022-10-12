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
<style type="text/css">
*{
	margin: 0;
	padding: 0;
    box-sizing: border-box;
	font-family: 'Itim', sans-serif;
}

body{
	background-color: #CEE5ED;
}

/*------------------------------------------------ แถบบาร์ --------------------------------------------------*/

.nav1{
    background-color: #1b1b1b;
    padding-top: 12px;
}
.nav1::after{
    content: '';
    clear: both;
    display: table;
}
.nav1 ul{
    float: right;
    list-style: none;
    margin-right: 40px;
    position: relative;
}
.nav1 ul li{
    float: left;
    display: inline-block;
    background-color: #b1bfd8;
    margin: 0 5px;
	border-radius: 8px;
}
.nav1 ul li a{
    color: #1b1b1b;
    text-decoration: none;
    line-height: 45px;
    font-size: 18px;
    padding: 8px 15px;
}
.nav1 ul li a:hover{
    color: #fff;
    border-radius: 5px;
    box-shadow: 0 0 5px #DDBDFC,
                0 0 5px #96C8FB;
}
.nav1 ul ul{
    position: absolute;
    top: 60px;
    opacity: 0;
    visibility: hidden;
    transition: top .3s;
    border-radius: 5px;
    border-top: 3px solid #96C8FB;
}
.nav1 ul li:hover > ul{
    top: 45px;
    opacity: 1;
    visibility: visible;
}
.nav1 ul ul li{
    position: relative;
    margin: 0px;
    width: 150px;
    float: none;
    display: list-item;
    border-bottom: 1px solid rgba(0,0,0,0.2);
}
.nav1 ul ul li a{
    line-height: 50px;
}
.nav1 ul ul li a:hover{
    color: #fff;
    box-shadow: none;
}
.nav1 .logonav{
    float: left;
    color: azure;
    font-size: 25px;
    font-weight: 500;
    padding-left: 60px;
    padding-top: 5px;
}

/*----------------------------เนื้อหา-----------------------------*/
.wrapper {
    background-color: #fff;
    width: 800px;
    padding: 25px;
    margin: 25px auto ;
    box-shadow: 0px 0px 20px rgb(0, 0, 0,0.5);
    border-radius: 10px;
    text-align: center;
}

.wrapper h2 {
    background-color: #fcfcfc;
    color: #000;
    font-size: 24px;
    padding: 10px;
    margin-bottom: 8px;
    text-align: center;
    border: 1px dashed ;
}

.wrapper h4 {
    padding-bottom: 5px;
    color: #0090ff;
}

.input_group {
    margin-bottom: 8px;
    width: 100%;
    position: relative;
    flex-direction: row;
    display: flex;
    padding: 5px 0;
}

.input_box {
    width: 100%;
    margin-right: 12px;
    position: relative;
}

.input_box:last-child {
    margin-right: 0;
}

.input_box .name{
    padding: 14px 10px 14px 50px;
    width: 100%;
    background-color: #fcfcfc;
    border: 1px solid #000;
    outline: none;
    letter-spacing: 1px;
    transition: 0.3s;
    border-radius: 3px;
    color: #333;
}

.input_box .name:focus, .dob:focus {
    -webkit-box-shadow: 0 0 2px 1px #0090ff;
    -moz-box-shadow: 0 0 2px 1px #0090ff;
    box-shadow: 0 0 2px 1px #0090ff;
    border: 1px solid #0090ff;
}

.input_box .icon {
    width: 48px;
    display: flex;
    justify-content: center;
    align-items: center;
    position: absolute;
    left: 0px;
    bottom: 0px;
    top: 0px;
    color: #000;
    transition: 230ms;
    pointer-events: none;
}

.name:focus+.icon {
    background-color: #0090ff;
    color: #fff;
    border: 1px solid #0090ff;
    border: none;
    transition: 230ms;
}

.dob{
    width: 30%;
    padding: 14px;
    text-align: center;
    background-color: #fcfcfc;
    transition: 0.3s;
    outline: none;
    border: 1px solid #c0bfbf;
    border-radius: 3px;
}

.radio {
    opacity: 0;
    height: 0;
    width: 0;
    margin: -2px;
    border: 0;
}

.input_box label {
    width: 50%;
    padding: 13px;
    background-color: #fcfcfc;
    display: inline-block;
    float: left;
    text-align: center;
    border: 1px solid #c0bfbf;
    cursor: pointer;
}

.input_box label:first-of-type{
    border-top-left-radius: 3px;
    border-bottom-right-radius: 3px;
    border-right: none;
}

.input_box label:last-of-type {
    border-top-left-radius: 3px;
    border-bottom-right-radius: 3px;
}

.radio:checked+label {
    background-color: #0090ff;
    color: #fff;
    transition: 0.5s;
}

.radio:focus+label {
    transition: 0.5s;
	 border: 1px solid #0090ff;
	box-shadow: 0 0 2px 1px #0090ff;
}
.input_box button{
    width: 100%;
    background-color: #0090ff;
    color: #fff;
    border: none;
    padding: 15px;
    border-right: 4px;
    font-size: 16px;
    transition: all 0.3s ease;
    border-radius: 8px;
}

.input_box button:hover {
    cursor: pointer;
    background-color: #0090ff;
}
/*------------------------------------------------ footer --------------------------------------------------------*/
footer{
	background:#111;
	height: auto;
	width: 100vw;
	font-family: 'Kanit', sans-serif;
	padding-top: 40px;
	color: #fff;
}

.footer-content{
	display: flex;
	align-content: center;
	align-items: center;
	justify-content: center;
	flex-direction: column;
	text-align: center;
}

.footer-content h3{
	font-size: 1.8rem;
	font-weight: 400;
	text-transform: capitalize;
	line-height: 3rem;
}

.footer-content p{
	max-width: 500px;
	margin: 10px auto;
	line-height: 28px;
	font-size: 14px;
}

.socials{
	list-style: none;
	display: flex;
	align-items: center;
	justify-content: center;
	margin: 1rem 0 3rem 0;
}

.socials li{
	margin: 0 10px;
}

.socials a{
	text-decoration: none;
	color: #fff;
}

.socials a i{
	font-size: 1.1rem;
}

.socials a:hover i{
	color: #D9EDE7;
}

.footer-bottom{
	background: #000;
	width: 100vw;
	padding: 20px 0;
	text-align: center;
}

.footer-bottom p{
	font-size: 14px;
	word-spacing: 2px;
	text-transform: capitalize;
}

.footer-bottom span{
	text-transform: uppercase;
	opacity: .4;
	font-weight: 200;
}
</style>
<meta charset="UTF-8">
    <!-- Bootstrap 4 -->
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
  <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
  

   <!-- Font family -->
   <link rel="preconnect" href="https://fonts.googleapis.com">
   <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
   <link href="https://fonts.googleapis.com/css2?family=Kanit:wght@100;200;300;600&display=swap" rel="stylesheet">	
   <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/@fortawesome/fontawesome-free@5.15.4/css/fontawesome.min.css">
   <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
   <link rel="stylesheet" href="path/to/font-awesome/css/font-awesome.min.css">
   <script src="https://kit.fontawesome.com/632a1ac765.js" crossorigin="anonymous"></script>
   <link rel="preconnect" href="https://fonts.googleapis.com">
   <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
   <link href="https://fonts.googleapis.com/css2?family=Itim&display=swap" rel="stylesheet">
<title>Add Product</title>
</head>
<body>
    <nav class="nav1">
        <div class="logonav">MJUfishtech</div>
        <ul>
           <li><a href="index.html">หน้าแรก</a></li>
           <li><a href="shop.html">สินค้าของเรา</a>
            <ul>
                <li><a href="#">สินค้าพรีออเดอร์</a></li>
                <li><a href="add-pro.html">เพิ่มสินค้า</a></li>
            </ul>
             </li>
           <li style="background-color: #fc5296;
           background-image: linear-gradient(315deg, #fc5296 0%, #f67062 74%);">
           <a href="cart.html">ตะกร้าสินค้า</a></li>
               <ul>
                   <li><a href="add-news.html">เพิ่มข่าวสาร</a></li>
               </ul>
           </li>
           <li><a href="about.html">เกี่ยวกับเรา</a></li>
           <li><a href="news.html">ข่าวสารข้อมูล</a>
           <li><a href="contact.html">ติดต่อสอบถาม</a></li>
        </ul>
    </nav>
<!----------------->

<div class="wrapper">
<form name="frm" method="post" enctype="multipart/form-data"action="${pageContext.request.contextPath}/LoadAddProduct">
<table>
  <h4>รายละเอียดสินค้า</h4>
        <div class="input_group">
            <h4>เพิ่มรูปภาพสินค้า</h4>
            <div class="input_box">
<input type="file" name="ProductPic" placeholder="เพิ่มรูปภาพ" required class="name">
  </div>
        </div>
        <div class="input_group">
            <div class="input_box">
<input type="text" name="ProductName" placeholder="ชื่อสินค้า" required class="name"><br>
 <i class="icon fa-solid fa-basket-shopping"></i>
            </div>
            <div class="input_box">
<input type="text" name="amount" placeholder="กรอกจำนวนสินค้า" required class="name"><br>
    <i class="icon fa-solid fa-basket-shopping"></i>
            </div>        
        </div>
         <div class="input_group">
            <div class="input_box">
<input type="text" name="unit" placeholder="กรอกราคาสินค้า" required class="name"><br> 
 <i class="icon fa-solid fa-basket-shopping"></i>
            </div>
             <div class="input_box">
<input type="text" name="price"placeholder="กรอกขนาดสินค้า xx,xx,xx,xx" required class="name"><br> 
    <i class="icon fa-solid fa-sack-dollar"></i>
            </div>
        </div>
 <div class="input_group">
            <h4>เพิ่มไปในหมวดหมู่</h4>
            <div class="input_box">
Category:<select name="Category" id="Category">
  <option value="0">กรุณาเลือก</option>
  <option value="1">ลูกพันธุ์ปลา</option>
  <option value="2">สินค้าอื่นๆ</option>
</select>
     </div>
        </div>
         <div class="input_group">
            <div class="input_box">
<input type="submit" Value="เพิ่มสินค้า"> <input type="reset" value="ยกเลิก">
   </div>
        </div>
</table>
</form>
</div>
<% 
	if (r == 1) {%>
	
			บันทึกสำเร็จ
	
	<% } else if (r == -1){%>
			เกิดข้อผิดพลาด ไม่สามารถบันทึกได้!!
	<%} %>
<!------------------------------------------------------ footer --------------------------------------------------------->
<footer>
    <div class="footer-content">
        <h3>MJU & FISHTECH</h3>
        <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Fuga quod reiciendis nostrum mollitia ullam.</p>
        <ul class="socials">
            <li><a href="#"><i class="fa-brands fa-facebook"></i></a></li>
            <li><a href="#"><i class="fa-brands fa-facebook-messenger"></i></a></li>
            <li><a href="#"><i class="fa-brands fa-line"></i></a></li>
            <li><a href="#"><i class="fa-brands fa-google-plus-square"></i></a></li>
            <li><a href="#"><i class="fa-solid fa-phone"></i></a></li>
        </ul>
    </div>
    <div class="footer-bottom">
        <p>จัดทำโดย & ITMJU 2022 . Designed by <span>MJUFISHTECH</span></p>
    </div>
</footer>
</body>
</html>