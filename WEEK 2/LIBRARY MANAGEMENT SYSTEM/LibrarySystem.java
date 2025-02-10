import java.util.*;
abstract class LibrarySystem implements ILibrary
{
	protected List<Books> Book;
	protected List<Users> User;
	public abstract void addBook(Books book);
	public abstract void addUser(Users User);
}
