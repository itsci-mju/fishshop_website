<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="org.itsci.fishshop.model.*,org.itsci.fishshop.dao.*,java.util.*"  %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<% List<News> list = (List<News>) request.getAttribute("result");
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
	<form name="frm" action="${pageContext.request.contextPath}/loadEditNews" method="post">
	<table border="1">
		<% if (list != null){
		   for(News n : list){ %>
		 <tr>
			<td>News ID : </td>
			<td><input type="text" name="NewsID" value="<%=n.getNewsID()%>"></td>
		</tr>
		 <tr>
			<td>News Pic : </td>
			<td><input type="file" name="NewsPic" value="<%=n.getNewsPic()%>"></td>
		</tr>
		 <tr>
		<tr>
			<td>News Name : </td>
			<td><input type="text" name="NewsName" value="<%=n.getNewsName()%>"></td>
		</tr>
		<tr>
			<td>News Detail : </td>
			<td><input type="text" name="NewsDetail" value="<%=n.getNewsDetail()%>"></td>
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