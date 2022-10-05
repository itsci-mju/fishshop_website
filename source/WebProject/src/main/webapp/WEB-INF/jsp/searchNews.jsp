<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="org.itsci.fishshop.model.*,org.itsci.fishshop.dao.*,java.util.*"  %>
<% List<News> list = (List<News>) request.getAttribute("result");
  
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Search News</title>
</head>
<body align="center">
<form name="frm" action="SearchNews" method="POST">
	SearchNews: <input type="text" name="search">
	<input type="submit" value="search" Onclick="return check(frm)">
</form>
	<%if(list != null){ %>
	<table border= "1">
	<tr><th>News ID</th><th>News Pic</th><th>News Name</th><th>News Deatil </th></tr>
	<% 
	for (News n : list){ %>
		<tr>
			<td><%= n.getNewsID()%> </a></td>
			<td><img src="img/<%=n.getNewsPic()%>" width="200"></td>
			<td><%=n.getNewsName()%></td>
			<td><%=n.getNewsDetail()%></td>
			<td><a href="loadEditNews?nid=<%=n.getNewsID()%>">แก้ไข</a> /
			<a href="DeleteNews?nid=<%=n.getNewsID()%>" onclick="return confirm('ต้องการลบข้อมูลนี้หรือไม่ ?');">ลบ</a></td>
		</tr>
		
	<%} %>
	</table>	
	
	<%	} %>
</body>
</html>