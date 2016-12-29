import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class UtilToSql {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
// util to sql Date
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		Date d = sdf.parse("29-13-2015");
		System.out.println(sdf.format(d));
		
		java.sql.Date dd = new java.sql.Date(d.getTime());
		System.out.println(dd);
		
		System.out.println(d.getTime()+"     "+dd.getTime());
	}

}
