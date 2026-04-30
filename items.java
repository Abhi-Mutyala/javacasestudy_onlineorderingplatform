package caseStudy;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.FileReader;
import java.util.Scanner;
import caseStudy.main;
import java.util.Vector;
import caseStudy.main;//for name for the transaction history


public class items {
	
	int linecount=0;
	Vector prodid=new Vector();
	Vector prodname=new Vector();
	Vector<Double> prodcost=new Vector<>();
	Vector<Integer> prodquan=new Vector<>();
	Vector prodtype=new Vector();
	
	
	public static void main(String args[]) throws IOException
	{
		items i=new items();
		try
		{
			
			i.count();//for the number of lines
			i.itemstoary();
		}
		catch(Exception e)
		{
			System.out.println("Error occured");
		}
	}
	void disp() throws IOException
	{
		File f=new File("C:\\Users\\ABHILASH\\Music\\java_case\\items.txt");
		FileReader fr=new FileReader(f);
		BufferedReader br=new BufferedReader(fr);
		String s=br.readLine();
		while(s!=null)
		{
			System.out.println(s);
			s=br.readLine();
		}
	}
	
	void count() throws Exception
	{
		File f=new File("C:\\Users\\ABHILASH\\Music\\java_case\\items.txt");
		FileReader fr=new FileReader(f);
		BufferedReader br=new BufferedReader(fr);
		String lines=br.readLine();
		while(lines!=null)
		{
			linecount+=1;
			lines=br.readLine();
		}
		
		
		
	}
	
	
	void itemstoary() throws Exception
	{
		
		File f=new File("C:\\Users\\ABHILASH\\Music\\java_case\\items.txt");
		FileReader fr=new FileReader(f);
		BufferedReader br = new BufferedReader(fr);
		String line=br.readLine();
		
		int index=0;
		while(line!=null)
		{
			String id="",prodnam="",prodcos="",prodqua="",prodtyp="";
			int bind=line.indexOf(')');
			int ccount=0;
			
			for(int i=0;i<line.length();i++)
			{
				if(line.charAt(i)==',')
					ccount+=1;
				
				if(i>bind && ccount==0 && line.charAt(i)!=',')
				{
					id+=line.charAt(i);
				}
				if(i>bind && ccount==1 && line.charAt(i)!=',')
				{
					prodnam+=line.charAt(i);
				}
				if(i>bind && ccount==2 && line.charAt(i)!=',')
					prodcos+=line.charAt(i);
				if(i>bind && ccount==3 && line.charAt(i)!=',')
				{
					prodqua+=line.charAt(i);
				}
				if(i>bind && ccount==4 && line.charAt(i)!=',')
				{
					prodtyp+=line.charAt(i);
				}
			}
			
			double procos=0;
			int proqua=0;
			
			try
			{
				procos=Double.valueOf(prodcos);
				proqua=Integer.valueOf(prodqua);
			}
			catch(NumberFormatException nfe)
			{
				System.out.println("An error had Occured");
			}
			
			
			prodid.add(index,id);
			prodname.add(index,prodnam);
			prodcost.add(index,procos);
			prodquan.add(index,proqua);
			prodtype.add(index,prodtyp);
			
			
			index+=1;
			line=br.readLine();
		}
	}
	
	void selling() throws Exception
	{
		items ii=new items();
		ii.count();
		ii.itemstoary();
		
		
		String bill=new String();
		double total=0;
		Scanner s=new Scanner(System.in);
		while(true)
		{
			System.out.print("Enter the product id and quantity to buy or stop to get bill:");
			String ch=s.next().trim().toUpperCase();
			
			if(ch.equals("STOP")==true)
			{
				
				
				System.out.println("your bill is:"+bill);
				System.out.println("-----------------------------------");
				System.out.println("total is :"+total);
				System.out.println("Thank you for buying");
				
				File f=new File("C:\\Users\\ABHILASH\\Music\\java_case\\items.txt");
				FileWriter fw=new FileWriter(f);
				BufferedWriter bw=new BufferedWriter(fw);
				for(int i=0;i<ii.linecount;i++)
				{
					String ss=i+1+")"+ii.prodid.get(i)+","+ii.prodname.get(i)+","+ii.prodcost.get(i)+","+ii.prodquan.get(i)+","+ii.prodtype.get(i)+"\n";
					
					
					bw.write(ss);
				}
				bw.close();
				fw.close();
				
				File ff=new File("C:\\Users\\ABHILASH\\Music\\java_case\\payment_his.txt");
				
				FileReader fr=new FileReader(ff);
				BufferedReader br=new BufferedReader(fr);
				String l=br.readLine();
				String mat="";
				while(l!=null)
				{
					mat+=l+"\n";
					l=br.readLine();
				}
				
				checkcus c=new checkcus();
				
				main m=new main();
				FileWriter frr=new FileWriter(ff);
				BufferedWriter bww=new BufferedWriter(frr);
				bww.write(mat+m.name+"-customer id-"+m.id+"\n"+bill+"\ntotal-"+total);
				
				bww.close();
				frr.close();
				break;
				
			}
			else
			{
				int ind=-1;
				for(int i=0;i<ii.prodid.size();i++)
				{
					if(ii.prodid.get(i).equals(ch)==true)
						ind=i;
				}
				if(ind==-1)
				{
					System.out.println("Sorry the product with given id not found");
					continue;
				}
				else
				{
					System.out.println("Enter the quantity of the product:");
					int qu=s.nextInt();
					if(ii.prodquan.get(ind)>qu)
					{
						if(bill!="")
						{
							bill=bill+"|"+ii.prodid.get(ind)+" , "+ii.prodname.get(ind)+" , "+ii.prodcost.get(ind)+" , "+qu+" , "+ii.prodtype.get(ind);
						}
						else
							bill=bill+ii.prodid.get(ind)+" , "+ii.prodname.get(ind)+" , "+ii.prodcost.get(ind)+" , "+qu+" , "+ii.prodtype.get(ind);
						
						total+=(qu*ii.prodcost.get(ind));
						int q=ii.prodquan.get(ind)-qu;
						
						ii.prodquan.set(ind,q);
						continue;
					}
					else
					{
						System.out.println("Sorry we have only quantity of "+ii.prodquan.get(ind));
						continue;
					}
				}
			}
		}
	}
	void update() throws Exception
	{
		Scanner s=new Scanner(System.in);
		items iii=new items();
		iii.count();
		iii.itemstoary();
		
		while(true)
		{
			System.out.println("Enter the type of updation you want to make");
			System.out.println("1-add product");
			System.out.println("2-update cost");
			System.out.println("3-update quantity");
			System.out.println("4-break");
			System.out.print("Enter the number from the above:");
			int nu=s.nextInt();
			if(nu==1)
			{
				System.out.println("Enter the product id");
				String id=s.next().toUpperCase();
				if(iii.prodid.indexOf(id)==-1)
				{
					System.out.println("Enter the name of product:");
					String namee=s.next();
					System.out.println("Enter the cost of product:");
					double price=s.nextDouble();
					System.out.println("Enter the quantity of product:");
					int q=s.nextInt();
					System.out.println("Enter the type of product:");
					String type=s.next();
					iii.prodid.add(id);
					iii.prodname.add(namee);
					iii.prodcost.add(price);
					iii.prodquan.add(q);
					iii.prodtype.add(type);
				}
				else
				{
					System.out.println("product already found");
					continue;
				}
			}
			else
			if(nu==2)
			{
				System.out.print("Enter the id of product:");
				String idd=s.next().toUpperCase();
				int a=iii.prodid.indexOf(idd);
				if(a==-1)
					System.out.println("product not found");
				else
				{
					System.out.print("Enter the cost of product:");
					double cost=s.nextDouble();
					iii.prodcost.set(a,cost);
				}
				
			}
			else
			if(nu==3)
			{
				System.out.println("Enter the id of the product:");
				String id=s.next().toUpperCase();
				int a=iii.prodid.indexOf(id);
				if(a==-1)
					System.out.println("product not found");
				else
				{
					System.out.print("Enter the quantity of product:");
					int quan=s.nextInt();
					iii.prodquan.set(a,quan);
				}
				
				
			}
			if(nu==4)
				break;
		}
		

		File f=new File("C:\\Users\\ABHILASH\\Music\\java_case\\items.txt");
		FileWriter fw=new FileWriter(f);
		BufferedWriter bw=new BufferedWriter(fw);
		for(int i=0;i<iii.prodid.size();i++)
		{
			String ss=i+1+")"+iii.prodid.get(i)+","+iii.prodname.get(i)+","+iii.prodcost.get(i)+","+iii.prodquan.get(i)+","+iii.prodtype.get(i)+"\n";
			
			
			bw.write(ss);
		}
		bw.close();
		fw.close();
		
		
		
		
		
	}
}