package cn.zj.springmvc.controller;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {

	@RequestMapping("list1")
	public void test(HttpServletRequest request,HttpServletResponse response) throws Exception{
		System.out.println(request.getMethod());
		System.out.println(request.getContextPath());
		System.out.println(request.getRemoteAddr());
		System.out.println(request.getRequestURI());
		System.out.println(request.getQueryString());
		System.out.println(request.getProtocol());
		request.getRequestDispatcher("dispatcher").forward(request, response);
		response.sendRedirect("");
		ServletContext servletContext = request.getServletContext();
		servletContext.getResourceAsStream("../jdbc.properties");
		response.setHeader("refresh", "3;url=/day14");
	}
}
