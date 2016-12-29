import java.util.Calendar;


	
  public class Outside
  {
	  private int data=30;//instance variable  
	  void display()
	  {  
		  int data=50;//local variable must be final till jdk 1.7 only  
		  class Local
		  {  
			  void msg(){System.out.println(data);}  
		  }  
		  Local l=new Local();  
		  l.msg();  
	  }  
	  public static void main(String args[])
	  {  
	   Outside obj=new Outside();  
	   obj.display();  
	  }  
  }
