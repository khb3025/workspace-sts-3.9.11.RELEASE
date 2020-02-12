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


@WebServlet("/guest_modify_action.do")
public class GuestModifyActionServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String forwardPath="";
		try {
			request.setCharacterEncoding("UTF-8");
			String guest_noStr = request.getParameter("guest_no");
			String guest_name = request.getParameter("guest_name");
			String guest_email = request.getParameter("guest_email");
			String guest_homepage = request.getParameter("guest_homepage");
			String guest_title = request.getParameter("guest_title");
			String guest_content = request.getParameter("guest_content");
			GuestService guestService = new GuestService();
			Guest updateGuest = new Guest(Integer.parseInt(guest_noStr), guest_name, "", guest_email, guest_homepage,
					guest_title, guest_content);
			boolean updateOK = guestService.updateGuest(updateGuest);
			if (updateOK) {
				//response.sendRedirect("guest_view.jsp?guest_no=" + guest_noStr);
				forwardPath="redirect:guest_view.do?guest_no="+guest_noStr;
				//forwardPath="forward:guest_view.do";
			} else {
				//response.sendRedirect("guest_error.jsp");
				forwardPath="forward:/WEB-INF/views/guest_error.jsp";
			}
		}catch (Exception e) {
			e.printStackTrace();
			
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
