package com.itwill.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwill.address.Address;
import com.itwill.address.AddressDao;
import com.itwill.address.AddressService;
@WebServlet("/jdbc_servlet2.do")
public class JdbcServlet2 extends HttpServlet {
	
	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		try {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			
			/*
			 * 1.Service객체생성
			 * 2.메쏘드호출
			 */
			AddressService addressSevice=
					new AddressService();
			
			ArrayList<Address> addressList=
					addressSevice.findAll();
			
			out.println("<html>");
			out.println("<head>");
			out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"com.css\">");
			out.println("</head>");
			out.println("<body>");
			out.println("<br>");
			out.println("<p align=center><font size=5 color=#0000FF>◈◈ JDBC 테스트 2◈◈</font><br>");
			out.println("<table width=80% align=center border=1 cellspacing=0 bordercolordark=white bordercolorlight=#ADADAD>");
			out.println("<tr bgcolor=#000000 class=t1>");
			out.println("<td align=center height=20 width=25%><font color=#FFFFFF>이름</font></td>");
			out.println("<td align=center height=20 width=25%><font color=#FFFFFF>전화번호</font></td>");
			out.println("<td align=center height=20 width=50%><font color=#FFFFFF>주소</font></td>");
			out.println("</tr>");
			
			for (Address address:addressList) {
				out.println("<tr class=t1>");
				out.println("<td align=center width=25% height=20>"+address.getName()+"</td>");
				out.println("<td align=center width=25% height=20>"+address.getPhone()+"</td>");
				out.println("<td align=center width=50% height=20>"+address.getAddress()+"</td>");
				out.println("</tr>");
			}
			out.println("</table>");
			out.println("</body>");
			out.println("</html> ");
		}catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect("error.html");
		}
	}

}
