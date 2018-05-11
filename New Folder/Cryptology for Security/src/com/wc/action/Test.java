package com.wc.action;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.StringTokenizer;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.bouncycastle.asn1.ocsp.Request;


import com.wc.Dao.InboxDao;

public class Test extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		File file = null;RequestDispatcher rd=null;
		FileInputStream fis = null;
		BufferedInputStream bis = null;
		ServletOutputStream sos = null;
		String token = null,path=null;
		
			int mid = Integer.parseInt(request.getParameter("mid"));
			System.out.println(mid);
			HttpSession session = request.getSession();
			String s1 = (String) session.getAttribute("user");
			
		
			Vector vcb=null;
			try {
				 vcb = new InboxDao().view(mid);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
System.out.println(" size is"+vcb.size());
			if (!vcb.isEmpty()) {
				request.setAttribute("vcb", vcb);
				request.setAttribute("status", "USERS INFORMATION");
				path ="testj.jsp";
			} else {
				request.setAttribute("status", "NO DATA");
				path ="testj.jsp";
			}
			rd = request.getRequestDispatcher(path);
			rd.forward(request, response);

			}

			}
