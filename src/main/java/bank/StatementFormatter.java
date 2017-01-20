package bank;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Rich on 21/04/2016.
 */
public class StatementFormatter {

  public static Date formatDate(String dateToReturn) throws ParseException {
    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
    return sdf.parse(dateToReturn);
  }

  public static String formatDate(Date date) throws ParseException {
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    return sdf.format(date);
  }

  public static String formatAmount(double amount) throws ParseException {
    DecimalFormat df = new DecimalFormat("#.00");
    return df.format(amount);
  }

}
