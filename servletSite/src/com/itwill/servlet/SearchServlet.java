package com.itwill.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/search.do")
public class SearchServlet extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		/*
		 * 1.요청시에 전송되는 파라메타바끼
		 *    - 파라메타이름은 input element의 name속성과일치
		 *     	<input type="text" name="searchkeyword">
		 *    - search.do?searchkeyword=java
		 *   
		 *   << GET방식 파라메타 값 한글인코딩 >>
		      A. server.xml LINE 63 --> URIEncoding="EUC-KR" 속성추가
		       <Connector connectionTimeout="20000" port="80"
					protocol="HTTP/1.1" redirectPort="8443" 
					URIEncoding="EUC-KR"/>
		      B.요청객체에 문자인코딩설정  
		 */
		request.setCharacterEncoding("EUC-KR");
		String searchKeyword = 
				request.getParameter("searchkeyword");
		if(searchKeyword==null|| searchKeyword.equals("")) {
			response.sendRedirect("05-00.search_form.html");
			return;
		}
		/*
		 * 2.업무실행(DB)
		 */
		
		/*
		 * 3.클라이언트로 결과(html)전송 
		 */
		out.println("<h1>"+searchKeyword+" 의 검색결과</h1><hr>");
		out.println("<ol>");
		for (int i = 0; i < 10; i++) {
			out.println("<li>"+searchKeyword+" 의 검색데이타</li>");
		}
		out.println("</ol>");
		out.println("<a href='05-00.search_form.html'>검색페이지</a>");
	}

}












