<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String member=(String)request.getAttribute("member");
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>member_detail.jsp</h1><hr/>
<p>
	<%=member %>
</p>
<div>
	<a href='member_main.do'>메인</a>
</div>

</body>
</html>