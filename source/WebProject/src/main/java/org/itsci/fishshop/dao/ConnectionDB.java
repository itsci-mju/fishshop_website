package org.itsci.fishshop.dao;

import java.sql.*;

public class ConnectionDB {
	String url = "jdbc:mysql://localhost:3306/project_web?characterEncoding=UTF-8&&serverTimezone=UTC";
	String uname = "root";
	String pwd = "1234";

	Connection con;

	public ConnectionDB() {
		// TODO Auto-generated constructor stub
	}

	public Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url, uname, pwd);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}

	public static void main(String args[]) {
		ConnectionDB condb = new ConnectionDB();
		System.out.println(condb.getConnection());
	}
}
