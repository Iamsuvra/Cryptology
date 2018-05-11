package com.wc.Dao;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.Vector;

import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.SecretKey;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpSession;



import com.wc.DbUtil.DbUtil;
import com.wc.ProfileBean.LoginProfileBean;
import com.wc.core.AbstractDataAccessObject;
import com.wc.crypt.util.CryptMsgUtil;
import com.wc.crypt.util.DecryptFileUtil;

public class InboxDao extends AbstractDataAccessObject {
	static Cipher dcipher;
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs;
	String role;
	String name;
	HttpSession session = null;

	public static String asymKeyAlgorithm = "RSA";
	public static String asymAlgorithm = "RSA";
	public static int asymKeyAlgorithmStrength = 1024;
	public static String signatureAlgorithm = "SHA1WithRSAEncryption";

	// symmet.ric algorithms used
	public static String symKeyAlgorithm = "RIJNDAEL";
	public static String symAlgorithm = "RIJNDAEL";
	// public static String symAlgorithm = "BLOWFISH" ;
	// public static String symAlgorithm = "TWOFISH" ;
	public static int symAlgorithmStrength = 192;

	public List<LoginProfileBean> inboxMsg(String name) throws SQLException {
		List<LoginProfileBean> email = null;
		try {
			CryptMsgUtil decrypt = new CryptMsgUtil("passPhrase");

			// role = (String)session.getAttribute("role");
			// System.out.println(role);

			ps = getConnection()
					.prepareStatement(
							"select  msgno,msg_from,msg_to,msg,date_time from inbox where msg_to=?");

			ps.setString(1, name);
			rs = ps.executeQuery();
			if (rs.next()) {
				email = new ArrayList<LoginProfileBean>();
				do {
					LoginProfileBean lp1 = new LoginProfileBean();
					lp1.setMsgno(rs.getInt(1));
					lp1.setFrom(rs.getString(2));
					lp1.setTo(rs.getString(3));
					String message = decrypt.decrypt(rs.getString(4));
					System.out.println(message);
					lp1.setMsg(message);
					lp1.setDate(rs.getString(5));

					email.add(lp1);
				} while (rs.next());

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally

		{
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

		return email;

	}

	public int sendMail1(LoginProfileBean lp, String attach, String name) {
		int inserted = 0;

		System.out.println("name is" + name);
		try {
			File file = lp.getAttachFile();
			FileInputStream fis = new FileInputStream(file);
			//
			//
			// (select id from userlogin where name= '" +name + "')
			ps = getConnection()
					.prepareStatement(
							"insert into inbox values((select nvl(max(msgno),0)+1 from inbox),?,?,?,?,(select to_char(sysdate,'dy dd-mon-yy HH12:MIam')from dual),?,(select id from userlogin where name= '"
									+ name + "'))");
			ps.setString(1, lp.getFrom());
			System.out.println(lp.getFrom());
			ps.setString(2, lp.getTo());
			System.out.println(lp.getTo());
			ps.setString(3, lp.getMsg());
			System.out.println(lp.getMsg());
			ps.setBinaryStream(4, fis, (int) file.length());
			System.out.println(lp.getFilelength());
			ps.setString(5, attach);
			System.out.println(attach);
			inserted = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return inserted;
	}

	public File getAttachment(int mid) {
		String s1 = null;
		int messageid = mid;
		BufferedInputStream bis = null;
		FileOutputStream os = null;
		FileInputStream fis = null;
		File file = null;
		File file1 = null;
		String fname = null;
		ServletOutputStream sos = null;
		FileOutputStream out = null;
		String token = null;
		try {
			ps = getConnection()
					.prepareStatement(
							"select attachment,attachname,msg_to from inbox where msgno=?");
			ps.setInt(1, messageid);
			rs = ps.executeQuery();
			while (rs.next()) {
				rs.getBinaryStream(1);
				fname = rs.getString(2);
				System.out.println(fname);
				s1 = rs.getString(3);
				StringTokenizer st = new StringTokenizer(fname, "\\");
				System.out.println("in string tokenizer");
				while (st.hasMoreElements()) {
					token = st.nextToken();
				}
				System.out.println(token);
				file = new File("E:\\" + "token"
						+ ".des");
				out = new FileOutputStream(file);
				bis = new BufferedInputStream(rs.getBinaryStream(1));
				byte[] bt = new byte[14170];
				System.out.println(bt.length);
				System.out.println("folder created");
				int ln = 0;
				while ((ln = bis.read(bt, 0, bt.length)) != -1) {
					out.write(bt, 0, bt.length);
					file1 = new DecryptFileUtil().fileDecrypt(file, rs
							.getString(2), s1);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {

				if (bis != null) {
					bis.close();
				}
				if (out != null) {
					out.close();
				}
				if (os != null) {
					os.close();
				}
				if (fis != null) {
					fis.close();
				}
				if (bis != null) {
					bis.close();
				}
				if (sos != null) {
					sos.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return file1;

	}

	public List<LoginProfileBean> sentMails(String name) throws SQLException {
		List<LoginProfileBean> email = null;
		try {
			CryptMsgUtil decrypt = new CryptMsgUtil("passPhrase");
			ps = getConnection()
					.prepareStatement(
							"select  msgno,msg_from,msg_to,msg,date_time from inbox where msg_from=?");

			ps.setString(1, name);
			rs = ps.executeQuery();
			if (rs.next()) {
				email = new ArrayList<LoginProfileBean>();
				do {
					LoginProfileBean lp1 = new LoginProfileBean();
					lp1.setMsgno(rs.getInt(1));
					lp1.setFrom(rs.getString(2));
					lp1.setTo(rs.getString(3));
					String message = decrypt.decrypt(rs.getString(4));
					System.out.println(message);
					lp1.setMsg(message);
					lp1.setDate(rs.getString(5));

					email.add(lp1);
				} while (rs.next());

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally

		{
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

		return email;

	}
	
	
	public Vector view(int mid) throws  SQLException
	{
		
		boolean flag = true;
		//con = DBConnectionFactory.getConnection();
		Vector v=new Vector();
		
		
		

		
		ps = getConnection().prepareStatement("select attachname from inbox where msgno=?");
		
		System.out.println("------>>"+mid);
		ps.setInt(1,mid);
		rs=ps.executeQuery();
	  
		while(rs.next())
		{
			LoginProfileBean rto=new LoginProfileBean();
			
			rto.setFpath(rs.getString(1));
			
			
		  
			
		v.add(rto);	
		}
		
		return v;
	}
	
	
}
