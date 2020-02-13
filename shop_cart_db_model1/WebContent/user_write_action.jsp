
<%@page import="com.itwill.common.Util"%>
<%@page import="java.net.URLEncoder"%>
<%@page import="java.net.URLDecoder"%>
<%@page import="com.itwill.user.exception.ExistedUserException"%>
<%@page import="com.itwill.user.UserService"%>

<%@page import="com.itwill.user.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	if(request.getMethod().equalsIgnoreCase("GET")){
		response.sendRedirect("user_write_form.jsp");
		return;
	}	

	//request.setCharacterEncoding("UTF-8");
	String userId=request.getParameter("userId");	
	String password=request.getParameter("password");
	//password = Util.getHashedString(password, "SHA-1");
	String name=request.getParameter("name");	
	String email=request.getParameter("email");	
	User newUser=null;
	try{
		UserService userService=new UserService();
		newUser=new User(userId,password,name,email);
		userService.create(newUser);
		response.sendRedirect("user_login_form.jsp");
	}catch(ExistedUserException e){
		//e.printStackTrace();
		/*********   case2********************
		response.sendRedirect("user_write_form.jsp?msg="+
		       URLEncoder.encode(e.getMessage(), "UTF-8"));
		*/
		/*************** case 1****************
		out.println("<script>");
		out.println("alert('"+e.getMessage()+"');");
		out.println("location.href='user_write_form.jsp?msg="
					+URLEncoder.encode(e.getMessage(), "UTF-8")+"';");
		out.println("</script>");
		*/
		request.setAttribute("fuser",newUser);
		request.setAttribute("msg", e.getMessage());
		RequestDispatcher rd=
				request.getRequestDispatcher("user_write_form.jsp");
		rd.forward(request, response);
		
	}catch(Exception e){
		e.printStackTrace();
		RequestDispatcher rd=
				request.getRequestDispatcher("user_error.jsp");
		rd.forward(request, response);
	}
%>















