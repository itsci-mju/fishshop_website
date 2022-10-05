package org.itsci.fishshop.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.itsci.fishshop.model.Address;
import org.itsci.fishshop.model.Register;

public class AddressManager {

	public String insertAddreess(Address ad) 
	 { 
	 try{ 
	 ConnectionDB dbcon = new ConnectionDB(); 
	 Connection conn = dbcon.getConnection(); 
	 Statement statment = conn.createStatement(); 
	 statment.execute("insert into Address values('" + 
			 ad.getAddressID()+"','"+ad.getTrackNo()+"','"+ad.getStreet() + "','" +ad.getSubDistrict()+"','"+ad.getDistrict()+"','" + ad.getProvince()+"','"+
			 ad.getZipCode()+"','"+ad.getTelNo()+"','"+ad.getRegister().getMemberID()+"');"); 
	 
	 conn.close(); 
	 return "Address Successfully..."; 
	 }catch(Exception e){ 
	 System.out.println(e); 
	 return "Something went wrong please try again!!!"; 
	 } 
	

} 
	 public int getMaxAddressID() {
			ConnectionDB condb = new ConnectionDB();
			Connection con = condb.getConnection();
			int id = 0;
			try {
				Statement stmt = con.createStatement();
				String sql = "SELECT Max(AddressID)from Address;";
				ResultSet rs = stmt.executeQuery(sql);

				while (rs.next()) {
					id = rs.getInt(1);
				}
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return id + 1;
		}
		public Register Register(String email) {
			Register r = null;
			ConnectionDB condb = new ConnectionDB();
			Connection con = condb.getConnection();
			try {
				Statement stmt = con.createStatement();
				String sql = "SELECT * FROM register where Email = '"+ email + "'";
				
				ResultSet rs = stmt.executeQuery(sql); 
				while (rs.next()) {
					int MemberID = rs.getInt(1);    
					String FirstName = rs.getString(2);
					String LastName = rs.getString(3);
					String PhoneNo = rs.getString(4);
					String Email = rs.getString(5);
					String PassWord = rs.getString(6);
					String MemberType = rs.getString(7);
					r = new Register(MemberID,FirstName,LastName,PhoneNo,Email,PassWord,MemberType);
				}
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			return r;
		}
}
