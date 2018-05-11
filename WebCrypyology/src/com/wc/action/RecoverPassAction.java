package com.wc.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wc.Dao.LoginDao;
import com.wc.ProfileBean.LoginProfileBean;



/**
 * This RecoverPasswordAction Class implements the recover the
 * password in any case the user can forget the password using the 
 * security question and proper answer it will gain from database
 */
public class RecoverPassAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String target = "./Recoverpassword.jsp?status=<font color=red>Entries not Matched... Try Again</font>";
		;
		try {
			LoginProfileBean rb = new LoginProfileBean();
			String loginid = request.getParameter("username");
			String sanswer = request.getParameter("sanswer");
			rb.setName(loginid);
			rb.setSans(sanswer);
			String squestid = "";
			String password = "";
			squestid = request.getParameter("squest");
			if (request.getParameter("ch") != null) {
				squestid = request.getParameter("ownquest");
			}
			rb.setSques(squestid);
			password = new LoginDao().pswRecover(rb);
			if (password.equals("") || password == null)
				target = "./Recoverpassword.jsp?status=<font color=red>Entries not Matched... Try Again</font>";
			else
				target = "./login.jsp?Password is " + password;
			request.setAttribute("status", "Password is " + password);
		}
		/*catch (ConnectionException e) {
			request.setAttribute("status", e.getMessage());
			target= "./jsps/loginform.jsp";
		}*/
		catch (Exception e) {
			request.setAttribute("status", e.getMessage());
			target= "./login.jsp";

			//LoggerManager.writeLogSevere(e);
			System.out.println(e);
		}finally {
		RequestDispatcher rd = request.getRequestDispatcher(target);
		rd.forward(request, response);
	}
}}
