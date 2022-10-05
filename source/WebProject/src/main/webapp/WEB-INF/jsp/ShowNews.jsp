<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="org.itsci.fishshop.model.*,org.itsci.fishshop.dao.*,java.util.*"  %>
<% List<News> list = (List<News>) request.getAttribute("resultNews");
  
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Show Product</title>
</head>
<body align="center">
<form name="frm" action="SearchProduct" method="POST">
	SearchNews: <input type="text" name="search">
	<input type="submit" value="search" Onclick="return check(frm)">
</form>
<%if(list != null){ %>
	<table border= "1">
	<tr><th>New Img</th><th>NewsName</th><th>NewsDetail</th></tr>
	<% 
	for (News n : list){ %>
		<tr>
			<td><img src="<%=n.getNewsPic()%>" width="200"></td>
			<td><%= n.getNewsName()%></td>
			<td><%=n.getNewsDetail()%></td>
		</tr>
		
	<%} %>
	</table>	
	
	<%	} %>
</body>
</html>