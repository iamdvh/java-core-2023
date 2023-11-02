package com.javacore.utils;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionUtils {
	public static final String URL = "mysql:jdbc://localhost:3306/javacore";
	public static final String USERNAME = "root";
	public static final String PASSWORD = "mavryk";
	public Connection getConnection() {
		Connection con;
		try {			
			con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			return con;
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}
}
