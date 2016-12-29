package com.assignment.assign2;

import java.util.Hashtable;
import java.util.Scanner;

public class Assign_2 {

	public static void main(String[] args) 
	{
			Hashtable<String,String> ht=new Hashtable<>();
			String key;
			String val;
			Scanner kb=new Scanner(System.in);
			System.out.println("Enter 10 id and name of Product");
			for(int i=0;i<10;i++)
			{
				key=kb.nextLine();
				val=kb.nextLine();
				ht.put(key, val);
			}
			System.out.println(ht);
			System.out.println("Enter a Product name to search");
			String search=kb.nextLine();
			System.out.println("Product found "+ht.containsValue(search));
			System.out.println("Enter Product id and name to remove from Hashtable");
			System.out.println("Enter Product id");
			key=kb.nextLine();
			System.out.println("Enter Product name");
			val=kb.nextLine();
			System.out.println("Record removed "+ht.remove(key, val));
			System.out.println("After removal\n"+ht);
	}

}
