package com.wc.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wc.Dao.InboxDao;
import com.wc.ProfileBean.LoginProfileBean;
import com.wc.crypt.util.CryptMsgUtil;
import com.wc.crypt.util.EncryptFile1Util;

public class CreateNewMail extends HttpServlet {
	String path = null;
	File file;

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String message = null;

		try {
			String from = request.getParameter("from");
			String to = request.getParameter("to");
			String msg = request.getParameter("msg");
			String attach = request.getParameter("attach");
			System.out.println(attach + "attach");
			File f1 = null;
			FileInputStream fis = null;
			LoginProfileBean lp = new LoginProfileBean();
			CryptMsgUtil decrypt = new CryptMsgUtil("passPhrase");
			if (msg != null) {
				message = decrypt.encrypt(msg);
				if (message != null) {
					System.out.println("message encrypted   ");
				} else {
					System.out.println("message cannot be encrypted ");
				}
			}
			if (attach != null) {
				System.out.println(to);
				file = EncryptFile1Util.encryptFile(to, attach);
				file.toString().length();
				if (file != null) {
					System.out.println("file encrypted   ");
				} else {
					System.out.println("file cannot be encrypted ");
				}
			}
			lp.setMsg(message);
			lp.setAttachFile(file);
			System.out.println(file);
			lp.setFrom(from);
			lp.setTo(to);
			lp.setAttachment(attach);
			System.out.println(attach + "attach");
			lp.setFilelength(file.toString().length());
			int r1 = new InboxDao().sendMail1(lp, attach, to);
			if (r1 != 0) {
				path = "CreateNewMail.jsp?status=mail sent successfully";
			} else

			{
				path = "CreateNewMail.jsp?status=mail cannot be sent due to server problem";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.getRequestDispatcher(path).forward(request, response);

	}
}
