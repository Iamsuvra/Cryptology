package com.wc.action;

import java.io.IOException;
import java.util.StringTokenizer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.wc.Dao.LoginDao;
import com.wc.ProfileBean.LoginProfileBean;

public class LoginAction extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	HttpSession session;
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String nm=null;
		String pss =null;
		String rl=null;
		
		String target = "login.jsp?status=invalid username and password";
	try {
		session = request.getSession();
		String token=null;
		
		nm = request.getParameter("t1");
		pss= request.getParameter("t2");
		LoginProfileBean lp = new LoginProfileBean();
		lp.setName(nm);
		lp.setPass(pss);
		rl = new LoginDao().loginCheak(lp);
		System.out.println(rl);
		System.out.println("in try");
		StringTokenizer st=new StringTokenizer("hai.aru",".");
		while (st.hasMoreElements()) {
			         token   = st.nextToken();
			            
		       }
		System.out.println("Token = " + token);
		
		
		if (rl.equals("admin")) {
			target = "AdminHome.jsp?status=welcome"+nm;
			session.setAttribute("user", nm);
			session.setAttribute("pssword", pss);
			session.setAttribute("role", rl);
		} 
		else {
			target = "UserHome.jsp?status=welcome"+nm;
			session.setAttribute("user", nm);
			session.setAttribute("pssword", pss);
			session.setAttribute("role", rl);
		}
	
	}	
		catch (Exception e) {
		e.printStackTrace();
	}
		System.out.println(request.getContentType());
		System.out.println(request.getContentLength());
		RequestDispatcher rd = request.getRequestDispatcher(target);
		rd.forward(request, response);
	}
}
