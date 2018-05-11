package com.wc.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wc.Dao.DeleteMailDao;

public class DeleteMail extends HttpServlet {
	boolean flag=false;
	String path="";	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {

		doPost(request,response);
		}
		
		public void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {

		try {
			
	int mid=Integer.parseInt(request.getParameter("mid"));
		
	flag=new DeleteMailDao().deleteMail(mid);
		if(flag)
		{
			flag=true;
		System.out.println("the message deleted successfully---->"+flag);
		path="./InboxAction?status=message deleted sucessfully";
		
		}
		else{
			flag=false;
			System.out.println("the message cannot be deleted due to server problem---->"+flag);
		path="./InboxAction?status=internal problem occured";
		}
		
		} catch (Exception e) {
			e.printStackTrace();
			
		}	
			
			
		request.getRequestDispatcher(path).forward(request, response);
			
			
		
		}
}
