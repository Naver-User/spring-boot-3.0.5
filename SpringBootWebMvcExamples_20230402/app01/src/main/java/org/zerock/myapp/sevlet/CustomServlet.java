package org.zerock.myapp.sevlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;


@Log4j2
@NoArgsConstructor

// @WebServlet 어노테이션과 Spring component scan 으로는, Servlet 자동등록이 안됨
//@WebServlet("/customServlet")
public class CustomServlet extends HttpServlet {
	private static final long serialVersionUID = -3930404810537213242L;
		

	@Override
	public void service(HttpServletRequest req, HttpServletResponse res)
		throws ServletException, IOException {
		log.debug("service(req, res) invoked.");
		
		res.setContentType("text/html; charset=utf8");
		PrintWriter out = res.getWriter();
		
		out.println("Hello, Yoseph");
		
		out.flush();
		out.close();
	} // service

} // end class
