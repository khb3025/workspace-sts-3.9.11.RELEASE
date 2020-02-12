package com.itwill.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "imagecounter", urlPatterns = { "/imagecounter.do", "/imagecounter.nhn", "/imagecounter.itwill" })
public class ImageCounterServlet extends HttpServlet {
	private int count;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("2.service() 요청시마다호출:" + Thread.currentThread().getName() + "-->" + request.getRemoteAddr()
				+ "[" + request.getRemotePort() + "]");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println(
				"<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">");
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Insert title here</title>");
		out.println("</head>");
		out.println("<body bgcolor=#40e0d0 style=\"font-size: 9pt; line-height: 140%;\">");
		out.println("<center>");
		out.println("현재까지의 페이지뷰수 ");
		out.println("<img src='./image/2.png'/>");
		out.println("<img src='./image/1.png'/>");
		out.println("<img src='./image/4.png'/>");
		out.println("[" + ++count + "] 번입니다");
		out.println("</center>");
		out.println("</body>");
		out.println("</html>");
	}

}
