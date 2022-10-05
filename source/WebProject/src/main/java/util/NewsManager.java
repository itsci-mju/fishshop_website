package util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import bean.Categories;
import bean.News;
import bean.Product;
import bean.Register;


public class NewsManager {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public String AddNews(News pd,String NewsID) { 
	 try{ 
	 ConnectionDB dbcon = new ConnectionDB(); 
	 Connection conn = dbcon.getConnection(); 
	 Statement statment = conn.createStatement(); 
	 statment.execute("insert into news values('" + 
			NewsID+"','"+pd.getNewsPic()+"','"+pd.getNewsName()+"','"+pd.getNewsDetail()+
			"','"+pd.getRegister().getMemberID()+"')");
			
	 
	 conn.close(); 
	 return "AddNews Successfully..."; 
	 }catch(Exception e){ 
	 System.out.println(e); 
	 return "Something went wrong please try again!!!"; 
	 } 
	 
	 }
	
	 public int getMaxNewsID() {
			ConnectionDB condb = new ConnectionDB();
			Connection con = condb.getConnection();
			int id = 0;
			try {
				Statement stmt = con.createStatement();
				String sql = "SELECT Max(NewsID) from News;";
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
	 
	
	 public int EditNews(String nid,String NewsPic, String NewsName,String NewsDetail){
			ConnectionDB condb = new ConnectionDB();
			Connection con = condb.getConnection();
			try {
				Statement stmt = con.createStatement();
				String sql = "update News \r\n"
						+ "set NewsPic = '"+NewsPic+"',NewsName = '"+NewsName+"',NewsDetail = '"+NewsDetail+"'\r\n"
						+ "where NewsID = '"+nid+"';";
				int result = stmt.executeUpdate(sql);
				con.close(); 
				return result;
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return -1;
		}
		public int deleteNews(String nid) {
	        ConnectionDB condb = new ConnectionDB();
	        Connection con = condb.getConnection();

	        try {                     
	            Statement stmt = con.createStatement();
	            String sql = "delete from News where NewsID = '" + nid + "'";
	            int result = stmt.executeUpdate(sql);
	            con.close();
	            return result;
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

	        return -1;
	    }
		public List<News> searchNews(String nid) {
			List<News> list = new ArrayList<>();
			ConnectionDB condb = new ConnectionDB();
			Connection con = condb.getConnection();

			try {
				Statement stmt = con.createStatement();
				String sql = "select * from News where NewsName like '%" + nid + "%' order by NewsID";
				ResultSet rs = stmt.executeQuery(sql);
				while (rs.next()) {
					int NewsID = rs.getInt(1);
					String NewsPic = rs.getString(2);
					String NewsName = rs.getString(3);
					String NewsDetail = rs.getString(4);
					String mid =rs.getString(5);
					Register re = new Register(NewsID, "","", mid, "", "", "");
					News n = new News(NewsID,NewsPic,NewsName,NewsDetail,re);
					list.add(n);
				}
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

			return list;
		}
		public List<News> getNews(String nid){
			List<News> list = new ArrayList<>();
			ConnectionDB condb = new ConnectionDB();
			Connection con = condb.getConnection();
			try {
				Statement stmt = con.createStatement();
				String sql = "select * from News where NewsID = '"+ nid + "'";
				ResultSet rs = stmt.executeQuery(sql);
				while(rs.next()) {
					int NewsID = rs.getInt(1);    
					String NewsPic = rs.getString(2);
					String NewsName = rs.getString(3);
					String NewsDetail = rs.getString(4);           
					String mid =rs.getString(5);
					Register re = new Register(NewsID, mid,"", mid, mid, mid, mid);
					News n = new News(NewsID,NewsPic,NewsName,NewsDetail,re);
					list.add(n);
				}
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			return list;
		}
		public List<News> getAllNews(){
			List<News> list = new ArrayList<>();
			ConnectionDB condb = new ConnectionDB();
			Connection con = condb.getConnection();
			try {
				Statement stmt = con.createStatement();
				String sql = "select * from News order by NewsID";
				
				ResultSet rs = stmt.executeQuery(sql); 
				while (rs.next()) {
					int NewsID = rs.getInt(1);    
					String NewsPic = rs.getString(2);
					String NewsName = rs.getString(3);
					String NewsDetail = rs.getString(4);           
					String mid =rs.getString(5);
					Register re = new Register(NewsID, mid,"", mid, mid, mid, mid);
					News n = new News(NewsID,NewsPic,NewsName,NewsDetail,re);
					list.add(n);
				}
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			return list;
		}

} 


