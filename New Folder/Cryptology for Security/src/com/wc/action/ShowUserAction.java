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


public class ShowUserAction extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
doPost(request, response);

}

public void doPost(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
String target = null;
List profile = new ArrayList();
try {
	HttpSession session = request.getSession();
String name=(String)session.getAttribute("user");
	String path = request.getRealPath("/userimages");
	profile = new UserProfileDao().getProfile1(name, path);
	if (profile != null) {
		request.setAttribute("profile", profile);
		target = "ShowProfile.jsp";
	} else {
		target = "ShowProfile.jsp?status=internal problem occured";
	}

} catch (Exception e) {
	e.printStackTrace();
}
request.getRequestDispatcher(target).forward(request, response);

}

}
