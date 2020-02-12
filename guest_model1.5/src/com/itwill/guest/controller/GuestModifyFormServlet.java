package com.itwill.guest.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwill.guest.Guest;
import com.itwill.guest.GuestService;

/**
 * Servlet implementation class GuestModifyFormServlet
 */
@WebServlet("/guest_modify_form.do")
public class GuestModifyFormServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//response.sendRedirect("guest_main.jsp");
		String forwardPath="";
		forwardPath="redirect:guest_main.do";
		
		
		String[] pathArray = forwardPath.split(":");
		String isRedirect = pathArray[0];
		forwardPath = pathArray[1];
		if (isRedirect.equals("redirect")) {
			response.sendRedirect(forwardPath);
		} else if (isRedirect.equals("forward")) {
			RequestDispatcher rd = request.getRequestDispatcher(forwardPath);
			rd.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String forwardPath="";
		/*
		 * 1.파라메타바끼 
		 * 2.GuestService.selectByNo()메쏘드호출 
		 * 3.request에 속성에 Guest객체를 추가한후 
		 *   guest_modify_form.jsp로 forwading 한다
		 */
		try {
			String guest_noStr = request.getParameter("guest_no");
			GuestService guestService = new GuestService();
			Guest guest = guestService.selectByNo(Integer.parseInt(guest_noStr));
			request.setAttribute("guest", guest);
			forwardPath="forward:/WEB-INF/views/guest_modify_form.jsp";
		}catch (Exception e) {
			e.printStackTrace();
			forwardPath="forward:/WEB-INF/views/guest_error.jsp";
		}
		
		
		String[] pathArray = forwardPath.split(":");
		String isRedirect = pathArray[0];
		forwardPath = pathArray[1];
		if (isRedirect.equals("redirect")) {
			response.sendRedirect(forwardPath);
		} else if (isRedirect.equals("forward")) {
			RequestDispatcher rd = request.getRequestDispatcher(forwardPath);
			rd.forward(request, response);
		}
		
		
	}

}
