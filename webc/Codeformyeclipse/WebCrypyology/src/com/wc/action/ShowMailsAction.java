package com.wc.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.wc.Dao.DeleteMailDao;
import com.wc.Dao.InboxDao;
import com.wc.ProfileBean.LoginProfileBean;

public class ShowMailsAction extends HttpServlet{

	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {

doPost(request,response);
}

public void doPost(HttpServletRequest request, HttpServletResponse response)
throws ServletException, IOException {
String path="";

	try {
		List<LoginProfileBean> email = new ArrayList<LoginProfileBean>();
		
		HttpSession session=request.getSession();
		 String s1=  (String)session.getAttribute("user");
      
		 email =	new	 InboxDao().sentMails( s1);

		 if (email != null) {
				
				System.out.println("stored in req scope");
				request.setAttribute("email", email);
				path = "sentMail.jsp";
			} else {
				path = "sentMail.jsp?status=no mails to display";
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request, response);
		System.out.println(path);

	}
	





}






