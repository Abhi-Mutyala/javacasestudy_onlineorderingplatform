package caseStudy;
import java.io.IOException;
import java.util.Scanner;
import caseStudy.items;
import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.IOException;

public class admin extends checkcus{//for having all the customer details
	public static void main(String args[]) 
	{
		Scanner s=new Scanner(System.in);
		items ii=new items();
		
		admin a=new admin();
		while(true)
		{
			System.out.println("1-see all the customers data");
			System.out.println("2-see the items");
			System.out.println("3-see the payment history");
			System.out.println("4-update data");
			System.out.println("5-Exit");
			
			System.out.println("Enter a number the above Menu:");
			int number=s.nextInt();
			if(number==1)
			{
				try
				{
					System.out.println("Name - CustomerID - Password - phone number");
					a.disp();
					System.out.println();
				}
				catch(IOException ie)
				{
					
				}
			}
			else
			if(number==2)
			{
				items i=new items();
				try
				{
					i.disp();
					System.out.println();
				}
				catch(Exception e)
				{
					System.out.println("An error had occured");
				}
			}
			else
			if(number==3)
			{
				try
				{
					File f=new File("C:\\Users\\ABHILASH\\Music\\java_case\\payment_his.txt");
					FileReader fr=new FileReader(f);
					BufferedReader br=new BufferedReader(fr);
					String as=br.readLine();
					while(as!=null)
					{
						System.out.println(as);
						as=br.readLine();
					}
				}
				catch(Exception e)
				{
					System.out.println("An Exception has occured");
				}
			}
			else
			if(number==4)
			{
				try
				{
					ii.update();
				}
				catch(Exception e)
				{
					System.out.println("An error had occured");
				}
			}
			else
				break;
		}
		
		
	}
}