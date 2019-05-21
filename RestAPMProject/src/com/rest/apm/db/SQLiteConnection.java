package com.rest.apm.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SQLiteConnection {
	
	private Connection connect() throws ClassNotFoundException {
		Class.forName("org.sqlite.JDBC");
		String url = "jdbc:sqlite:/home/courier/study/workspace/sqlite3/courier-database.db";
		Connection connection = null;
		
		try
		{
			connection = DriverManager.getConnection(url);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
		return connection;
	}
	
	public ResultSet queryDB(String sql) {
		ResultSet rs = null; 
		
		try
		{
			Connection connect = connect();
			Statement stmt = connect.createStatement();
			rs = stmt.executeQuery(sql);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
		return rs;
	}
}