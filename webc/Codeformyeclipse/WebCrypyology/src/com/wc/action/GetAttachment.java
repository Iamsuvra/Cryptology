package com.wc.action;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.StringTokenizer;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.wc.Dao.InboxDao;

public class GetAttachment extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		File file = null;
		FileInputStream fis = null;
		BufferedInputStream bis = null;
		ServletOutputStream sos = null;
		String token = null;
		try {
			int mid = Integer.parseInt(request.getParameter("mid"));
			System.out.println(mid);
			HttpSession session = request.getSession();
			String s1 = (String) session.getAttribute("user");
			sos = response.getOutputStream();
			file = new InboxDao().getAttachment(mid);
			System.out.println("the out put file name" + file.getName());
			fis = new FileInputStream(file);
			bis = new BufferedInputStream(fis);
			byte[] bt1 = new byte[14170];
			int ln = 0;
			StringTokenizer st = new StringTokenizer(file.getName(), ".");
			while (st.hasMoreElements()) {
				token = st.nextToken();
			}
			System.out.println(token);
			if (token.equalsIgnoreCase("txt")) {
				response.setContentType("text/html");
			} else if (token.equalsIgnoreCase("jpeg")) {
				response.setContentType("image/jpeg");
			} else if (token.equalsIgnoreCase("doc")) {
				response.setContentType("application/msword");
			} else if (token.equalsIgnoreCase("png")) {
				response.setContentType("image/png");
			} else {
				System.out.println("attachment cannot be opened");
			}

			while ((ln = bis.read(bt1, 0, bt1.length)) != -1) {
				sos.write(bt1, 0, bt1.length);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {

				if (bis != null) {
					bis.close();
				}
				if (fis != null) {
					fis.close();
				}
				if (sos != null) {
					sos.close();
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
