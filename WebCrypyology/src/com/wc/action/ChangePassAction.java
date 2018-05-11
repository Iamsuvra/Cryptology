package com.wc.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wc.Dao.LoginDao;
import com.wc.ProfileBean.LoginProfileBean;

public class ChangePassAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {

			LoginProfileBean lp = new LoginProfileBean();
			lp.setName(request.getParameter("t1"));
			lp.setSques(request.getParameter("t2"));
			lp.setSans(request.getParameter("t3"));
			String ans1 = new LoginDao().pswRecover(lp);

			if (request.getParameter("t3").equalsIgnoreCase(ans1)) {
				request.getRequestDispatcher(
						"NewPass.jsp?status=enter new password").forward(
						request, response);
			} else {
				request.getRequestDispatcher(
						"ChangePass.jsp?status=wrong question or answer")
						.forward(request, response);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
