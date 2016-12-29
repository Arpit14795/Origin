import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class ParsingDate
{
	public static void main(String[] args) throws ParseException
	{
		SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-y");
		sdf.setLenient(false);
		Date d=sdf.parse("12-13-2000");
		Calendar c =  Calendar.getInstance();
		c.setTime(sdf.parse("12-13-2000"));
		System.out.println(sdf.format(d));
	}
}
