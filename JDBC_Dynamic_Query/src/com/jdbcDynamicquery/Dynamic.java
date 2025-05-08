package com.jdbcDynamicquery;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Dynamic
{
	    Scanner sc=new Scanner(System.in);
	     
	  public void createEmpTable() 
	 { 
		     
		try {
			 Statement stmt=ConnectionProvider.getConnection().createStatement();
			 stmt.executeUpdate("create table employee(id int(20), name varchar(30), salary int(20), city varchar(30))");
			 System.out.println("table created successfully");
			  
		} 
		catch (Exception e1)
		{
			e1.printStackTrace();
		}
	 }
      public void createEmployee()
      {
    	  System.out.println("enter id , name , salary and city respectively.");
		  Employee e=new Employee(sc.nextInt(), sc.next(), sc.nextInt(), sc.next());
		  try
		  {
				 Connection con=ConnectionProvider.getConnection();
				 String q="insert into employee values(?, ?, ?, ?)";
				 PreparedStatement pstmt=con.prepareStatement(q);
				 
				 pstmt.setInt(1, e.getId());  
				 pstmt.setString(2, e.getName()); 
				 pstmt.setInt(3, e.getSalary());  
				 pstmt.setString(4, e.getCity());  
				 pstmt.execute(); 
				 System.out.println("Created employees");
				 con.close();
			
		  }
		  catch(Exception e1)
		  {
			  System.out.println(e1);
		  }
		
      }
      
      public void readEmployee()
      {
    	  String q="select * from employee where id=?";
    	  System.out.println("Enter Id: ");
    	  int id=sc.nextInt();
    	  Connection con=ConnectionProvider.getConnection();
    	  try
    	  {
			 PreparedStatement pstmt=con.prepareStatement(q);
			 pstmt.setInt(1, id);
			 
			 ResultSet rs=pstmt.executeQuery();
			 while(rs.next())
			 {
				 Employee e=new Employee();
				 e.setId(rs.getInt(1));
				 e.setName(rs.getString(2));
				 e.setSalary(rs.getInt(3));
				 e.setCity(rs.getString(4));
				 System.out.println(e);
				 
			 }
			 con.close();
		  }
    	  catch (Exception e1)
    	  {
			
			e1.printStackTrace();
		  }
    	  
      }
      
      
      public void updateEmployee()
      {
    	  String q="update employee set city=? where id=?";
    	  Connection con=ConnectionProvider.getConnection();
    	  System.out.println("enter id and city ");
    	  int id=sc.nextInt();
    	  String city=sc.next();
    	  try
    	 {
			PreparedStatement pstmt=con.prepareStatement(q);
			pstmt.setInt(2, id);
			pstmt.setString(1, city);
			pstmt.executeUpdate();
			System.out.println("record updated");
		 }    
    	  catch (Exception e)
    	  {
    		  e.printStackTrace();
		  }
    	  
    	  
      }
      
      public void deleteEmployee()
      {
    	  String q="delete from employee where id=?";
    	  Connection con=ConnectionProvider.getConnection();
    	  try {
			PreparedStatement pstmt=con.prepareStatement(q);
			 pstmt.setInt(1, 11);
			 pstmt.executeUpdate();
			 System.out.println("deleted particular row");
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	  
      }
      
           
}
