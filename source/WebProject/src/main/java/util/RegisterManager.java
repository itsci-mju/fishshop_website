package util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import bean.Register;

public class RegisterManager {

	
	public String AddRegister(Register pd,String MID) 
	 { 
	 try{ 
	 ConnectionDB dbcon = new ConnectionDB(); 
	 Connection conn = dbcon.getConnection(); 
	 Statement statment = conn.createStatement(); 
	 statment.execute("insert into Register values('" + 
			 MID+"','"+pd.getFirstName() + "','" +pd.getLastName()+"','"+pd.getPhoneNo()+"','" + pd.getEmail()+"','"+
			 pd.getPassword()+"','"+pd.getMemberType()+"')"); 
	 
	 conn.close(); 
	 return "Register Successfully..."; 
	 }catch(Exception e){ 
	 System.out.println(e); 
	 return "Something went wrong please try again!!!"; 
	 } 
	

} 
	 public int getMaxMemberID() {
			ConnectionDB condb = new ConnectionDB();
			Connection con = condb.getConnection();
			int id = 0;
			try {
				Statement stmt = con.createStatement();
				String sql = "SELECT Max(MemberID) from Register;";
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
	 
		public List<Register> getRegister(String memid){
			List<Register> list = new ArrayList<>();
			ConnectionDB condb = new ConnectionDB();
			Connection con = condb.getConnection();
			try {
				Statement stmt = con.createStatement();
				String sql = "select * from Register where MemberID = '"+ memid + "'";
				ResultSet rs = stmt.executeQuery(sql);
				while(rs.next()) {
					int MemberID = rs.getInt(1);    
					String FirstName = rs.getString(2);
					String LastName = rs.getString(3);
					String PhoneNo = rs.getString(4);
					String Email = rs.getString(5);
					String PassWord = rs.getString(6);
					String MemberType = rs.getString(7);
					Register s = new Register(MemberID,FirstName,LastName,PhoneNo,Email,PassWord,MemberType);
					list.add(s);
				}
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			return list;
		}
	 
		public int EditRegister(Register re){
			ConnectionDB condb = new ConnectionDB();
			Connection con = condb.getConnection();
			try {
				Statement stmt = con.createStatement();
				String sql = "update Register \r\n"
						+ "set FirstName = '"+re.getFirstName()+"',LastName ='"+re.getLastName()+"',PhoneNo ='"+re.getPhoneNo()+"',Email ='"+re.getEmail()+"',PassWord='"+re.getPassword()+"'\r\n"
						+ "where MemberID = '"+re.getMemberID()+"';";
				int result = stmt.executeUpdate(sql);
				con.close();
				return result;
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return -1;

}
}
