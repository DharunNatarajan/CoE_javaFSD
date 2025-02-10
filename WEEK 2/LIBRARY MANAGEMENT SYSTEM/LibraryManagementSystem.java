import java.util.*;
public class LibraryManagementSystem extends Thread
{
	public static void main(String[] args) throws InterruptedException
	{
		LibraryManager lib = new LibraryManager();
		Books b1 = new Books("FIRE","ARUN","TRY654");
		Books b2 = new Books("AURA","BALA","FMB410");
		Books b3 = new Books("RESCUE","CHARLIE","OQE651");
		Users u1 = new Users("AHMED","LIB05",new ArrayList<>());
		Users u2 = new Users("HARISH","LIB098",new ArrayList<>());
		Users u3 = new Users("RICHARD","LIB0123",new ArrayList<>());
		lib.addBook(b1);
		lib.addBook(b2);
		lib.addBook(b3);
		lib.addUser(u1);
		lib.addUser(u2);
		lib.addUser(u3);
		Runnable r1 = () -> lib.searchBook("AURA");
		Runnable r2 = () -> lib.reserveBook("FMB410", "LIB05");
		Runnable r3 = () -> lib.borrowBook("FMB410", "LIB098");
		Runnable r4 = () -> lib.returnBook("FMB410","LIB0123");
		Thread t1 = new Thread(r1);
		Thread t2 = new Thread(r2);
		Thread t3 = new Thread(r3);
		Thread t4 = new Thread(r4);
		t1.start();
		t1.join();
		t2.start();
		t2.join();
		t3.start();
		t3.join();
		t4.start();
		t4.join();
	}
}