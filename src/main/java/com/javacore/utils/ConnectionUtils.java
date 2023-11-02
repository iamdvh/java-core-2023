package com.javacore.utils;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionUtils {
	public static Connection getConnection() {
		String url = "mysql:jdbc://localhost:3306/javacore";
		String userName = "root";
		String password = "mavryk";
		Connection con;
		try {			
			con = DriverManager.getConnection(url, userName, password);
			return con;
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}
}
