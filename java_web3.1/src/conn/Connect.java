package conn;

import java.sql.*;

public class Connect {

	private	Connection con=null;
	public Connect() {
		try { 
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			con = DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433;databaseName=yangqimin;user=yqm;password=123456");
		}catch (SQLException e1) {
			e1.printStackTrace();
		}
	}
	public Connection getCon(){
		return con;
	}

}
