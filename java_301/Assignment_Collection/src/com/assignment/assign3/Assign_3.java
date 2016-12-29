package com.assignment.assign3;

import java.util.Scanner;
import java.util.Vector;

public class Assign_3 {

	public static void main(String[] arg) 
	{
		System.out.println("Choose any number"
				+ "\n1.	accept first name and surname \n"+
				"\n2.	display complete name\n"
				+
				"\n3.	exit\n");
		Vector<Name> v=new Vector<>();
		Name name;
		Scanner kb=new Scanner(System.in);
		while(true)
		{
			
			System.out.println("Enter choice");
			int choice=kb.nextInt();
			//kb.nextLine();
			switch(choice)
			{
			case 1:
			{
				System.out.println("Enter name and surname");
				name=new Name(kb.next(),kb.next());
				v.add(name);
				break;
			}
			case 2:
			{
				System.out.println("Displaying names:\n"+v);
				break;
			}
			case 3:
			{
				return;
			}
			default:
				System.out.println("Choose right number");

			}
		}
	}

}
