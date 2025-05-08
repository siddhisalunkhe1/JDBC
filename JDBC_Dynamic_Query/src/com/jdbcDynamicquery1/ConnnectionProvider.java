package com.jdbcDynamicquery1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnnectionProvider
{  
    static Connection con;
    public static Connection getConnection()
    {
    	try
    	{
			Class.forName("com.mysql.cj.jdbc.Driver");
		    con=DriverManager.getConnection("jdbc:mysql://localhost:3306/rga_db", "root", "Humanity@16");
			
			
		}
    	catch (Exception e)
    	{
			e.printStackTrace();
		}
    	return con;
    }
}
