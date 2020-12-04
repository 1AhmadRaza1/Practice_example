package com.demoproject.dbconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

	Connection con=null;
	//create connection
	public Connection getConnection()
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/demoproject", "Ahmad", "@ahm@ad");
		}catch (Exception e) {
			System.out.println(e);
		}
		return con;
	}
	
	// close connection
	public void closeConnection()
	{
		try {
			if(con!=null) {
				con.close();
			}
		}catch (SQLException e) {
			System.out.println(e);
		}
	}
}
