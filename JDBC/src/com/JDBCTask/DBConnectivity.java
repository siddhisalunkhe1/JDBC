package com.JDBCTask;

import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

public class DBConnectivity
{
	
	public void createStudents()
	{
		 String q="insert into student values(100, 'Shivraj', 'Thanekar');";
		   try {
			    
		    Connection con=ConnectionProvider.getConnection();
			Statement stmt=con.createStatement();
			boolean b=stmt.execute(q);
			System.out.println("a "+stmt.execute(q));
			System.out.println(b); 
			System.out.println("b "+stmt.getResultSet());
			System.out.println(stmt.getUpdateCount());
			con.close();	
		} 
		  catch (Exception e) {
			System.out.println(e);
		}
	}
	
	
	public void readStudents()
	{
		
		 String q="select * from student where id=16";
		   try {  
			   
			Connection con=ConnectionProvider.getConnection();
			Statement stmt=con.createStatement();
			
			ResultSet set=stmt.executeQuery(q);
			System.out.println(set.next());
//			std1.setId(set.getInt("id"));
//			
//			std1.setName(set.getString("name"));
//			std1.setAddress(set.getString("address"));
//			System.out.println(set); 
			while(set.next())
			{
				Student std1=new Student();
				std1.setId(set.getInt("id"));
				std1.setName(set.getString("name"));
				std1.setAddress(set.getString("address"));
				System.out.println(std1);
			}
			con.close();
			
		}  
		  catch (Exception e) { 
			System.out.println(e);    
		}
	}
	
	public void getAllStudents()
	{
		ArrayList<Student> al=new ArrayList();
		 String q="select * from student";
		   try {
			   
			Connection con=ConnectionProvider.getConnection();
			Statement stmt=con.createStatement();
			
			ResultSet set=stmt.executeQuery(q);
			while(set.next())
			{
				Student std1=new Student();

				std1.setId(set.getInt("id"));
				std1.setName(set.getString("name"));
				std1.setAddress(set.getString("address"));
//				System.out.println(std1);
				al.add(std1);
				
			}
//			System.out.println(al);
			for(Student o:al)
			{
				System.out.println(o);
			}
		   }
			catch(Exception e)
			{  
				
			}
	}
	
	public void deleteStudents()
	{
		String q="delete from student where id=15"; 
		String url="jdbc:mysql://localhost:3306/agce_db";
		String username="root";
		String password="Humanity@16";
		String driver="com.mysql.cj.jdbc.Driver";
		
		try {
			Connection con=ConnectionProvider.getConnection();
			Statement stmt=con.createStatement();
			
			int b=stmt.executeUpdate(q);
			System.out.println(b);
			con.close();
		} catch (Exception e) {
			System.out.println();
		}
	}
	
	
	public void updateStudents()
	{
		String q="update student set address='Thane' where id=15"; 
		String url="jdbc:mysql://localhost:3306/agce_db";
		String username="root";
		String password="Humanity@16";
		String driver="com.mysql.cj.jdbc.Driver";
		
		 
		try {
			Connection con=ConnectionProvider.getConnection();
			Statement stmt=con.createStatement();
			int i=stmt.executeUpdate(q);
			if(i>0)
			{
				System.out.println("record updated");
			}
			 con.close();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		 
	}
   public static void main(String[] args)  
   {
	   DBConnectivity d1=new DBConnectivity();
	   d1.createStudents();
	   System.out.println("============================================================");
	   d1.readStudents();
	   System.out.println("============================================================");
	   d1.getAllStudents();
	   System.out.println("============================================================");
	   d1.deleteStudents();
	   System.out.println("============================================================");
	   d1.updateStudents();
	   System.out.println("============================================================");
   }
}
