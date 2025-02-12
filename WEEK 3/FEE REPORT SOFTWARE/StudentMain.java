import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;

public class StudentMain 
{
	private  int id;
	private String name;
	private String email;
	private String course;
	private double fee;
	private double paid;
	private double due;
	private String address;
	private String phone;
	
	StudentMain()
	{
		
	}
	StudentMain(int id,String name,String email,String course,double fee, double paid, String address, double due, String phone)
	{
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.course = course;
		this.fee = fee;
		this.paid = paid;
		this.due = due;
		this.address = address;
		this.phone = phone;
	}
	public int getID()
	{
		return id;
	}
	public String getName()
	{
		return name;
	}
	public String getEmail()
	{
		return email;
	}
	public String getCourse()
	{
		return course;
	}
	public double getFee()
	{
		return fee;
	}
	public double getPaid()
	{
		return paid;
	}
	public double getDue()
	{
		return due;
	}
	public String getAddress()
	{
		return address;
	}
	public String getPhone()
	{
		return phone;
	}
	public boolean addStudent(int id,String name,String email,String course,double fee,double paid,double due,String address,String phone) throws Exception
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/world?useUnicode=true&characterEncoding=utf8";
		String user = "root";
		String dpwd = "root";
		int row = 0;
		PreparedStatement st1 = null,checkst1 = null;
		Connection con = null;
		ResultSet rs = null;
		try 
		{
		 con = DriverManager.getConnection(url,user,dpwd);
		 String checkQuery = "SELECT COUNT(*) FROM accountant WHERE email = ? OR phone = ?";
		 checkst1 = con.prepareStatement(checkQuery);
		 checkst1.setString(1, email);
		 checkst1.setString(2, phone);
		 rs = checkst1.executeQuery();
		 rs.next();
		 if(rs.getInt(1) > 0)
		 {
			 System.out.println("Account already exists with the given email or phone.");
			 return false;
		 }
		 String query = "INSERT INTO student(name,email,course,fee,paid,due,address,phone) VALUES(?,?,?,?,?,?,?,?)";
		 st1 = con.prepareStatement(query);
		 st1.setString(1,name);
		 st1.setString(2,email);
		 st1.setString(3,course);
		 st1.setDouble(4,fee);
		 st1.setDouble(5,paid);
		 st1.setDouble(6,due);
		 st1.setString(7,address);
		 st1.setString(8,phone);
		 row = st1.executeUpdate();
		 return row > 0;
		}
		catch (SQLIntegrityConstraintViolationException e)
		{
	        System.out.println("Student Username already exists.Please choose a different username.");
	        return false;
	    }
		catch(SQLException e)
		{
			e.printStackTrace();
			return false;
		}
		finally
		{
			try 
			{
			 if(st1!=null)
				st1.close();
			 if(con != null)
				con.close();
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
	}
	public void showStudent() throws Exception
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/world?useUnicode=true&characterEncoding=utf8";
		String user = "root";
		String dpwd = "root";
		Connection con = DriverManager.getConnection(url,user,dpwd);
		Statement st = con.createStatement();
		String query = "SELECT * FROM student";
		ResultSet rs = st.executeQuery(query);
		while(rs.next())
		{
			System.out.println("ID : "+rs.getInt(1)+" NAME : "+rs.getString(2)+" EMAIL : "+rs.getString(3)+" COURSE: "+rs.getString(4)+" FEE : "+rs.getDouble(5)+" PAID : "+rs.getDouble(6)+" DUE : "+rs.getDouble(7)+" ADDRESS : "+rs.getString(8)+" PHONE NUMBER : "+rs.getString(9));
		}
	}
	
}
