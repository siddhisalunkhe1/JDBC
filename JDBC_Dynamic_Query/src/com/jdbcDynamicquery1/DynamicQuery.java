package com.jdbcDynamicquery1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import com.jdbcDynamicquery.ConnectionProvider;
import com.jdbcDynamicquery.Employee;
import com.mysql.cj.protocol.Resultset;


public class DynamicQuery
{
      Scanner sc=new Scanner(System.in);
	  
	public void createStdTable()
	{
//		String q="create table students(id int(20), name varchar(30), addr varchar(30))";
		try
		{
		Statement stmt=ConnectionProvider.getConnection().createStatement();
		stmt.executeUpdate("create table studentlist(id int(20), name varchar(30), address varchar(30))");
		System.out.println("table created successfully");
		}
		catch(Exception e1)
		{
			System.out.println(e1);
		}
	}
	
	public void createStudents()
	{
		System.out.println("Enter the Id, Name and Address Respectively.");
		Students std=new Students(sc.nextInt(), sc.next(), sc.next());
		
		try
		{
		String q="insert into studentlist (id, name, addr) values (?, ?, ?)";
		Connection con=ConnectionProvider.getConnection();
		PreparedStatement pstmt=con.prepareStatement(q);
		
		pstmt.setInt(1, std.getId());
		pstmt.setString(2, std.getName());
		pstmt.setString(3, std.getAddr());
		pstmt.execute();
		System.out.println("data inserted");
		con.close();
		}
		
		catch(Exception e1)
		{
			System.out.println(e1);
		}
		
	}
	
	public void readStudents()
	{
		String q="select * from studentlist where id=?";
		System.out.println("Enter your Id");
		int id=sc.nextInt();
		Connection con=ConnectionProvider.getConnection();

		try
		{
		PreparedStatement pstmt=con.prepareStatement(q);
		pstmt.setInt(1, id);
		
		ResultSet rs=pstmt.executeQuery();
		 while(rs.next())
		 {
			 Students st=new Students();
			 st.setId(rs.getInt(1));
			 st.setName(rs.getString(2));
			 st.setAddr(rs.getString(3));
			 System.out.println(st);
			 
		 }
		}
		catch(Exception e1)
		{
			System.out.println(e1);
		}
		
	}
	
	public void updateStudents()
	{
		System.out.println("Enter name and id:");
		String name=sc.next();
		int id=sc.nextInt();
		try
		{
		String q="update studentlist set name=? where id=?";
		Connection con=ConnectionProvider.getConnection();
		PreparedStatement pstmt=con.prepareStatement(q);
		pstmt.setInt(2, id);
		pstmt.setString(1, name);
		pstmt.execute();
		con.close();
		
		
		}
		catch(Exception e1)
		{
			System.out.println(e1);
		}
		
	}
}
