package caseStudy;
import java.util.Scanner;
import caseStudy.checkcus;
import caseStudy.admin;
import caseStudy.items;
public class main{
	static String name;
	static String id;
	public static void main(String args[]) throws Exception
	{
		Scanner s=new Scanner(System.in);
		checkcus cc=new checkcus();
		
		System.out.println("Welcome to ONLINE ORDERING PLATFORM");
		while(true)
		{
			System.out.println("say whether you are old customer or new customer or admin or exit:");
			String check=s.next().toLowerCase();
			if(check.equals("old")==true)
			{
				int errorcount=0;
				for(;errorcount<3;errorcount++)
				{
					System.out.println("Enter your customer ID:");
					id=s.next();
					System.out.println("Enter your password:");
					String pass=s.next();
					boolean istrue=cc.check(id, pass);
					if(istrue==true)
					{
						System.out.println("Hello "+name+" !!!!");
						break;
					}
					else
					{
						System.out.println("Incorrect User ID or Password");
						continue;
					}
				}
				if(errorcount<3)
				{
					//the user entered the correct credentials now we should take further
					System.out.println("1-View items");
					System.out.println("2-log out:");
					System.out.println("Select the option from above:");
					int option=s.nextInt();
					
					if(option==1)
					{
						items i=new items();
						System.out.println("product id-product Name-product cost-product quantity-product type ");
						i.disp();
						System.out.println();
						
						
						System.out.println("1-press 1 to buy and 2 to log out:");
						int ch=s.nextInt();
						if(ch==1)
						{
							i.selling();
						}
						else
							continue;
					}
					else
					{
						System.out.println("Thank you!..Logged Out Successfully");
						continue;
					}
				}
				else
				{
					System.out.println("sorry limit exceeded");
					continue;
				}
			}
			else
			if(check.equals("new")==true)
			{
				System.out.println("Enter your name:");
				String name=s.next();
				cc.addcus(name,s);
			}
			else
			if(check.equals("admin")==true)
			{
				admin a=new admin();
				a.main(args);
				//a.menu();
			}
			else
			if(check.equals("exit")==true)
				break;
		}
	}
}
