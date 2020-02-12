package com.itwill.guest.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwill.guest.GuestService;

@WebServlet("/guest_remove_action.do")
public class GuestRemoveActionServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// response.sendRedirect("guest_main.do");
		String forwardPath = "";

		forwardPath = "redirect:guest_main.do";

		String[] pathArray = forwardPath.split(":");
		String isRedirect = pathArray[0];
		forwardPath = pathArray[1];
		if (isRedirect.equals("redirect")) {
			response.sendRedirect(forwardPath);
		} else if (isRedirect.equals("forward")) {
			RequestDispatcher rd = request.getRequestDispatcher(forwardPath);
			rd.forward(request, response);
		}
		return;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String forwardPath="";
		/*
		 * 1 . 파라메타받기 
		 * 2 . Service객체 메쏘드호출(업무처리) 
		 * 3 . 요청클라이언트로 응답(jsp forward,redirect)
		 */
		try {
			String guest_noStr = request.getParameter("guest_no");
			GuestService guestService = new GuestService();
			boolean insertOK = guestService.deleteGuest(Integer.parseInt(guest_noStr));
			if (insertOK) {
				//response.sendRedirect("guest_list.jsp");
				forwardPath="redirect:guest_list.do";
			} else {
				//response.sendRedirect("guest_error.jsp");
				forwardPath="forward:/WEB-INF/views/guest_error.jsp";
			}
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
