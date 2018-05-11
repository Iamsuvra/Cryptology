package com.wc.Dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import com.wc.DbUtil.DateWrapper;
import com.wc.DbUtil.DbUtil;
import com.wc.ProfileBean.AddressProfileBean;
import com.wc.ProfileBean.LoginProfileBean;

public class UserProfileDao {
	File file = null;
	FileInputStream fis = null;
	CallableStatement cstmt = null;
	PreparedStatement ps = null;

	public boolean register(LoginProfileBean lp, AddressProfileBean ad) {

		boolean flag = false;

		Connection con = null;

		String bdate = DateWrapper.parseDate(lp.getDob());

		try {
			System.out.println("photo=" + lp.getPhoto());
			file = new File(lp.getPhoto());
			FileInputStream fis = new FileInputStream(file);
			System.out.println("fole=" + file.length());

			con = DbUtil.getConnection();

			// con.setAutoCommit(false);
			CallableStatement cstmt = con
					.prepareCall("{call insertprocedure1(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			cstmt.setBinaryStream(1, fis, (int) file.length());
			cstmt.setString(2, lp.getFname());
			cstmt.setString(3, lp.getLname());
			cstmt.setString(4, bdate);
			cstmt.setString(5, lp.getGender());
			cstmt.setString(6, lp.getName());
			cstmt.setString(7, lp.getPass());
			//cstmt.setString(8, lp.getRole());
			cstmt.setString(8, lp.getSques());
			cstmt.setString(9, lp.getSans());

			cstmt.setString(10, ad.getHouseno());
			cstmt.setString(11, ad.getStreet());
			cstmt.setString(12, ad.getCity());
			cstmt.setString(13, ad.getState());
			cstmt.setString(14, ad.getCountry());
			cstmt.setInt(15, ad.getPincode());
			cstmt.setString(16, lp.getPhno());
			int i = cstmt.executeUpdate();
			if (i != 0) {
				flag = true;
			} else {
				flag = false;

			}
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return flag;

	}

	@SuppressWarnings({ "unused", "unchecked" })
	public List getProfile(String loginname, String path) {
		List<AddressProfileBean> ad = new ArrayList<AddressProfileBean>();

		List<LoginProfileBean> lp = new ArrayList<LoginProfileBean>();
		List list = new ArrayList();

		ResultSet rs = null;
		Connection con = null;
		int id = 0;
		LoginProfileBean rb = new LoginProfileBean();
		AddressProfileBean ad1 = new AddressProfileBean();

		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement("select id from userlogin where name=?");
			ps.setString(1, loginname);
			rs = ps.executeQuery();
			while (rs.next()) {
				id = rs.getInt(1);
			}
			CallableStatement cs = con
					.prepareCall("{call showprofile(?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");

			cs.setString(1, loginname);

			cs.registerOutParameter(2, Types.VARCHAR);
			cs.registerOutParameter(3, Types.VARCHAR);
			cs.registerOutParameter(4, Types.VARCHAR);
			cs.registerOutParameter(5, Types.VARCHAR);
			cs.registerOutParameter(6, Types.VARCHAR);
			cs.registerOutParameter(7, Types.VARCHAR);
			cs.registerOutParameter(8, Types.VARCHAR);
			cs.registerOutParameter(9, Types.VARCHAR);
			cs.registerOutParameter(10, Types.VARCHAR);
			cs.registerOutParameter(11, Types.VARCHAR);
			cs.registerOutParameter(12, Types.VARCHAR);
			cs.registerOutParameter(13, Types.VARCHAR);
			cs.registerOutParameter(14, Types.BLOB);

			cs.execute();

			rb.setFname(cs.getString(2));
			System.out.println("the getted string is" + cs.getString(3));

			rb.setLname(cs.getString(3));

			rb.setDob(cs.getString(4));
			// rb.setPhoto(cs.getString());
			rb.setGender(cs.getString(5));
			rb.setLdate(cs.getString(6));

			ad1.setHouseno(cs.getString(7));
			ad1.setStreet(cs.getString(8));
			ad1.setCity(cs.getString(9));
			ad1.setState(cs.getString(10));
			// rb.setPin(cs.getString(13));
			ad1.setCountry(cs.getString(11));
			ad1.setPincode(cs.getInt(12));

			rb.setPhno(cs.getString(13));

			Blob b = cs.getBlob(14);

			String path1 = path + "/" + loginname + "+.jpg";
			byte b1[] = b.getBytes(1, (int) b.length());
			OutputStream fout = new FileOutputStream(path1);
			fout.write(b1);
			rb.setPhoto(path1);
			ad.add(ad1);
			lp.add(rb);

			list.addAll(lp);
			list.addAll(ad);

		}

		catch (Exception e) {
			e.printStackTrace();

		} finally {
			try {
				con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		return list;

	}

	public List<LoginProfileBean> getProfile1(String loginname, String path) {

		List<LoginProfileBean> profile = null;
		

		ResultSet rs = null;
		Connection con = null;
		@SuppressWarnings("unused")
		int id = 0;

		try {
			con = DbUtil.getConnection();
			ps = con
					.prepareStatement("select fname,lname,to_char(dob),to_char(Login_date),name,photo,phoneno,Id from userlogin where role=?");
			ps.setString(1, "user");
			rs = ps.executeQuery();
			if (rs.next()) {
				profile = new ArrayList<LoginProfileBean>();
				do {
					LoginProfileBean lp1 = new LoginProfileBean();
					lp1.setFname(rs.getString(1));
					lp1.setLname(rs.getString(2));
					lp1.setDob(rs.getString(3));
					lp1.setLdate(rs.getString(4));
					lp1.setName(rs.getString(5));
					
					String uniquename=rs.getString(8);
					Blob b = rs.getBlob(6);
					String path1 = path + "/" + uniquename + "+.jpg";
					byte b1[] = b.getBytes(1, (int) b.length());
					OutputStream fout = new FileOutputStream(path1);
					fout.write(b1);
					lp1.setPhoto(path1);
					lp1.setPhno(rs.getString(7));
					profile.add(lp1);
				} while (rs.next());

			}

			/*Blob b = rs.getBlob(6);
			byte b1[] = b.getBytes(1, (int) b.length());
			path = path + "/" + rs.getInt(1) + ".jpg";
			System.out.println("path  :@@@@@@@@@" + path);
			System.out.println("Realpath  :@@@@@@@@@" + realpath);
			OutputStream fout = new FileOutputStream(path);
			fout.write(b1);*/
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		return profile;

	}
}
