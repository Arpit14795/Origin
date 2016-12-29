package com.assignment.assign1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Assign_1 
{

	public static void main(String[] args) throws ParseException,FileNotFoundException,IOException
	
	{
		Scanner sc=new Scanner(System.in);
//		String source=sc.nextLine();
//		String dest=sc.nextLine();
		//File f1=new File(source);
	//	System.out.println(f1.isFile()+" "+f1.isDirectory());
	//	if(!f1.exists())
		{
		//	System.out.println("Source file not found");
			//return;
		}
		//File f2=new File(dest);
		
		

		File f=new File("/Java");
		//sc=new Scanner("sdfsd gfskhfskg ersghk");
		sc=new Scanner (f);
		System.out.println(f.getPath());
		System.out.println(f.getAbsolutePath());
		System.out.println(f.getCanonicalPath());
		
	//	sc.useDelimiter("s");  // delimiter used
	//	Pattern ptr=Pattern.compile("s");//pattern used
	//	sc.useDelimiter(ptr);
		/* while(sc.hasNext())
		 {
			 System.out.println(sc.next());
			 
		 }*/
		/* while(sc.hasNextLine())
		 {
			 System.out.println(sc.nextLine());
		 }*/
		 /*while(sc.hasNextLine())
		 {
			 String line=sc.nextLine();
			 System.out.println(sc.nextLine().length());
		 }*/
		 while(sc.hasNextLine())
		 {
			 String line=sc.nextLine();

			 	String data[]=line.split(" ");
			 	System.out.println(data.length);
			 	for(String string:data)
			 	{
			 		System.out.println(string);
			 	}
		 }
		
		
		
		
		
		
//			make a sql date
			java.sql.Date sqlDate=new java.sql.Date(0);
			System.out.println(sqlDate);
		
		
		
		Calendar cal=Calendar.getInstance();
		cal.add(Calendar.MONTH,3);
		Date d=new Date();
		System.out.println("after 3 month "+d);
		
		SimpleDateFormat sdf=new SimpleDateFormat("dd-MMMM-yy");
		cal.get(Calendar.YEAR);
		System.out.println(sdf.format(d));
		
		Date d1=getDate("5-5-2016");
		System.out.println(sdf.format(d1));
		
		
	}
     static Date getDate(String val)throws ParseException
     {
    	 SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
    	 sdf.setLenient(false);
    	 Date d=sdf.parse(val);
    	 return d;
    	 
     }
}
