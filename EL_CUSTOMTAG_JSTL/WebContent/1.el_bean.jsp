<%@page import="java.util.Date"%>
<%@page import="com.itwill.bean.Car"%>
<%@page import="com.itwill.bean.Student"%>
<%@page import="com.itwill.bean.Guest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	Guest g=
	new Guest(1,"KIM","2020","guard@naver.com","http://www.itwill.com","타이틀","컨텐트");	
	
	Student s=
			new Student(1000,"LEE",32,new Car(111,"SONATA",null));
	Date d=new Date();
	
	request.setAttribute("guest", g);
	request.setAttribute("student", s);
	request.setAttribute("date", d);
	
	
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
	<%-- 
	<li>${guest.getGuest_no()}</li>
	<li>${guest.getGuest_name()}</li>
	<li>${guest.getGuest_email()}</li>
	<li>${guest.getGuest_homepage()}</li>
	--%>
	<li>--------------Guest-----------</li>
	<li>${guest.guest_no}</li>

	<li>${guest.guest_name}</li>
	<li>${guest.guest_email}</li>
	<li>${guest.guest_homepage}</li>
	<li>${guest['guest_homepage']}</li>
	<li>-------------Student-----------</li>
	<li>${student}</li>
	<li>${student.no}</li>
	<li>${student.name}</li>
	<li>${student.age}</li>
	<li>${student.car}</li>
	<li>${student.car.no}</li>
	<li>${student.car.model}</li>
	<li>${student.car.color}</li>
	<li>---------------Date---------------</li>
	<li>${date}</li>
	<li>${date.year+1900} 년</li>
	<li>${date.month+1} 월</li>
	<li>${date.day+10} 일</li>
	<li>${date.toLocaleString()}</li>
	
</ol>


</body>
</html>










