package jdbcProgram;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class StudentDAO 
{
      public static void createStudent()
      {
    	  String sql="Insert into studentdetails values(2, 'Riddhi', '67930500') ";
    	  
    	  try {
    		   Connection con=ConnectionProvider.getConnection();
    		    Statement stmt =  con.createStatement();
    		    boolean b  = stmt.execute(sql);
    		    System.out.println("a "+stmt.execute(sql));
    			System.out.println(b); 
    			System.out.println("b "+stmt.getResultSet());
    			System.out.println(stmt.getUpdateCount());
    			con.close();	
    	  }
    	  catch(Exception e)
    	  {
    		  System.out.println(e);
    	  }
      }
      
      public static void readStudent()
      {
    	  String sql="Select * from studentdetails";
    	  Connection con = ConnectionProvider.getConnection();
    	  try
    	  {
			 Statement stmt = con.createStatement();
			 ResultSet rs = stmt.executeQuery(sql);
			 System.out.println(rs.next());
			 
			 while(rs.next())
			 {
				 Student s1=new Student();
				 s1.setId(rs.getInt("id"));
				 s1.setName(rs.getString("name"));
				 s1.setPhone(rs.getString("phone"));
				 System.out.println(s1);
			 }
			 con.close();
			 
		  } catch (SQLException e)
    	  {
			  e.printStackTrace();
		  }
    	  
      }
}
