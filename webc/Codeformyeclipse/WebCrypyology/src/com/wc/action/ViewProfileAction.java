package com.wc.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.wc.Dao.UserProfileDao;


public class ViewProfileAction extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String target = null;
		List list = new ArrayList();
		try {
			HttpSession session = request.getSession();
			String loginname = (String) session.getAttribute("user");
			String path = request.getRealPath("/userimages");
			list = new UserProfileDao().getProfile(loginname, path);
			if (list != null) {
				request.setAttribute("list", list);
				target = "viewProfile.jsp";
			} else {
				target = "viewProfile.jsp?status=internal problem occured";
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		request.getRequestDispatcher(target).forward(request, response);

	}

}
