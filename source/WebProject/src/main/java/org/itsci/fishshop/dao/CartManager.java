package org.itsci.fishshop.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.itsci.fishshop.model.Cart;
import org.itsci.fishshop.model.Categories;
import org.itsci.fishshop.model.Product;

public class CartManager {
	
	public List<Cart> getCart(String ct){
		List<Cart> list = new ArrayList<>();
		ConnectionDB condb = new ConnectionDB();
		Connection con = condb.getConnection();
		try {
			Statement stmt = con.createStatement();
			String sql = "select * from cart where Cartid = '"+ ct + "'";
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				String Cartid = rs.getString(1); 
				String Username = rs.getString(2);
				String Productid = rs.getString(3);
				String Productname = rs.getString(4);
				String Quantity = rs.getString(5);
				String Price = rs.getString(6);
				
				Cart s = new Cart(Cartid,Username,Productid,Productname,Quantity,
						Price);
				list.add(s);
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
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
				String Amount = rs.getString(4);
				String Unit = rs.getString(5);
				String Price = rs.getString(6);
				String ctid = rs.getString(7);
				Categories ct = new Categories(ctid,"");
				Product s = new Product(ProductID,ProductPic,ProductName,Amount,Unit,Price,ct);
				list.add(s);
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}

	public int getMaxProductID() {
		ConnectionDB condb = new ConnectionDB();
		Connection con = condb.getConnection();
		int id = 0;
		try {
			Statement stmt = con.createStatement();
			String sql = "SELECT Max(Productid) from cart;";
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
	
	public int getMaxCartID() {
		ConnectionDB condb = new ConnectionDB();
		Connection con = condb.getConnection();
		int id = 0;
		try {
			Statement stmt = con.createStatement();
			String sql = "SELECT Max(Cartid) from cart;";
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
	
	public int updateqty(Cart ob){
		ConnectionDB condb = new ConnectionDB();
		Connection con = condb.getConnection();
		try {
			Statement stmt = con.createStatement();
			String sql = "update cart set Quantity = '"+ ob.getQuantity() + "' where ProductID = '"+ ob.getProductID() +"'";
			int result = stmt.executeUpdate(sql);
			con.close();
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return -1;
	}
	
	public int insertCart(Cart ob){
		ConnectionDB condb = new ConnectionDB();
		Connection con = condb.getConnection();
		try {
			Statement stmt = con.createStatement();
			String sql = "insert into cart value("
					+ ob.getCartID()+", " + ob.getUserName() + ", '"  +
					ob.getProductID() + "' , '" + ob.getProductName() + "' , '" + ob.getQuantity() + "' , " 
					+ ob.getPrice() +" )";
			int result = stmt.executeUpdate(sql);
			con.close();
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return -1;
	}
	public CartManager() {
		// TODO Auto-generated constructor stub
	}

}
