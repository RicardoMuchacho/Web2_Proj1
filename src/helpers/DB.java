package helpers;

import java.sql.*;

public class DB {
	private static DB DB = new DB();
	private Statement stmt;
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private String driverDB = "org.postgresql.Driver";
	private String dbName = "Register";
	private String urlDB = "jdbc:postgresql://localhost:5433/" + this.dbName; 
	private String userDB = "postgres";
	private String passDB = "admin";
	public String result;
	
	private DB(){
		try {
		Class.forName(driverDB);
		this.conn = DriverManager.getConnection(urlDB, userDB, passDB);
		System.out.println("Conexion establecida");
		} catch (ClassNotFoundException | SQLException e) {
		e.printStackTrace();
		}
		} 
	public static DB getInstances() {
		return DB;
		} 
	
	public ResultSet dbStatement(String query) {
		try {
		this.stmt = this.conn.createStatement();
		this.rs = this.stmt.executeQuery(query);
		while(rs.next()) {
		System.out.println(rs.getString("userid"));
		System.out.println(rs.getString("name"));
		System.out.println(rs.getString("password"));
		System.out.println(rs.getString("age"));
		System.out.println(rs.getString("address"));
		System.out.println(rs.getString("verified"));
		System.out.print("\n");
		}
		} catch (SQLException e) {
		e.printStackTrace();
		}finally {
		try {
		this.stmt.close();
		this.rs.close();
		} catch (SQLException e) {
		e.printStackTrace();
		}
		}
		return rs;
	}
	
	public void dbPrepareStatement(String query, Object[] obj) {
		try {
		this.pstmt = this.conn.prepareStatement(query);
		this.pstmt.setString(1, (String) obj[0]);
		this.pstmt.setString(2, (String) obj[1]);
		this.pstmt.setInt(3, (int) obj[2]);
		this.pstmt.setString(4, (String) obj[3]);
		this.pstmt.setBoolean(5, (Boolean) obj[4]);
		this.pstmt.setString(6, (String) obj[5]);
		this.pstmt.executeUpdate();
		} catch (SQLException e) {
		e.printStackTrace();
		} finally {
		try {
		this.pstmt.close();
		} catch (SQLException e) {
		e.printStackTrace();
		}
		 }
		} 
	
	public void registerUser(String query, User user) {
		try {

		this.pstmt = this.conn.prepareStatement(query);
		this.pstmt.setString(1, user.getName());
		this.pstmt.setString(2, user.getPass() );
		this.pstmt.setInt(3, user.getAge() );
		this.pstmt.setString(4, user.getAddress());
		this.pstmt.setBoolean(5, user.getSubscribed());
		this.pstmt.setString(6, user.getEmail() );
		
		this.pstmt.executeUpdate();
		} catch (SQLException e) {
		e.printStackTrace();
		} finally {
		try {
		this.pstmt.close();
		} catch (SQLException e) {
		e.printStackTrace();
		}
		 }
		} 
	
	public void dbClose() {
		try {
		this.conn.close();
		System.out.println("Conexion cerrada");
		} catch (SQLException e) {
		e.printStackTrace();
		} 
	}
}