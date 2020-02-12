package com.itwill.servlet;

import javax.servlet.http.HttpServlet;

public class WebContainerMain {

	public static void main(String[] args) throws Exception{
		
		HttpServlet lifeCycleCounterServlet=
				(HttpServlet)Class.forName(
						"com.itwill.servlet.LifeCycleCounterServlet")
			.newInstance();
		lifeCycleCounterServlet.init(null);
		lifeCycleCounterServlet.service(null, null);
		
		

	}

}
