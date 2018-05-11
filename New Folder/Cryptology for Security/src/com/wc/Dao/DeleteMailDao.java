package com.wc.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.wc.core.AbstractDataAccessObject;

public class DeleteMailDao extends AbstractDataAccessObject{
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs;
	
public boolean deleteMail(int mid) throws SQLException{
		System.out.println("message id of admin is ------------->"+mid);
		boolean flag=false;
	
		try {
	ps=	getConnection().prepareStatement(
		"delete from inbox where msgno="+mid);	
	
		
	int u1=	ps.executeUpdate();
		
		if(u1!=0)
		{
			flag=true;
		}
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if (rs != null) {
				rs.close();
			}
			if (ps != null) {
				ps.close();
			}
			if (con != null) {
				con.close();
			}
		
		}
		
		
		
		return flag;
}		
		


}






