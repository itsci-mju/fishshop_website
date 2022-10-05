package org.itsci.fishshop.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.itsci.fishshop.model.Categories;
import org.itsci.fishshop.model.Product;

public class ProductManager {

	public ProductManager() {
		// TODO Auto-generated constructor stub
	}
	public String AddProduct(Product pd,String ProductID) 
	 { 
	 try{ 
	 ConnectionDB dbcon = new ConnectionDB(); 
	 Connection conn = dbcon.getConnection(); 
	 Statement statment = conn.createStatement(); 
	 statment.execute("insert into product values('" + 
			 ProductID+"','"+pd.getProductPic() + "','" +pd.getProductName()+"','"+pd.getAmount()+"','" + pd.getUnit()+"','"+
			 pd.getPrice()+"','"+pd.getCategories().getCategoriesID()+"')"); 
	 
	 conn.close(); 
	 return "AddProduct Successfully..."; 
	 }catch(Exception e){ 
	 System.out.println(e); 
	 return "Something went wrong please try again!!!"; 
	 } 
	

} 
	 public int getMaxProductID() {
			ConnectionDB condb = new ConnectionDB();
			Connection con = condb.getConnection();
			int id = 0;
			try {
				Statement stmt = con.createStatement();
				String sql = "SELECT Max(ProductID)from Product";
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
	 
		public List<Product> getProduct(String proid){
			List<Product> list = new ArrayList<>();
			ConnectionDB condb = new ConnectionDB();
			Connection con = condb.getConnection();
			try {
				Statement stmt = con.createStatement();
				String sql = "select * from product where ProductID = '"+ proid + "'";
				ResultSet rs = stmt.executeQuery(sql);
				while(rs.next()) {
					int ProductID = rs.getInt(1);    
					String ProductPic = rs.getString(2);
					String ProductName = rs.getString(3);
					String amount = rs.getString(4);
					String unit = rs.getString(5);
					String price = rs.getString(6);
					String ctid = rs.getString(7);
					Categories ct = new Categories(ctid,"");
					Product s = new Product(ProductID,ProductPic,ProductName,amount,unit,price,ct);
					list.add(s);
				}
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			return list;
		}
	 
	 
		public List<Product> searchProduct(String proid) {
			List<Product> list = new ArrayList<>();
			ConnectionDB condb = new ConnectionDB();
			Connection con = condb.getConnection();

			try {
				Statement stmt = con.createStatement();
				String sql = "select * from Product where ProductName like '%" + proid + "%' order by ProductID";
				ResultSet rs = stmt.executeQuery(sql);
				while (rs.next()) {
					int ProductID = rs.getInt(1);    
					String ProductPic = rs.getString(2);
					String ProductName = rs.getString(3);
					String Amount = rs.getString(4);
					String Unit = rs.getString(5);
					String Price = rs.getString(6);
					String ctid = rs.getString(7);
					Categories ct = new Categories(ctid,"");
					Product s = new Product(ProductID,ProductPic,ProductName, Amount,Unit,Price,ct);
					list.add(s);
				}
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

			return list;
		}
		
		public int EditProduct(String proid,String ProductPic,String ProductName,String amount,String unit,String price){
			ConnectionDB condb = new ConnectionDB();
			Connection con = condb.getConnection();
			try {
				Statement stmt = con.createStatement();
				String sql = "update Product \r\n"
						+ "set ProductName = '"+ProductName+"',amount ='"+amount+"',unit ='"+unit+"',price ='"+price+"'\r\n"
						+ "where ProductID = '"+proid+"';";
				int result = stmt.executeUpdate(sql);
				con.close();
				return result;
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return -1;
		}
		public int deleteProduct(String proid) {
	        ConnectionDB condb = new ConnectionDB();
	        Connection con = condb.getConnection();

	        try {                     
	            Statement stmt = con.createStatement();
	            String sql = "delete from product where ProductID = '" + proid + "'";
	            int result = stmt.executeUpdate(sql);
	            con.close();
	            return result;
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

	        return -1;
	    }
		
		 
			public List<Product> getAllproduct(){
				List<Product> list = new ArrayList<>();
				ConnectionDB condb = new ConnectionDB();
				Connection con = condb.getConnection();
				try {
					Statement stmt = con.createStatement();
					String sql = "select * from Product order by ProductID";
					
					ResultSet rs = stmt.executeQuery(sql); 
					while (rs.next()) {
						int ProductID = rs.getInt(1);    
						String ProductPic = rs.getString(2);
						String ProductName = rs.getString(3);
						String Amount = rs.getString(4);
						String Unit = rs.getString(5);
						String Price = rs.getString(6);
						String ctid = rs.getString(7);
						Categories ct = new Categories(ctid,"");
						Product s = new Product(ProductID,ProductPic,ProductName, Amount,Unit,Price,ct);
						list.add(s);
					}
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
				return list;
			}
			
			public List<Product> ProductDetail(String proid) {
				List<Product> list = new ArrayList<>();
				ConnectionDB condb = new ConnectionDB();
				Connection con = condb.getConnection();
				try {
					Statement stmt = con.createStatement();
					String sql = "select * from product where ProductID = '"+ proid + "'";
					
					ResultSet rs = stmt.executeQuery(sql); 
					while (rs.next()) {
						int ProductID = rs.getInt(1);    
						String ProductPic = rs.getString(2);
						String ProductName = rs.getString(3);
						String Amount = rs.getString(4);
						String Unit = rs.getString(5);
						String Price = rs.getString(6);
						String ctid = rs.getString(7);
						Categories ct = new Categories(ctid,"");
						Product s = new Product(ProductID,ProductPic,ProductName, Amount,Unit,Price,ct);
						list.add(s);
					}
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
				return list;
			}
			
}

