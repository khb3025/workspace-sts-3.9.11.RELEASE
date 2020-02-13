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

	ArrayList<Guest> guestList = new ArrayList<Guest>();
	guestList.add(g1);
	guestList.add(g2);
	guestList.add(g3);

	Guest[] guestArray = new Guest[3];
	guestArray[0] = g1;
	guestArray[1] = g2;
	guestArray[2] = g3;
	request.setAttribute("guestList", guestList);
	request.setAttribute("guestArray", guestArray);
	int no = 2;
	pageContext.setAttribute("no", no);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>EL array,List 객체출력</h1>
	<hr />
	<ol>
		<li>-----array-----</li>
		<li>${guestArray}</li>
		<li>${guestArray[0]}</li>
		<li>${guestArray[0].guest_no}</li>
		<li>${guestArray[0].guest_name}</li>
		<li>${guestArray[0].guest_email}</li>
		<li>${guestArray[0].guest_homepage}</li>
		<li>${guestArray[0].guest_title}</li>
		<li>${guestArray[0].guest_content}</li>
		<li>${guestArray[1]}</li>
		<li>${guestArray[1].guest_no}</li>
		<li>${guestArray[1].guest_name}</li>
		<li>${guestArray[1].guest_email}</li>
		<li>${guestArray[1].guest_homepage}</li>
		<li>${guestArray[1].guest_title}</li>
		<li>${guestArray[1].guest_content}</li>
		<li>${guestArray[no]}</li>
		<li>${guestArray[no].guest_no}</li>
		<li>${guestArray[no].guest_name}</li>
		<li>${guestArray[no].guest_email}</li>
		<li>${guestArray[no].guest_homepage}</li>
		<li>${guestArray[no].guest_title}</li>
		<li>${guestArray[no].guest_content}</li>
		<%
			for (int i = 0; i < 3; i++) {
				pageContext.setAttribute("i", i);
		%>
		<li>${guestArray[i].guest_no},${guestArray[i].guest_name}</li>

		<%
			}
		%>
	</ol>
	<ol>
		<li>-----List-----</li>
		<li>${guestList}</li>
		<li>${guestList[0]}</li>
		<li>＄{guestList[0].guest_no}   : ${guestList[0].guest_no}</li>
		<li>＄{guestList['0'].guest_no} :${guestList['0'].guest_no}</li>
		<li>＄{guestList["0"].guest_no} :${guestList["0"].guest_no}</li>
		
		<li>${guestList[0].guest_name}</li>
		<li>${guestList[0].guest_email}</li>
		<li>${guestList[0].guest_homepage}</li>
		<li>${guestList[0].guest_title}</li>
		<li>${guestList[0].guest_content}</li>
		<li>${guestList[1]}</li>
		<li>${guestList[1].guest_no}</li>
		<li>${guestList[1].guest_name}</li>
		<li>${guestList[1].guest_email}</li>
		<li>${guestList[1].guest_homepage}</li>
		<li>${guestList[1].guest_title}</li>
		<li>${guestList[1].guest_content}</li>
		<li>${guestList[no]}</li>
		<li>${guestList[no].guest_no}</li>
		<li>${guestList[no].guest_name}</li>
		<li>${guestList[no].guest_email}</li>
		<li>${guestList[no].guest_homepage}</li>
		<li>${guestList[no].guest_title}</li>
		<li>${guestList[no].guest_content}</li>
		<%
			for (int i = 0; i < 3; i++) {
				pageContext.setAttribute("i", i);
		%>
			<li>${guestList[i].guest_no},${guestList[i].guest_name}</li>
		<%
			}
		%>
	</ol>


</body>
</html>










