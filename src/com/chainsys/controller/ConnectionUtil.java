package com.chainsys.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnectionUtil {
public static Connection getConnection()
{
	Connection connection = null;
	try {
		// 1.load the class
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		// 2.get the connection
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		connection = DriverManager.getConnection(url, "hr", "hr");
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return connection;
}
public static void close(Connection conn ,PreparedStatement pstmt, ResultSet rs)
{
	try
	{
		if(rs != null)
		{
			rs.close();
		}
		if(pstmt != null)
		{
			pstmt.close();
		}
		if(conn != null)
		{
			conn.close();
		}
	}catch(SQLException e)
	{
}
}
}
