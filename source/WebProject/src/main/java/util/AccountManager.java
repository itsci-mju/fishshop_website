package util;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import bean.Register;
public class AccountManager {
	public int AccountRegister(Register mem){
		ConnectionDB condb = new ConnectionDB();
		Connection con = condb.getConnection();
		try {
			Statement stmt = con.createStatement();
			String sql = "select * from register where FristName LastName Password Phoneno Email = '"+ mem + "'";
			int result = stmt.executeUpdate(sql);
			con.close();
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return -1;
	}
}
