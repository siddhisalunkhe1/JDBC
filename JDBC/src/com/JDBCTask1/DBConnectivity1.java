package com.JDBCTask1;

import java.sql.*;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.Statement;

public class DBConnectivity1
{
     public void createStudents()
    {
	   Student1 st1=new Student1();
	   String q="insert into student values(101, 'Sid', 'Pune');";
	   try
	   {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/student_db", "root", "Humanity@16");
		Statement stmt=con.createStatement();
		boolean b=stmt.execute(q);
		System.out.println(b);
		con.close();
	   } 
	   catch (Exception e)
	   {
		 System.out.println("exception occured");
	   }
    }
     
     
     public void readStudents()
     {
    	  String q="select * from student";
    	  
    	  try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/student_db", "root", "Humanity@16");
	    	  Statement stmt=con.createStatement();
	    	  
	    	  ResultSet set=stmt.executeQuery(q);
	    	  while(set.next()) 
	    	  {
	    		   Student1 st2=new Student1();
                    st2.setId(set.getInt("id"));
                    st2.setStdName(set.getString("name"));
                    st2.setStdCity(set.getString("city"));
                    
	    	  }
	    	  con.close();
		} catch (Exception e) {
			
			e.printStackTrace();  
		}
    	  
     }
     public static void main(String[] args)
     {
		 DBConnectivity1 d2=new DBConnectivity1();
		 d2.createStudents();
		 d2.readStudents();
	 }
}
