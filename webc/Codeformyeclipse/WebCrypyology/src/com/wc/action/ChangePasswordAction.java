package com.wc.action;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.wc.Dao.LoginDao;
import com.wc.ProfileBean.LoginProfileBean;

/**
 * The ChangePasswordAction Class implements the changing password providing
 * security for the particular user
 */
public class ChangePasswordAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to
	 * post.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		if ((String) session.getAttribute("user") == null)
			response
					.sendRedirect("./loginform.jsp?status=Session Expired");
		@SuppressWarnings("unused")
		String page = "";
		boolean flag = false;
		String target = "./changepassword.jsp?status=Password Changed Failed";
		LoginProfileBean rb = new LoginProfileBean();
		rb.setPass(request.getParameter("oldpassword"));
		rb.setName(request.getParameter("username"));
		rb.setNpass(request.getParameter("newpassword"));
		try {
			flag = new LoginDao().changePassword(rb);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (flag) {
			target = "./changepassword.jsp?status=Password Changed Successfully";
			request.setAttribute("status", "Password Changed Successfully");
		} else {
			target = "./changepassword.jsp";
			request.setAttribute("status", "Password Changing Failed");
		}
		RequestDispatcher rd = request.getRequestDispatcher(target);
		rd.forward(request, response);
	}

}
