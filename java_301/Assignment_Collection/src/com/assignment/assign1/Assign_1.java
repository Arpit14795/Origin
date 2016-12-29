package com.assignment.assign1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Assign_1 {

	public static void main(String[] args) 
	{
         Scanner kb=new Scanner(System.in);
         List<String> name=new ArrayList<>();
         String s;
         System.out.println("Enter name to add in ArrayList or enter -1 to stop");
         for(;;)
         {
        	 s=kb.nextLine();
        	 if(s.equals("-1"))
        	 break;
        	 else
        		 name.add(s);
         }
         
         System.out.println("Enter a name you want to find");
         s=kb.nextLine();
         System.out.println(name.contains(s));
	}

}
