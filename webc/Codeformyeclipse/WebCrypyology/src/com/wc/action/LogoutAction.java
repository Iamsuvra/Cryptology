package com.wc.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoutAction extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
HttpSession session=null;
	try {
		session=request.getSession();
	
	
		session.invalidate();
		System.out.println("logout successfully");
	} catch (Exception e) {
		e.printStackTrace();
	}
	RequestDispatcher rd = request
	.getRequestDispatcher("login.jsp?status=logout successfully");
rd.forward(request, response);
	
	
	
	}
}
