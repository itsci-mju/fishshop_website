package util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import bean.Register;

public class LoginManager {

	public LoginManager() {
		// TODO Auto-generated constructor stub
	}

	public Register verifyLogin(Register lb){
		Register s = null;
		ConnectionDB condb = new ConnectionDB();
		Connection con = condb.getConnection();
		try {
			Statement stmt = con.createStatement();
			String sql = "select * from register where Email = '" + lb.getEmail() +
					"' and Password = '"+lb.getPassword()+"'";
			ResultSet rs = stmt.executeQuery(sql); 
			while (rs.next() && rs.getRow()==1) {
				int MemberID = rs.getInt(1);
				String FirstName = rs.getString(2);
				String LastName = rs.getString(3);
				String Phoneno = rs.getString(4);
				String Email = rs.getString(5);
				String Password = rs.getString(6);
				String MemberType = rs.getString(7);
				
				
				 s = new Register(MemberID,FirstName,LastName,Phoneno,Email,Password,MemberType);
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return s;
	}
	
	public List<Register> getLogins(String regis){
		List<Register> list = new ArrayList<>();
		ConnectionDB condb = new ConnectionDB();
		Connection con = condb.getConnection();
		try {
			Statement stmt = con.createStatement();
			String sql = "select * from register where MemberID = '"+ regis + "'";
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				int MemberID = rs.getInt(1);
				String FirstName = rs.getString(2);
				String LastName = rs.getString(3);
				String Phoneno = rs.getString(4);
				String Email = rs.getString(5);
				String Password = rs.getString(6);
				String MemberType = rs.getString(7);
				Register s = new Register(MemberID,FirstName,LastName,Phoneno,Email,Password,MemberType);
				list.add(s);
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	
	
	/*public Admin verifyLogin2(Admin ad){
		Admin s = null;
		ConnectionDB condb = new ConnectionDB();
		Connection con = condb.getConnection();
		try {
			Statement stmt = con.createStatement();
			String sql = "select * from adminn where username = '" + ad.getUsername() +
					"' and password = '"+ad.getPassword()+"'";
			ResultSet rs = stmt.executeQuery(sql); 
			while (rs.next() && rs.getRow()==1) {
				String Username = rs.getString(1);
				String Password = rs.getString(2);
				String Fullname = rs.getString(3);
				String Phoneno = rs.getString(4);
				 s = new Admin(Username,Password,Fullname,Phoneno);
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return s;
	}
	
	/*public List<Admin> getLogins2(Admin admin){
		List<Admin> list = new ArrayList<>();
		ConnectionDB condb = new ConnectionDB();
		Connection con = condb.getConnection();
		try {
			Statement stmt = con.createStatement();
			String sql = "select * from admin where username = '"+ admin + "'";
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				String Username = rs.getString(1);
				String Password = rs.getString(2);
				String Fullname = rs.getString(3);
				String Phoneno = rs.getString(4);
				Admin s = new Admin(Username,Password,Fullname,Phoneno);
				list.add(s);
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}*/
}


