import java.util.*;
public class Users 
{
	private String uname;
	private String ID;
	private List<Books> borrowedBooks;
	
	Users(String uname,String ID,List<Books> borrowedBooks)
	{
		super();
		this.uname = uname;
		this.ID = ID;
		this.borrowedBooks = borrowedBooks;
	}
	//getters and setters
	public void setUname(String uname)
	{
		this.uname = uname;
	}
	public String getUname()
	{
		return uname;
	}
	public void setID(String ID)
	{
		this.ID = ID;
	}
	public String getID()
	{
		return ID;
	}
	public void setBorrowedBook(List<Books> borrowedBooks)
	{
		this.borrowedBooks = borrowedBooks;
	}
	public List<Books> getBorrowedBook()
	{
		return borrowedBooks;
	}
}
