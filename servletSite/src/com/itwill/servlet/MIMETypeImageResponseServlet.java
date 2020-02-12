package com.itwill.servlet;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MIMETypeImageResponseServlet
 */
@WebServlet("/response_image.do")
public class MIMETypeImageResponseServlet extends HttpServlet {
	
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("image/jpeg");
		OutputStream out = response.getOutputStream();
		/*
		 * ServletContext : context(site)의 정보를 가지고있는객체
		 */
		ServletContext servletContext=
				this.getServletContext();
		String contextRealPath=
				servletContext.getRealPath("image/album.jpg");
		System.out.println("contextRealPath:"+contextRealPath);
		
		FileInputStream fis=new FileInputStream(contextRealPath);
		
		while (true) {
			int readByte = fis.read();
			if(readByte==-1)break;
			out.write(readByte);
		}
		fis.close();
		 
		
	}

}








