import java.sql.*;
public class AdminMain
{
	private String uname;
	private String pwd;
	AdminMain()
	{
		
	}
	AdminMain(String uname, String pwd)
	{
		super();
		this.uname = uname;
		this.pwd = pwd;
	}
	// getters and setters
	
	public String getUname()
	{
		return uname;
	}
	
	public String getPwd()
	{
		return pwd;
	}
	public boolean adminLogin(String uname, String pwd) throws Exception
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/world?useUnicode=true&characterEncoding=utf8";
		String user = "root";
		String dpwd = "root";
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		try 
		{
		 con = DriverManager.getConnection(url,user,dpwd);
		 String query = "SELECT * FROM admin WHERE username = ? AND password = ?";
		 st = con.prepareStatement(query);
		 st.setString(1,uname);
		 st.setString(2, pwd);
		 rs = st.executeQuery();
		 if(rs.next())
			 return true;
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			try 
			{
			 if(rs != null)
				rs.close();
			 if(st!=null)
				st.close();
			 if(con != null)
				con.close();
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
		return false;
	}
	public boolean adminRegister(String uname, String pwd) throws Exception
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/world?useUnicode=true&characterEncoding=utf8";
		String user = "root";
		String dpwd = "root";
		int row = 0;
		PreparedStatement st1 = null;
		Connection con = null;
		try 
		{
		 con = DriverManager.getConnection(url,user,dpwd);
		 String query = "INSERT INTO admin(username,password) VALUES(?,?)";
		 st1 = con.prepareStatement(query);
		 st1.setString(1,uname);
		 st1.setString(2,pwd);
		 row = st1.executeUpdate();
		 return row > 0;
		}
		catch (SQLIntegrityConstraintViolationException e) {
	        System.out.println("Username already exists. Please choose a different username.");
	        return false;}
		catch(SQLException e)
		{
			e.printStackTrace();
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
		return false;
	}
}
