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

import com.wc.Dao.InboxDao;
import com.wc.ProfileBean.LoginProfileBean;

public class InboxAction extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path = null;
		HttpSession session=request.getSession();
	String name=(String)session.getAttribute("user");
		try {
			List<LoginProfileBean> email = new ArrayList<LoginProfileBean>();

			String role = request.getParameter("t1");
			//LoginProfile lp = new LoginProfile();
			//lp.setRole(role);
			email = new InboxDao().inboxMsg(name);
			if (email != null) {
			
				System.out.println("stored in req scope");
				request.setAttribute("email", email);
				path = "Inbox.jsp";
			} else {
				path = "Inbox.jsp?status=no mails to display";
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request, response);
		System.out.println(path);

	}
}
