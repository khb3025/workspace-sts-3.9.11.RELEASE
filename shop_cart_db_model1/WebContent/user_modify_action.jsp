<%@page import="java.net.URLEncoder"%>
<%@page import="com.itwill.user.User"%>
<%@page import="com.itwill.user.UserService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="user_login_check.jspf" %>    
<%
	if(request.getMethod().equalsIgnoreCase("GET")){
		response.sendRedirect("shop_main.jsp");
		return;
	}
	String password=request.getParameter("password");
	String name=request.getParameter("name");
	String email=request.getParameter("email");
	UserService userService=new UserService();
	try{
		userService.update(new User(sUserId,password,name,email));
		RequestDispatcher rd=
			request.getRequestDispatcher("user_view.jsp");
		rd.forward(request, response);
		
	}catch(Exception e){
		e.printStackTrace();
		response.sendRedirect("user_main.jsp");
		return;
	}
%>
