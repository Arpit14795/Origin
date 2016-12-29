import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;


public class SqlToUtil {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
    SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-y");
    java.util.Date ud =sdf.parse("29-02-2015");
    //--------------------------------------------------
    Date d = new Date (ud.getTime());
    System.out.println(d);
    java.util.Date uud = new java.util.Date(d.getTime());
    System.out.println(sdf.format(uud));
	}

}
