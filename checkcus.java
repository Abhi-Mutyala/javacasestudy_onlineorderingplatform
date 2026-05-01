package caseStudy;
import java.util.Scanner;
import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.IOException;
public class checkcus extends main{
	
	static String cusname="";
	public static void main(String args[]) 
	{
		Scanner s=new Scanner(System.in);
	}
	boolean check(String id,String pass) throws Exception
	{
		File f=new File("C:\\Users\\ABHILASH\\Music\\java_case\\login_his.txt");
				FileReader fr=new FileReader(f);
				BufferedReader br=new BufferedReader(fr);
				
				String lines=br.readLine();
				int customer=0;//to find whether the customer is there in the data or not
				while(lines!=null)
				{
					int hifencount=0;
					
					String idd="";
					String password="";
					
					
					for(int i=0;i<lines.length();i++)
					{
						if(hifencount==0 && lines.charAt(i)!='-')
							cusname+=lines.charAt(i);
						
						if(hifencount==1 && lines.charAt(i)!='-')
						{
							idd+=lines.charAt(i);
						}
						else
						if(hifencount==2 && lines.charAt(i)!='-')
						{
							password+=lines.charAt(i);
						}
						
						if(lines.charAt(i)=='-')
						{
							hifencount+=1;
						}
					}
					if(idd.equals(id)==true && pass.equals(password)==true)
					{
						name=cusname;
						customer+=1;
						lines=null;
					}
					else
						cusname="";
						lines=br.readLine();
				}
				if(customer==1)
				{
					return true;
				}
				else
					return false;
	}
	protected void addcus(String name,Scanner s) throws Exception
	{
		File f=new File("C:\\Users\\ABHILASH\\Music\\java_case\\login_his.txt");
		FileReader fr=new FileReader(f);
		BufferedReader br=new BufferedReader(fr);
		String id="";
		String line=br.readLine();
		String matter="";
		
		int linecount=0;
		while(line!=null)
		{			
			linecount+=1;
			matter+=line;
			line=br.readLine();
			if(line!=null) 
			{
				matter+="\n";
			}
		}
		FileWriter fw=new FileWriter(f);
		System.out.println("Enter the your password");
		String pass=s.next();
		System.out.println("Enter your phone number:");
		String phonenumber=s.next();
		BufferedWriter bw=new BufferedWriter(fw);
		int idd = linecount;
		String newcus=name+"-"+(idd+1)+"-"+pass+"-"+phonenumber;
		if(matter!=null)
			bw.write(matter+"\n"+newcus);
		else
			bw.write("\n"+newcus);
	//	System.out.println("your id is :"+idd);
		System.out.println("Your id is :"+(idd+1));
		System.out.println("your password is :"+pass);
		name=cusname;
		bw.close();
		fw.close();
	}
	protected void disp() throws IOException
	{
		File f=new File("C:\\Users\\ABHILASH\\Music\\java_case\\login_his.txt");
		FileReader fr=new FileReader(f);
		BufferedReader br=new BufferedReader(fr);
		String line=br.readLine();
		while(line!=null)
		{
			System.out.println(line);
			line=br.readLine();
		}
	}
}
