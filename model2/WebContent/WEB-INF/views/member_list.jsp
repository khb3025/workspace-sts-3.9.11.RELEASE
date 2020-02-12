<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%
 	ArrayList<String> memberList=
 		(ArrayList<String>)request.getAttribute("memberList");
 	
 %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>member_list.jsp</h1><hr/>
<ol>
	<%for(String member:memberList){ %>
	<li><%=member %></li>
	<%} %>
</ol>
<div>
	<a href='member_main.do'>메인</a>
</div>

</body>
</html>