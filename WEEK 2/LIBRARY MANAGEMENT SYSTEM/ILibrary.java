interface ILibrary 
{
	void borrowBook(String ISBN,String ID) throws BookNotFoundException, MaxBooksAllowedException, UserNotFoundException;
	void returnBook(String ISBN,String ID) throws BookNotFoundException, UserNotFoundException;
	void reserveBook(String ISBN, String ID) throws BookNotFoundException, UserNotFoundException;
	Books searchBook(String title);
}