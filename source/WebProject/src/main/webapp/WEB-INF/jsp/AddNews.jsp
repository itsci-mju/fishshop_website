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
<html lang="en">
<head>
<style type="text/css">
* {
    padding: 0;
    margin: 0;
    box-sizing: border-box;
    font-family: 'Itim', sans-serif;
}

li,
ol,
ul {
    list-style: none;
}

a {
    text-decoration: none;
    color: inherit;
}

/*body-website*/
body {
background: #FFF;
}

.active-nav {
    visibility: visible;
    left: 0;
}

/* header */
.header {
    position: fixed;
    z-index: 900;
    width: 100%;
    top: 0;
}

/*header-log*/
.nav-login {
    z-index: 930;
    top: 0;
    width: 100%;
    background: #000;
    color: #fff;
    display: flex;
    justify-content: center;
    margin: 0 auto;
    align-items: center;

    flex-flow: row nowrap;
    word-break: break-word;
    overflow-wrap: break-word;

}

.nav-login h5 {
    font-size: 1rem;
}

.nav-login .logo-main,
.nav-login ul.menu-relog {
    padding: 10px;
}

ul.menu-relog {
    padding: 10px;
    display: flex;
    list-style: none;
    justify-content: center;
}

ul.menu-relog li {
    margin-left: 1rem;
}

ul.menu-relog li a {
    color: #fff;
    background-color: rgb(92, 193, 94);
    padding: 0 7px 0 7px;
    width: 150px;
    border-radius: 10px;
    text-decoration: none;
    transition: 0.3s;
}

ul.menu-relog li a:hover {
    color: rgb(103, 245, 103);
}

/*navbar*/
nav {
    background-color: #FFF;
    position: relative;
    z-index: 910;
    display: flex;
    align-items: center;
    flex-wrap: wrap;
    justify-content: space-between;
    align-items: stretch;
    left: 0;
    right: 0;
    width: 95%;
    max-width: 1300px;
    margin: 10px auto;
    box-shadow: 0 2px 2px 0 rgba(0, 0, 0, 0.14), 0 3px 1px -2px rgba(0, 0, 0, 0.2), 0 1px 5px 0 rgba(0, 0, 0, 0.12);
    border-radius: 80px;
    height: 70px;
}

nav ul {
    display: flex;
    justify-content: space-around;
    align-items: center;
    flex-wrap: wrap;
    width: calc(100% - 200px);
    height: 100%;
    margin-right: 10px;
}

nav li {
    text-align: center;
    list-style: none;
    width: 16%;
    height: 100%;
}

nav li a {
    text-decoration: none;
    color: rgb(0, 0, 0);
    display: flex;
    justify-content: center;
    align-items: center;
    flex-wrap: wrap;
    text-align: center;
    transition: color 0.3s, transform 0.3s;
    position: relative;
    height: 100%;
}

nav li a:active {
    background: #cccccc;
}

nav li a span {
    transition: transform 0.3s;
}

nav li a span:before {
    content: "";
    width: 0;
    height: 0;
    background: #4f73d0;
    transition: width 0.3s, height 0.3s;
    position: absolute;
    margin: auto;
    bottom: -13px;
    right: 0;
    left: 0;
    z-index: -1;
    border-radius: 50%
}


nav .logo-nav {
    color: #fff;
    display: flex;
    justify-content: center;
    align-items: center;
    flex-wrap: wrap;
    background: linear-gradient(125.61deg, #9a98f3 9.18%, #c692ef 89.32%);
    border-radius: 80px 0px 0px 80px;
    width: 180px;
}

nav ul li:hover>a span:before {
    width: 10px;
    height: 10px;
}

nav ul li:hover>a span {
    transform: translateY(-7px);
}

.nav-toggle {
    position: fixed;
    top: 0.5rem;
    left: 0.5rem;
    width: 50px;
    height: 50px;
    font-size: 30px;
    display: inline-block;
    cursor: pointer;
    z-index: 940;
    visibility: hidden;
    font-family: "Font Awesome 6 Free";

    background: linear-gradient(125.61deg, #9a98f3 9.18%, #c692ef 89.32%);
    border-radius: 80px;
    color: white;
    display: flex;
    justify-content: center;
    align-items: center;
    flex-wrap: wrap;
}

/* banner */
.head-banner {
    background: url(../img/imgfish/bann.png);
    background-position: center;
    background-repeat: no-repeat;
    background-size: cover;
}

.head-banner .bann_main_in {
    background: none;
}

.head-banner .bann_main_in {
    height: 260px;
    text-align: center;
    padding-top: 80px;
    display: flex;
    justify-content: center;
    align-items: center;
    flex-wrap: wrap;
    flex-direction: column;
    z-index: 2;
}

/* nav second */
.page-btn-list {
    background: #e91e63;
    z-index: 3;
    position: relative;
    align-items: center;
    justify-content: center;
    display: flex;
    flex-wrap: wrap;
    list-style: none;
    padding: 18px;
}

.page-btn-item .page-btn-item__link {
    display: flex;
    justify-content: center;
    align-items: center;
    flex-wrap: wrap;
    z-index: 2;
    transition: 0.3s;
    text-decoration: none;
}

.page-btn-item__link {
    color: #FFF;
}

.page-btn-item__link .icon {
    padding-left: 50px;
}

.page-btn-list .page-btn-item {
    width: 15%;
    border-left: 1px solid #fff;
    border-right: 1px solid #fff;
}

/* ------------------------------------- Start main website -------------------------------- */

/* ------------------------------------- End main website --------------------------------- */

/*contact*/
.con-us {
    background: url(../img/imgfish/conn2.png) no-repeat center/cover;
    position: relative;
}

.con-us .cont-banner {
    height: 185px;
    position: relative;
}

.con-us .con-text {
    letter-spacing: 0;
    border-radius: 50%;
    display: flex;
    justify-content: center;
    align-items: center;
    flex-wrap: wrap;
    flex-direction: column;
    width: 300px;
    height: 300px;
    margin: auto;
    padding-top: 20px;
    position: absolute;
    right: 0;
    left: 0;
    top: 0;
    bottom: 0;
    background: linear-gradient(90.25deg, #16d1eb 0.24%, #19dada 99.8%);
    z-index: 2;
}

.con-us .con-text-title {
    color: #fff;
    font-weight: 300;
    font-size: 36px;
    line-height: 52px;
    margin-bottom: 13px;
}

.con-us .con-text-sub {
    color: #fff;
    font-weight: 300;
    font-size: 36px;
    line-height: 52px;
    margin-bottom: 13px;
}

.con-us .con-text-click {
    font-weight: 500;
    font-size: 18px;
    line-height: 1.3;
    text-align: center;
    color: #15b5c0;
    background: #fff;
    border-radius: 6px;
    padding: 4px 15px;
    display: flex;
    justify-content: center;
    align-items: center;
    flex-wrap: wrap;
    width: 177px;
    margin-bottom: 10px;
    transition: color 0.3s;
}

/*footer*/
footer {
    background-color: #24262b;
    padding: 70px 0;
}

.row {
    display: flex;
    flex-wrap: wrap;
}

.container {
    max-width: 1170px;
    margin: auto;
}

.ul {
    list-style: none;
}

.footer-col {
    width: 25%;
    padding: 0 15px;
}

.footer-col h4 {
    font-size: 18px;
    color: #fff;
    text-transform: capitalize;
    margin-bottom: 35px;
    font-weight: 500;
    position: relative;
}

.footer-col h4::before {
    content: '';
    position: absolute;
    left: 0;
    bottom: -10px;
    background-color: #e91e63;
    height: 2px;
    box-sizing: border-box;
    width: 50px;
}

.footer-col ul li:not(:last-child) {
    margin-bottom: 10px;
}

.footer-col ul li a {
    font-size: 16px;
    text-transform: capitalize;
    color: #fff;
    text-decoration: none;
    font-weight: 300;
    color: #bbb;
    display: block;
    transition: all 0.3s ease;
}

.footer-col ul li a:hover {
    color: #fff;
    padding-left: 8px;
}

.footer-col .social-links a {
    display: inline-block;
    height: 40px;
    width: 40px;
    background-color: rgba(255, 255, 255, 0.2);
    margin: 0 10px 10px 0;
    text-align: center;
    line-height: 40px;
    border-radius: 50%;
    color: #fff;
    transition: all 0.3s ease;
}

.footer-col .social-links a:hover {
    color: #24262b;
    background-color: #fff;
}

.footer-col .tax-add p {
    color: #fff;
}

/* end website */

/* ------------------------------------------------------------------------------------------ */
/*javasrcipt*/
@media(max-width: 767px) {

    body.active-nav nav {
        left: 0;
    }

    body.active-nav .content {
        left: 70%;
    }

    body.active-nav #js-nav-toggle i:before {
        content: '\f00d';
    }

    /*header*/

    .header {
        position: fixed;

    }

    nav .logo-nav {
        width: 100%;
        border-radius: 0;
        height: 80px;
    }

    .nav-login {
        align-items: stretch;
        margin: 0px;
        flex-flow: column wrap;
        text-align: center;
    }

    .nav-login .logo-main {
        padding-bottom: 5px;
    }

    .nav-login ul.menu-relog {
        padding-top: 5px;
    }

    nav {
        /* visibility: hidden; */
        background-color: #FFF;
        z-index: 935;
        position: fixed;
        top: 0;
        left: -100%;
        right: 0;
        height: 100%;
        width: 70%;
        margin: 0;
        border-radius: 0;
        flex-flow: column wrap;
        flex-wrap: nowrap;
        align-items: stretch;
        min-height: 400px;
        transition: left 300ms;
        overflow-y: scroll;
        overflow-x: hidden;
        min-width: 300px;
    }

    nav ul {
        display: block;
        width: 100%;
    }

    nav li {
        width: 100%;
        height: 80px;
    }

    nav li a {
        border-bottom: 1px solid #cccccc;
    }

    .nav-toggle {
        visibility: visible;
    }

    .nav-login {
        position: fixed;
        top: 0;
    }

    .slideshow-container {
        /* max-width: 100%; */
        height: unset;
        position: relative;
        margin: auto;
    }

    .connews-box-area {
        width: 100%;
    }


    /*footer*/
    .footer-col {
        width: 50%;
        /* margin-bottom: 30px; */
    }

}

@media(max-width: 574px) {
    .menu-relog {
        width: 100%;
    }

    .footer-col {
        width: 100%;
    }
}

@keyframes fade {
    from {
        opacity: .4
    }

    to {
        opacity: 1
    }
}

/* On smaller screens, decrease text size */
@media only screen and (max-width: 300px) {
    .text {
        font-size: 11px
    }
}
</style>
 <script src="https://kit.fontawesome.com/9c6acb28e2.js" crossorigin="anonymous"></script>

    <!-- Font family -->
    <!--- Dynapuff --->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=DynaPuff:wght@400;500;600&display=swap" rel="stylesheet">
    <!--- Itim --->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Itim&display=swap" rel="stylesheet">
    <!--- Mali --->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Mali:wght@200;300;400;500;600&display=swap" rel="stylesheet">
</head>
<body>
 <!-- header -->
    <div class="header">
        <!---header-login--->
        <div class="nav-login">
            <div class="logo-main">
                <h5>มาร่วมเป็นส่วนหนึ่งกับพวกเรา</h5>
            </div>
            <ul class="menu-relog">
                <li class="regis-btn"><a href="register.html">สมัครสมาชิก</a></li>
                <li class="login-btn"><a href="login.html">เข้าสู่ระบบ</a></li>
            </ul>
        </div>
        <!----navbar----->
        <span class="nav-toggle" id="js-nav-toggle">
            <i class="fa-solid fa-bars"></i>
        </span>
        <nav id="js-menu">
            <div class="logo-nav">
                <h2>MJUFishtech</h2>
            </div>
            <ul>
                <li><a href="index.html"><span>หน้าแรก</span></a></li>
                <li><a href="shop.html"><span>สินค้าของเรา</span></a></li>
                <li><a href="cart.html"><span>ตะกร้าสินค้า</span></a></li>
                <li><a href="about.html"><span>เกี่ยวกับเรา</span></a></li>
                <li><a href="news.html"><span>ข่าวสารข้อมูล</span></a></li>
                <li><a href="contact.html"><span>ติดต่อสอบถาม</span></a>
                </li>
            </ul>
        </nav>
    </div>
    <div class="content" id="content"></div>

    <!-----main-website------>
    <section class="contain-main">
        <div class="add-news_main">
            <div class="add-news_txt">
                <h2 class="add-n-title">หน้าต่างเพิ่มข่าวสารข้อมูล</h2>
                <span class="add-n-sub-tt">Add News</span>
            </div>
<table>
<form name="frm" method="post" enctype="multipart/form-data"action="${pageContext.request.contextPath}/LoadAddNews">
<div class="news-add_group">
                    <div class="news-add_img">
NewsPic : <input type="file" name="NewsPic" required class="name" class="news-add-img_news"><br>
 </div>
                </div>
 <div class="add-news-content">
                <div class="news-add_group">
                    <div class="news-add_name">
NewsName : <input type="text" name="NewsName"  class="add-news_name--textbox" placeholder="ชื่อหัวข่าว" required
                            class="name">> 
                        <i class="fa-solid fa-newspaper"></i>
                    </div>
                </div>
<div class="news-add_group">
                    <div class="news-add_detail">
NewsDetail : <textarea id="NewsDetail" name="NewsDetail" rows="5" cols="60" class="name"  placeholder="รายละเอียดของข่าว" class="news-add_detail_txa">>
</textarea>
                    </div>
                </div>
                <div class="news-add_group">
                    <div class="news-add_submit">
 <button type="submit" class="news-submit">กดยืนยัน</button>
                    </div>
                    <div class="news-back_cancel">
                        
                    </div>
                </div>
            </div>
        </div>
</form>
<% 
	if (r == 1) {%>a
			บันทึกสำเร็จ
	
	<% } else if (r == -1){%>
			เกิดข้อผิดพลาด ไม่สามารถบันทึกได้!!
	<%} %>
</table>
  <div class="con-us">
        <!-- img-backgourd size 2600*460 px -->
        <div class="cont-banner">
            <a href="contact.html" class="con-text">
                <p class="con-text-title">ติดต่อสอบถาม</p>
                <p class="con-text-sub">เพิ่มเติมได้</p>
                <p class="con-text-click">CLICK !</p>
            </a>
        </div>
    </div>
    <!-----footer------>
    <footer>
        <div class="container">
            <div class="row">
                <div class="footer-col">
                    <h4>หน้าต่างข้อมูล</h4>
                    <ul>
                        <li><a href="#">เกี่ยวกับเรา</a></li>
                        <li><a href="#">ข้อมูลวิชาการ</a></li>
                        <li><a href="#">ระบบเบิก-จ่ายพัสดุ</a></li>
                        <li><a href="#">ระบบแจ้งซ่อม</a></li>
                    </ul>
                </div>
                <div class="footer-col">
                    <h4>Infomation</h4>
                    <ul>
                        <li><a href="#">E-mail MJUFishtech</a></li>
                        <li><a href="#">Website MJUFishtech</a></li>
                    </ul>
                </div>
                <div class="footer-col">
                    <h4>ติดต่อสอบถาม</h4>
                    <div class="tax-add">
                        <p>คณะเทคโนโลยีการประมงและทรัพยากรทางน้ำ มหาวิทยาลัยแม่โจ้ 63 หมู่ 4 ต.หนองหาร
                            อ.สันทราย จ.เชียงใหม่ 50290</p>
                        <p>โทรศัพท์: 053-875100-3</p>
                        <p>โทรสาร : 053-875100-3 ต่อ 130</p>
                    </div>
                </div>
                <div class="footer-col">
                    <h4>Social</h4>
                    <div class="social-links">
                        <a href="#"><i class="fa-brands fa-facebook"></i></a>
                        <a href="#"><i class="fa-brands fa-facebook-messenger"></i></a>
                        <a href="#"><i class="fa-brands fa-line"></i></a>
                        <a href="#"><i class="fa-solid fa-phone"></i></a>
                        <a href="#"><i class="fa-brands fa-google-plus-square"></i></a>
                    </div>
                </div>
            </div>
        </div>
    </footer>

    <script src="js/script-nav.js"></script>
</body>
</html>