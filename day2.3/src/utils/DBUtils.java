package utils;

import java.sql.*;

public class DBUtils {
	// add a static method to ret DB conn
	public static Connection fetchConnection() throws ClassNotFoundException, SQLException {
		String url = "jdbc:mysql://localhost:3306/test_acts";
		// mandatory in  Java EE
		Class.forName("com.mysql.cj.jdbc.Driver");
		return DriverManager.getConnection(url, "root", "root");
	}
}
