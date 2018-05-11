package com.wc.DbUtil;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;

import com.wc.core.AbstractDataAccessObject;
import com.wc.core.db.DBFactory;

public class InitServlet extends HttpServlet
{
	AbstractDataAccessObject dobject;

	public void init(ServletConfig sc)
	{
		ServletContext ctx = sc.getServletContext();
		InputStream fis = ctx.getResourceAsStream(sc.getInitParameter("config"));
		Properties props = new Properties();
		
		try
		{
			props.load(fis);
		}
		catch (IOException ioe)
		{
			ioe.printStackTrace();
		}
		dobject = new AbstractDataAccessObject();
		dobject.setProperties(props);

		

		try
		{
			new DBFactory();
		}
		catch (NullPointerException npe)
		{
			npe.printStackTrace();
		}
	}
}
