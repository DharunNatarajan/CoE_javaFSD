import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;

public class AccountantMain
{
	private int id;
	private String name;
	private String email;
	private String phone;
	private String pwd;
	AccountantMain()
	{
		
	}
	AccountantMain(int id, String name, String email, String phone,String pwd)
	{
		  super();
		  this.id = id;
		  this.name = name;
		  this.email = email;
		  this.phone = phone;
		  this.pwd = pwd;
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
	public String getPhNo()
	{
		  return phone;
	}
	public String getPwd()
	{
		  return pwd;
	}
	
	public boolean addAcc(String name,String email,String phone,String pwd) throws Exception
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
		 String query = "INSERT INTO accountant(name,email,phone,password) VALUES(?,?,?,?)";
		 st1 = con.prepareStatement(query);
		 st1.setString(1,name);
		 st1.setString(2,email);
		 st1.setString(3,phone);
		 st1.setString(4,pwd);
		 row = st1.executeUpdate();
		 return row > 0;
		}
		catch (SQLIntegrityConstraintViolationException e)
		{
	        System.out.println("Accountant Username already exists.Please choose a different username.");
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
	public void showAcc() throws Exception
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/world?useUnicode=true&characterEncoding=utf8";
		String user = "root";
		String dpwd = "root";
		Connection con = DriverManager.getConnection(url,user,dpwd);
		Statement st = con.createStatement();
		String query = "SELECT * FROM accountant";
		ResultSet rs = st.executeQuery(query);
		while(rs.next())
		{
			System.out.println("ID : "+rs.getInt(1)+" NAME : "+rs.getString(2)+" EMAIL : "+rs.getString(3)+" PHONE NO : "+rs.getString(4));
		}
	}
 }			