package com.wc.Dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

import com.wc.DbUtil.DbUtil;

public class SecurityDao {
	Connection con=null; 
	boolean flag=false;
	 public String  checkUser(String userName)
	    {
	 	   String user=null;
	 	   System.out.println("username"+userName);
	 	   try 
	 	   
	        {
	 		   con= DbUtil.getConnection();
	        	//con.setAutoCommit(true); 
	            CallableStatement cstmt=con.prepareCall("{ call loginidavailablity1(?,?) }");
	            cstmt.setString(1, userName);
	            cstmt.registerOutParameter(2,Types.VARCHAR);           
	            cstmt.execute();
	            user=cstmt.getString(2);
	            System.out.println(  user);
	            con.close();
	        } 
	        catch (Exception ex) 
	        {ex.printStackTrace();
	        	
	            user=null;
	        }
	        
	        return user;        
	    }
	    
	    
}
