<%@page import="com.itwill.user.UserService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="user_login_check.jspf" %>     
<%
	if(request.getMethod().equalsIgnoreCase("GET")){
		response.sendRedirect("shop_main.jsp");
		return;
	}
	UserService userService=new UserService();
	try{
		userService.remove(sUserId);
		response.sendRedirect("user_logout_action.jsp");
	}catch(Exception e){
		response.sendRedirect("user_error.jsp");
	}
%>