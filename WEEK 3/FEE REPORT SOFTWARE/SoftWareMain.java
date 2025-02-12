import java.sql.*;
import java.util.*;
public class SoftWareMain
{
	public static void main(String[] args) throws Exception
	{
	 boolean flag = true;
	 Scanner sc = new Scanner(System.in);
	 while(flag) {
	 System.out.println("-----FEE REPORT SOFTWARE-----");
	 System.out.println("1.ADMIN");
	 System.out.println("2.ACCOUNTANT");
	 System.out.println("3.EXIT");
	 System.out.println("----------");
	 System.out.println("ENTER YOUR CHOICE : ");
	 int ch = sc.nextInt();
	 AdminFunctions af = new AdminFunctions();
	 StudentMain sm = new StudentMain();
	 switch(ch)
	 {
	 	case 1 :
	 	{
	 	 boolean flag1 = true;
	 	 while(flag1) {
	 		 System.out.println("----- ADMIN OPTIONS -----");
		 System.out.println("----------");
		 System.out.println("1.LOGIN");
		 System.out.println("2.REGISTER");
		 System.out.println("3.EXIT");
		 System.out.println("----------");
		 System.out.println("ENTER YOUR CHOICE : ");
		 int n = sc.nextInt();
		 System.out.println("----------");
		 AdminMain am = new AdminMain();
		 switch(n)
		 {
		  case 1 :
		  {
			  try 
			  {
				 System.out.println("ENTER USER NAME : ");
				 String uname = sc.next();
				 System.out.println("ENTER PASSWORD : ");
				 String pwd = sc.next();
				 System.out.println("----------");
				 if(am.adminLogin(uname,pwd))
				 {
					 System.out.println("LOGGED IN SUCCESSFULLY");
					 System.out.println("---------------");
					 af.adminFunctions();
				 }
				 else
				 {
					 throw new NoUserFoundException("NO USER IS FOUND");
				 }	
			  }
			  catch(Exception e)
			  {
				  System.out.println(e);
			  }
			 break;
		  }
		  case 2 :
		  {
			  System.out.println("ENTER USER NAME : ");
			  String uname = sc.next();
			  System.out.println("ENTER PASSWORD : ");
			  String pwd = sc.next();
			  System.out.println("----------");
			  if(am.adminRegister(uname,pwd))
			  {
				  System.out.println("REGISTERED SUCCESSFULLY");	  
			  }
			  break;
		  }
		  case 3 :
		  {
			  flag1 = false;
			  System.out.println("THANK YOU");
			  break;
		  }
		  default :
		  {
			  System.out.println("INVALID CHOICE");
		  }
		 }
	   }
	 	}
	 	case 2 :
	 	{
	 		boolean  flag2 = true;
	 		while(flag2) {
	 		System.out.println("---------------------");
	 		System.out.println("1.ADD STUDENTS");
	 		System.out.println("2.VIEW STUDENTS");
	 		System.out.println("3.EXIT");
	 		System.out.println("---------------------");
	 		System.out.println("ENTER YOUR CHOICE :  ");
	 		int cho = sc.nextInt();
	 		System.out.println("---------------------");
	 		switch(cho)
	 		{
	 			case 1 :
	 			{
	 				try {
	 				System.out.println("ENTER ID : ");
	 				int id = sc.nextInt();
	 				System.out.println("ENTER NAME : ");
	 				String name = sc.next();
	 				System.out.println("ENTER EMAIL : ");
	 				String email = sc.next();
	 				System.out.println("ENTER COURSE : ");
	 				String course = sc.next();
	 				System.out.println("ENTER FEE : ");
	 				double fee = sc.nextDouble();
	 				System.out.println("ENTER PAID : ");
	 				double paid = sc.nextDouble();
	 				System.out.println("ENTER DUE : ");
	 				double due = sc.nextDouble();
	 				System.out.println("ENTER ADDRESS : ");
	 				String address = sc.next();
	 				System.out.println("ENTER PHONE NUMBER : ");
	 				String phone = sc.next();
	 				if(sm.addStudent(id,name,email,course,fee,paid,due,address,phone))
	 					System.out.println("STUDENT DETAIL UPDATED SUCCESSFULLY");
	 				else
	 					throw new NoUserFoundException("NO USER IS FOUND");
	 				}
	 				catch(Exception e)
	 				{
	 					System.out.println(e);
	 				}
	 				break;
	 			}
	 			case 2 :
	 			{
	 				System.out.println("----- STUDNET DETAILS -----");
	 				sm.showStudent();
	 				break;
	 			}
	 			case 3 :
	 			{
	 				flag2 = false;
	 				System.out.println("THANK YOU!!");
	 				break;
	 			}
	 			default :
	 			{
	 				System.out.println("INVALID CHOICE");
	 			}
	 		}
	 	}
	 	}
	 		case 3 :
	 		{
	 			System.out.println("THANK YOU");
	 			flag = false;
	 			break;
	 		}
	 		default :
	 		{
	 			System.out.println("INVALID CHOICE");
	 		}
	 }
	 }
	}
}