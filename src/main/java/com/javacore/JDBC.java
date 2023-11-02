package com.javacore;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC {
	public static final String DB_URL = "jdbc:mysql://localhost:3306/javacore";
	public static final String USER="root";
	public static final String PASSWORD="mavryk";
	public static final String QUERY  = "select * from buildings";
	public static void main(String[] args) {
		Connection con = null;
		Statement stmt= null;
		ResultSet rs= null;
		//search
		StringBuilder query = new StringBuilder("select * from buildings where 1=1");
		String name = null;
		Integer floorArea = null;
		String street = null;
		String district = null;
		String ward = "Quận số 1";
		// Condition
	if(name != null && name != "") {
		query.append(" and name like'%"+name+"%'");
	}
	if(floorArea != null) {
		query.append(" and floorArea like'%"+floorArea+"%'");
	}
	if(street != null && street != "") {
		query.append(" and street like'%"+street+"%'");
	}
	if(district != null && district != "") {
		query.append(" and district like'%"+district+"%'");
	}
	if(ward != null && ward != "") {
		query.append(" and ward like'%"+ward+"%'");
	}

		try {			
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(DB_URL, USER, PASSWORD);
			stmt = con.createStatement();
			rs = stmt.executeQuery(query.toString());
			while(rs.next()) {
				System.out.println("Name: " + rs.getString("name"));
				System.out.println("FloorArea: " + rs.getString("floorArea"));
				System.out.println("Stress: " + rs.getString("street"));
				System.out.println("District: " + rs.getString("district"));
				System.out.println("Ward: " + rs.getString("ward"));
				System.out.println("-----------------------------------------");
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		} finally {
			if(con != null) {	
				try {					
					con.close();
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}
			}
			if(stmt != null) {	
				try {					
					stmt.close();
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}
			}
			if(rs != null) {
				try {					
					rs.close();
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}
			}
		}	
	}
}

