package pharma.database;

import java.sql.*;

public class DataConnection {
	private final String URL = "jdbc:mysql://localhost:3306/hlpharma?useUnicode=true&characterEncoding=UTF-8";
	private final String USERNAME = "root";
	private final String PASSWORD = "";
	Connection conn = null;
	Statement stmt = null;
	String sql = null;
	ResultSet rs = null;

	public DataConnection() {
		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);

		} catch (SQLException e) {
			// e.printStackTrace();
			System.out.println("SQLException: " + e.getMessage());
			System.out.println("SQLState: " + e.getSQLState());
			System.out.println("VendorError: " + e.getErrorCode());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("ClassNotFoundException Error! from DataConnection.java");
		} catch (Exception ex) {
			System.out.println("Exception Error! from DataConnection.java");
		}
	}

	public void setQuery(String sql) {
		this.sql = sql;
	}
	
	public void doQuery() {
		try {
			stmt = conn.createStatement();
			stmt.executeUpdate(sql);
			stmt.close();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
	}

	public int countRow() {
		int count = 0;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			rs.last();
			return count = rs.getRow();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Query Fail! from countRow()");
			return count;
		}
	}

	public ResultSet getAllRow() {
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			return rs;
		} catch (Exception e) {
			// TODO: handle exception
			return rs;
		}
	}

//	public static void main(String[] args) throws SQLException {
//		DataConnection c = new DataConnection();
//		c.setQuery("select * from user");
//		c.getAllRow();
//		while (c.rs.next()) {
//			System.out.println(c.rs.getString("username") + " : " + c.rs.getString("password"));
//		}
//
//	}

}
