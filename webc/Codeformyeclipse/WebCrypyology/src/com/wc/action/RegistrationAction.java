package com.wc.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.RegularExpression;
import com.wc.Dao.UserProfileDao;
import com.wc.ProfileBean.AddressProfileBean;
import com.wc.ProfileBean.LoginProfileBean;


public class RegistrationAction extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request,response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 boolean flag=false;
		String target=""; 
		try{
		 LoginProfileBean lp=new LoginProfileBean();
	  lp.setName(  request.getParameter("userName"));
	   lp.setPass( request.getParameter("password"));
	    lp.setSques(request.getParameter("squest"));
	    lp.setSans(request.getParameter("secrete"));
	    
	    lp.setGender(request.getParameter("gender"));
		 lp.setPhoto(request.getParameter("photo"));
        lp.setFname(request.getParameter("firstName")); 
        lp.setLname(request.getParameter("lastName")); 
        lp.setDob(request.getParameter("dob")); 
       lp.setRole(request.getParameter("role"));
        //home
       
       AddressProfileBean ad=new AddressProfileBean();
        	
       ad.setHouseno(request.getParameter("houseNo"));
        ad.setStreet(request.getParameter("street"));
        ad.setCity(request.getParameter("city")); 
        ad.setState(request.getParameter("state")); 
        ad.setCountry(request.getParameter("country"));
        ad.setPincode(Integer.parseInt(request.getParameter("pin")));
        
        lp.setPhno(request.getParameter("phoneNo"));
       
       
        
       // rb.setStatus(1); 
        //rb.setFirstLogin(0); 
      
    flag=new UserProfileDao().register(lp,ad);
        
        if(flag) 
        {
        	target = "Registration.jsp?status=Registration Success"; 
        }
        	else  
        	{
        		target = "Registration.jsp?status=Registration Failed"; 
        	}
        	}catch(Exception e){e.printStackTrace();}
        request.getRequestDispatcher(target).forward(request,response);
       
	}
	
	
	
	
	}

	


