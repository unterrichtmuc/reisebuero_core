package de.cmt.reisebuero.core;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbHelper {

	public static Connection get() {
		try {
			Class.forName("com.mysql.jdbc.Driver");		

			return DriverManager.getConnection("jdbc:mysql://127.0.0.1/reisebuero", "root", "");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			
			System.exit(1);
		} 
		
		return null;
	}
	
}
