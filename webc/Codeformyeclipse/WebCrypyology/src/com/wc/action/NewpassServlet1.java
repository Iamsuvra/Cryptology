package com.wc.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wc.Dao.LoginDao;
import com.wc.ProfileBean.LoginProfileBean;




public class NewpassServlet1 extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
String path=null;
		try {

			LoginProfileBean lp = new LoginProfileBean();
			lp.setNpass(request.getParameter("newpss"));
			lp.setName(request.getParameter("nm"));
			int n1 = new LoginDao().newpasswd1(lp);
if(n1!=0)
{	
	
	path="index.jsp?status=password changed successfully " ;


}
else
{
	path="newpassword1.jsp?status=password cannot be changed due to server problem try again";
}
		
		} catch (Exception e) {
			e.printStackTrace();
		}
RequestDispatcher rd=request.getRequestDispatcher(path);
	rd.forward(request, response);
	}
}
