package jdbcProgram;

public class Student
{
    private int id;
    private String name;
    private String phone;
    
    public Student(int id, String name, String phone)
    {
    	this.id=id;
    	this.name=name;
    	this.phone=phone;
    	
    }
    
    public Student()
    {
    	
    }
    
    public void setId(int id)
    {
    	this.id=id;
    }
    
    public int getId()
    {
    	return id;
    }
    
    public void setName(String name)
    {
    	this.name=name;
    }
    
    public String getName()
    {
    	return name;
    }
    
    public void setPhone(String phone)
    {
    	this.phone=phone;
    }
    
    public String getPhone()
    {
    	return phone;
    }
    
    public String toString()
    {
		return "Student [Id = " +id + ", Name = "+name + ", Phone = " + phone + "]";
    	
    }
}
