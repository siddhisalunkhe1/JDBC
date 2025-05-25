package jdbcProgram;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionProvider 
{
      static Connection con;
	public static Connection getConnection()
	{
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_db", "root", "Humanity@16");
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return con;
	}
     
}
