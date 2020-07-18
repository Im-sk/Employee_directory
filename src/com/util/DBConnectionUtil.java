package com.util;

//import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnectionUtil {
	
		private static final String URL = "jdbc:mysql://localhost:3306/employeedirectory";
		
		private static final String NAME = "root";
		
		private static final String PASSWORD = "Kumar.123";
		
		private static final String DRIVER = "com.mysql.jdbc.Driver";
		
		private static Connection connection = null;
		
		
		public static Connection openConnection(){
			
//			check the connection
			if(connection != null){
				return connection;
			}else{
				
//				Load the driver
				
				try {
					Class.forName(DRIVER);
					connection = DriverManager.getConnection(URL, NAME, PASSWORD);
				
				} catch (Exception e) {
					e.printStackTrace();
				}				
				return connection;
			}
			
		}
		
}
