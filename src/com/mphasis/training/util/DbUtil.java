package com.mphasis.training.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbUtil {

	private static String url="jdbc:oracle:thin://localhost:1521:orcl";
	private static String user="scott";
	private static String pass="tiger";
	
	public static Connection getConnection()
	{	
		Connection con=null;
		try
		{
			Class.forName("oracle.jdbc.OracleDriver");
			con=DriverManager.getConnection(url, user, pass);
		}
		catch(ClassNotFoundException|SQLException e)
		{
			System.out.println(e.getMessage());
		}
		return con;
	}
}
