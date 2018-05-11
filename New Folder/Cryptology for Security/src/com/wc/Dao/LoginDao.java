package com.wc.Dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import com.sun.mail.iap.ConnectionException;
import com.wc.ProfileBean.LoginProfileBean;
import com.wc.core.AbstractDataAccessObject;




public class LoginDao extends AbstractDataAccessObject{

	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs;
	String role;
	String ans;
	boolean flag;
	public String loginCheak(LoginProfileBean lp) throws SQLException {

		try {
			String nm = lp.getName();
			String pss = lp.getPass();
			ps = getConnection().prepareStatement(
					"select role from userlogin where name=? and password=?");
			ps.setString(1, nm);
			ps.setString(2, pss);
			rs = ps.executeQuery();
			if (rs.next()) {
				role = rs.getString(1);

			} else {
				System.out.println("invalid user name or password");

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
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
		return role;

	}
	public String pswRecover(LoginProfileBean lp) throws SQLException{
		String password;
		String loginid = lp.getName();
		String secretquestid = lp.getSques();
		String secretans = lp.getSans();
		try {
			con = getConnection();
			con.setAutoCommit(true);
			CallableStatement cstmt = con
					.prepareCall("{call RecoverPassword(?,?,?,?)}");
			cstmt.setString(1, loginid);
			cstmt.setString(2, secretquestid);
			cstmt.setString(3, secretans);
			cstmt.registerOutParameter(4, Types.VARCHAR);
			cstmt.execute();
			password = cstmt.getString(4);
			con.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
			//LoggerManager.writeLogSevere(ex);
			System.out.println(ex);
			password = "";
		} catch (Exception e) {
			//LoggerManager.writeLogSevere(e);
			System.out.println(e);
			password = "";
		} finally {
			con.close();
		}
		return password;
	}
	public int newpasswd1(LoginProfileBean lp)throws SQLException {
		int m1 = 0;
		
		try {
			
			ps = getConnection().prepareStatement(
					"update userlogin set password=? where id=(select id from userlogin where name=?)");
		
			ps.setString(1, lp.getNpass());
			ps.setString(2, lp.getName());
			m1 = ps.executeUpdate();
		
		} catch (Exception e) {
			// TODO: handle exception
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
		return m1;
	}
	
	public boolean changePassword(LoginProfileBean pro)
	throws ConnectionException {
try {
	con =getConnection();
	String loginid = pro.getName();
	String oldpassword = pro.getPass();
	String newpassword = pro.getNpass();
	try {
		con.setAutoCommit(false);
		CallableStatement cstmt = con
				.prepareCall("{call changePassword(?,?,?,?)}");
		cstmt.setString(1, loginid);
		cstmt.setString(2, oldpassword);
		cstmt.setString(3, newpassword);
		cstmt.registerOutParameter(4, Types.INTEGER);
		cstmt.execute();
		int i = cstmt.getInt(4);
		System.out.println("i=" + i);
		if (i == 1) {
			flag = true;
			con.commit();
		} else {
			flag = false;
			con.rollback();
		}
		con.close();
	} catch (SQLException ex) {
		ex.printStackTrace();
		System.out.println(ex);
		flag = false;
		try {
			con.rollback();
		} catch (SQLException sex) {
			//LoggerManager.writeLogSevere(sex);
		}
	} catch (Exception e) {
		e.printStackTrace();
		flag = false;
		try {
			con.rollback();
		} catch (SQLException sex) {
			sex.printStackTrace();
			//LoggerManager.writeLogSevere(sex);
			System.out.println(sex);
		}
	}
} finally {
	try {
		if (con != null)
			con.close();
	} catch (SQLException e) {
	}
}
return flag;
}

} 
