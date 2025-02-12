import java.sql.*;
import java.util.*;
public class AdminFunctions
{
  AdminFunctions()
  {
	  
  }
  public void adminFunctions() throws Exception
  {
	  Scanner sc = new Scanner(System.in);
	  System.out.println("ACCOUNTANT FUNCTIONALITIES");
	  System.out.println("---------------");
	  System.out.println("1.ADD NEW ACCOUNTANTS");
	  System.out.println("2.VIEW EXISTING ACCOUNTANTS");
	  System.out.println("3.EXIT");
	  System.out.println("---------------");
	  System.out.println("ENTER YOUR CHOICE : ");
	  int ch = sc.nextInt();
	  System.out.println("---------------");
	  AccountantMain ac = new AccountantMain();
	  switch(ch)
	  {
	   case 1 :
	   {
		  System.out.println("ENTER ACCOUNTANT ID : ");
		  int id = sc.nextInt();
		  System.out.println("ENTER ACCOUNTANT NAME : ");
		  String name = sc.next();
		  System.out.println("ENTER ACCOUNTANT E-MAIL : ");
		  String mail = sc.next();
		  System.out.println("ENTER ACCOUNTANT PH NO : ");
		  String phone = sc.next();
		  System.out.println("ENTER PASSWORD : ");
		  String pwd = sc.next();
		  if(ac.addAcc(name,mail,phone,pwd))
			  System.out.println("NEW ACCOUNTANT IS ADDED");
		  else
			  System.out.println("ALREADY EXISTED");
		  System.out.println("---------------");
		  break;  
	   }
	   case 2 :
	   {
		   System.out.println("----- ACCOUNTANT DETAILS -----");
		   ac.showAcc();
		   break;
	   }
	   case 3 :
	   {
		   System.out.println("THANK YOU!");
		   break;
	   }
	   default :
	   {
		   System.out.println("INVALID CHOICE");
	   }
	  }
  }
}
