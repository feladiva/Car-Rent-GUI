

import java.sql.*;

public class Database {

	private final String USERNAME = "root";
	private final String PASSWORD = "";
	private final String DATABASE = "latmakeup";
	private final String HOST = "localhost:3306";
	private final String CONNECTION = String.format("jdbc:mysql://%s/%s", HOST, DATABASE);
	
	public ResultSet rs;
	public ResultSetMetaData rsm;
	
	private Connection con;
	private Statement st;
	private static Database database;
	
	public static Database getInstance() {
		if(database == null) {
			return new Database();
		}
		return database;
	}
	
	private Database() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(CONNECTION, USERNAME, PASSWORD);
			st = con.createStatement();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public ResultSet execQuery(String query) {
		try {
			rs = st.executeQuery(query);
			rsm = rs.getMetaData();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	
	public void execUpdate(String query) {
		try {
			st.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public PreparedStatement prepareStatement(String query) {
		
			PreparedStatement ps = null;
			try {
				ps = con.prepareStatement(query);
			} catch (Exception e) {
				// TODO: handle exception
			}
			return ps;
	}
}
