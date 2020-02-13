<%@page import="com.itwill.bean.Guest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	Guest guest=
	new Guest(1,"KIM","2020","guard@naver.com","http://www.itwill.com","타이틀","컨텐트");	
	request.setAttribute("guest", guest);
	
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>
	EL Bean객체출력
</h1><hr/>
<ol>
	<li>${guest}</li>
	<li>${guest.getGuest_no()}</li>
	<li>${guest.getGuest_name()}</li>
	<li>${guest.getGuest_email()}</li>
	<li>${guest.getGuest_homepage()}</li>
	<li>-------------------------</li>
	<li>${guest.guest_no}</li>
	<li>${guest.guest_name}</li>
	<li>${guest.guest_email}</li>
	<li>${guest.guest_homepage}</li>
</ol>


</body>
</html>










