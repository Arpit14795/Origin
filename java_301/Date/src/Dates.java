import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;


public class Dates 
{

	public static void main(String[] args) throws ParseException
	{
	Calendar c=Calendar.getInstance();
	//System.out.println(c.get(Calendar.MINUTE));
	System.out.println(c.getTime());
	c.setLenient(false);
	//c.roll(Calendar.MONTH, -1);
	c.roll(Calendar.MONTH, false);
	//c.set(Calendar.MONTH, 12);
	System.out.println(c.getTime());
	/*//c.clear();
	//c.set(1, Calendar.AUGUST);
	System.out.println(c.isSet(1));
	GregorianCalendar gc=new GregorianCalendar();*/
	SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/y/h/m/s/G");
	/*System.out.println(sdf.toPattern());
	//System.out.println(sdf.format(c.getTime()));
	//sdf.setLenient(false);
	
	Date d=sdf.parse("05/13/2016");
	System.out.println(sdf.format(d));*/
	GregorianCalendar cl=new GregorianCalendar(540,6,14,8,40,45);
	cl.set(Calendar.ERA,1);
	System.out.println(cl.getTime());
	System.out.println(cl.getTimeInMillis());
	System.out.println(sdf.format(cl.getTime()));
	
}

}
