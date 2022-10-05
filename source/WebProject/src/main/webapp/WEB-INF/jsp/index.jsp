<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="org.itsci.fishshop.model.*,org.itsci.fishshop.dao.*,java.util.*"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>index</title>
</head>
<body align="center">
<form name="frm" action="SearchProduct" method="POST">
	SearchProduct: <input type="text" name="search">
	<input type="submit" value="search" Onclick="return check(frm)">
</form>
<table>
<!--  
<a href="LoadAddRegister">Register</a><br>
<a href="LoadAddProduct">AddProduct</a><br>
<a href="LoadAddNews">AddNews</a><br>
<a href="SearchNews">EditNews</a><br>
<a href="SearchProduct">EditProduct</a><br>-->
<td><a href="loadAllProduct">สินค้า</a></td>
<td><a href="loadAllNews">ข่าว</a></td>
<td><a href="loadprofile">โปรไฟล์</a></td>
</table>
</body>
</html>
