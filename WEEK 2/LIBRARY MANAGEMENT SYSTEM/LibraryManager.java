import java.util.ArrayList;
class LibraryManager extends LibrarySystem
{
 LibraryManager()
 {
	 this.Book = new ArrayList<>();
	 this.User = new ArrayList<>();
 }
 public synchronized void reserveBook(String ISBN,String ID)
 {
	 try
	 {
		 Books reserveBook = null;
		 Users reserveUser = null;
		 for(Books b : Book)
		 {
			 if(b.getISBN().equals(ISBN))
			 {
				 reserveBook = b;
				 System.out.println("!---- BOOK RESERVED FOR BORROW ----!");
				 System.out.println(b.getTitle()+" "+b.getAuthor()+" "+b.getISBN());
			 }
			 if(reserveBook == null)
				 throw new BookNotFoundException("!---- BOOK IS UNAVAILABLE ----!");
		 }
		 for(Users u : User)
		 {
			 if(u.getID().equals(ID))
			 {
				 reserveUser = u;
				 System.out.println("!---- USER RESERVED IS ACCEPTED ----!");
				 System.out.println(u.getID()+" "+u.getUname());
			 }
			 if(reserveUser == null)
				 throw new UserNotFoundException("!---- USER IS NOT FOUND ----!");
		 }
	 }
	 catch(BookNotFoundException | UserNotFoundException e)
	 {
		 System.out.println(e);
	 }
	 
 }
 public synchronized void borrowBook(String ISBN,String ID)
 {
	 try 
	 {
		 Books borrowBook = null;
		 Users borrowUser = null;
		 for(Books b : Book)
		 {
			 if(b.getISBN().equals(ISBN))
			 {
				 borrowBook = b;
				 System.out.println("!----BOOK BORRWED SUCCESSFULLY----!");
				 System.out.println(b.getTitle()+" "+b.getAuthor()+" "+b.getISBN());
			 }
			 if(borrowBook == null)
				 throw new BookNotFoundException("!----BOOK IS NOT FOUND----!");
		 }
		 for(Users u : User)
		 {
			 if(u.getID().equals(ID))
			 {
				 borrowUser = u;
				 borrowUser.getBorrowedBook().add(borrowBook);
				 System.out.println("!----USER DETAILS----!");
				 System.out.println(u.getUname()+" "+u.getID()+" "+u.getBorrowedBook());
			 }
			 if(borrowUser == null)
			 {
				 throw new UserNotFoundException("!----USER IS NOT FOUND----!");
			 }
			 if(borrowUser.getBorrowedBook().size() > 3)
			 {
				 throw new MaxBooksAllowedException("!--- LIMIT EXCEEDED ---!");
			 }
		 }
	 }
	 catch(BookNotFoundException e)
	 {
		 System.out.println(e);
	 }
	 catch(MaxBooksAllowedException e)
	 {
		 System.out.println(e);
	 }
	 catch(UserNotFoundException e)
	 {
		 System.out.println(e);
	 }
 	}
 public synchronized void returnBook(String ISBN, String ID)
 {
	 try
	 {
		 Books borrowBook = null;
		 Users borrowUser = null;
		 for(Books b : Book)
		 {
			 if(b.getISBN().equals(ISBN))
			 {
				 borrowBook = b;
				 System.out.println("!---- BOOK RETURNED SUCCESSFULLY ----!");
				 System.out.println(b.getTitle()+" "+b.getISBN()+" "+b.getAuthor());
			 }
			 if(borrowBook == null)
				 throw new BookNotFoundException("!---- BOOK IS NOT FOUND ----!");
		 }
		 for(Users u : User)
		 {
			 if(u.getID().equals(ID))
			 {
				 borrowUser = u;
				 borrowUser.getBorrowedBook().remove(borrowBook);
				 System.out.println("!---- USER DETAILS ----!");
				 System.out.println(u.getID()+" "+u.getUname()+" "+u.getBorrowedBook());
			 }
			 if(borrowUser == null)
				 throw new UserNotFoundException("!---- USER NOT FOUND ----!");
		 }
	 }
	 catch(BookNotFoundException e)
	 {
		 System.out.println(e);
	 }
	 catch(UserNotFoundException e)
	 {
		 System.out.println(e);
	 }
 }
 public synchronized Books searchBook(String title)
 {
	for(Books b : Book)
	{
	 if(b.getTitle().equalsIgnoreCase(title))
	 {
	  System.out.println("!---- BOOK IS FOUND ----!");
	  System.out.println("BOOK TITLE : "+b.getTitle()+",AUTHOR : "+b.getAuthor()+", ISBN : "+b.getISBN());
	  return b;
	 }
	}
	return null;
 }
 public void addBook(Books book)
 {
  Book.add(book);
 }
 public void addUser(Users user)
 {
  User.add(user);
 }
}