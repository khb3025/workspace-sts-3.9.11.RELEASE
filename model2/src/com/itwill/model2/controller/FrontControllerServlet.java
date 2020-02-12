package com.itwill.model2.controller;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/*
 * 클라이언트의 모든요청을 받는 서블릿(Controller)
 */
public class FrontControllerServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}
	private void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/*
		 * /member_main.do 			--> WEB-INF/views/member_main.jsp 
		 * /member_detail.do 		--> WEB-INF/views/member_detail.jsp 
		 * /member_list.do 			--> WEB-INF/views/member_main.jsp 
		 * /member_login_form.do 	--> WEB-INF/views/member_login_form.jsp 
		 * /member_error.do 		--> WEB-INF/views/member_error.jsp
		 * 
		 * member_controller.do?cmd=member_main
		 * member_controller.do?cmd=member_detail
		 * member_controller.do?cmd=member_list
		 * member_controller.do?cmd=member_login_form
		 * 
		 */

		/*
		 * 1.클라이언트 요청분석(URL,parameter)
		 */
		String requestURI = request.getRequestURI();
		System.out.println("requestURI:" + requestURI);
		String contextPath = request.getContextPath();
		System.out.println("contextPath:" + contextPath);
		String command = requestURI.substring(contextPath.length());
		System.out.println("command:" + command);
		/*
		 * 2.클라이언트요청에따른 업무실행(Service객체)
		 */
		String forwardPath = "";
		if (command.equals("/member_main.do")) {
			forwardPath = "forward:/WEB-INF/views/member_main.jsp";
		} else if (command.equals("/member_login_form.do")) {
			forwardPath = "forward:/WEB-INF/views/member_login_form.jsp";
		} else if (command.equals("/member_list.do")) {
			ArrayList<String> memberList=new ArrayList<String>();
			memberList.add("김경호");
			memberList.add("최경녀");
			memberList.add("김은희");
			memberList.add("김봉화");
			request.setAttribute("memberList", memberList);
			forwardPath = "forward:/WEB-INF/views/member_list.jsp";
		} else if (command.equals("/member_detail.do")) {
			request.setAttribute("member", "김은희");
			forwardPath = "forward:/WEB-INF/views/member_detail.jsp";
		} else if (command.equals("/member_error.do")) {
			forwardPath = "forward:/WEB-INF/views/member_error.jsp";
		} else {
			request.setAttribute("msg", "에로사항발생");
			forwardPath = "forward:/WEB-INF/views/member_error.jsp";
			//forwardPath = "redirect:member_error.do";
		}
		/*
		 * 3.jsp 로 forward or redirect
		 * 		redirect:xxx.do
		 * 		forward:/WEB-INF/views/xxx.jsp
		 * 
		 */
		
		 String[] pathArray= forwardPath.split(":");
		 String isRedirect=pathArray[0];
		 forwardPath = pathArray[1];
		 
		 if(isRedirect.equals("redirect")) {
			  
			 response.sendRedirect(forwardPath);
		 
		 }else if(isRedirect.equals("forward")) {
			 
			  RequestDispatcher rd=
					  request.getRequestDispatcher(forwardPath);
					 rd.forward(request, response);
		  }
		
		 
		 
	}

}
