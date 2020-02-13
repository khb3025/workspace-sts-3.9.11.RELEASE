<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Date"%>
<%@page import="com.itwill.bean.Car"%>
<%@page import="com.itwill.bean.Student"%>
<%@page import="com.itwill.bean.Guest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	Guest g1 = new Guest(1, "KIM", "2020", "guard1@naver.com", "http://www.itwill.com", "타이틀1", "컨텐트1");
	Guest g2 = new Guest(2, "SIM", "2021", "guard2@naver.com", "http://www.itwill.com", "타이틀2", "컨텐트2");
	Guest g3 = new Guest(3, "DIM", "2019", "guard3@naver.com", "http://www.itwill.com", "타이틀3", "컨텐트3");
	
	HashMap<String,Guest> guestMap= new HashMap<String,Guest>();
	guestMap.put("g1", g1);
	guestMap.put("g2", g2);
	guestMap.put("g3", g3);
	request.setAttribute("guestMap", guestMap);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>EL Map 객체출력</h1>
	<hr />
	<ol>
		<li>${guestMap}</li>
		<li>${guestMap['g1']}</li>
		<li>${guestMap['g1'].guest_no}</li>
		<li>${guestMap['g1'].guest_email}</li>
		<li>${guestMap['g2']}</li>
		<li>${guestMap['g2'].guest_no}</li>
		<li>${guestMap['g2'].guest_email}</li>
		<li>${guestMap.g2.guest_no}</li>
		<li>${guestMap.g2.guest_email}</li>
	</ol>


</body>
</html>










