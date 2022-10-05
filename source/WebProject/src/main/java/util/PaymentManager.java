package util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import bean.Payment;
import bean.Product;

public class PaymentManager {

	public List<Payment> getAllPayment(){
		List<Payment> list = new ArrayList<>();
		ConnectionDB condb = new ConnectionDB();
		Connection con = condb.getConnection();
		try {
			Statement stmt = con.createStatement();
			String sql = "Select * from Payment order by PaymentID";
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				int PaymentID = rs.getInt(1);   
				String PaymentPic = rs.getString(2);
				String TimesPayment = rs.getString(3);
				String PaymentName = rs.getString(4);
				Payment s = new Payment(PaymentID,PaymentPic,TimesPayment,PaymentName);
				list.add(s);
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}
	public String AddPayment(Payment pm,String PaymentID) 
	 { 
	 try{ 
	 ConnectionDB dbcon = new ConnectionDB(); 
	 Connection conn = dbcon.getConnection(); 
	 Statement statment = conn.createStatement(); 
	 statment.execute("insert into product values('" + 
			 PaymentID+"','"+pm.getPaymentID() + "','" +pm.getPaymentPic()+"','"+pm.getTimesPayment()+"','" + pm.getPaymentName()+"','"+
			 "')"); 
	 
	 conn.close(); 
	 return "AddPayment Successfully..."; 
	 }catch(Exception e){ 
	 System.out.println(e); 
	 return "Something went wrong please try again!!!"; 
	 } 
	

} 
	
	public List<Payment> getPayment(String MemberID){
		List<Payment> list = new ArrayList<>();
		ConnectionDB condb = new ConnectionDB();
		Connection con = condb.getConnection();
		try {
			Statement stmt = con.createStatement();
			String sql = "select * from payment where PaymentID = '"+ MemberID + "'";
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				int PaymentID = rs.getInt(1);   
				String PaymentPic = rs.getString(2);
				String TimesPayment = rs.getString(3);
				String PaymentName = rs.getString(4);
				Payment s = new Payment(PaymentID,PaymentPic,TimesPayment,PaymentName);
				list.add(s);
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	
	public int getMaxPaymentID() {
		ConnectionDB condb = new ConnectionDB();
		Connection con = condb.getConnection();
		int id = 0;
		try {
			Statement stmt = con.createStatement();
			String sql = "SELECT Max(PaymentID) from Payment;";
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
	public PaymentManager() {
		// TODO Auto-generated constructor stub
	}

}
