package com.JDBCTask1;

public class Student1
{                                                     
    private int stdId;
    private String stdName;
    private String stdCity;
     
    public void setId(int id)
    {
    	this.stdId=stdId;
    	
    }
    public int getId()
    {
    	return stdId;                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           
    }
    
    public void setStdName(String name)
    {
    	this.stdName=stdName;
    	
    }
    public String getStdName()
    {
    	return stdName;
    	
    }
    
    public void setStdCity(String stdCity)
    {
    	this.stdCity=stdCity;
    	
    }
    
    public String getStdCity()
    {
    	return stdCity;
    	
    }
    
    public String toString()
    {
    	return "Student [ stdId: "+stdId+" stdName: "+stdName+ " stdCity: "+stdCity+"]";
    }
}
