package Utilities;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtils {

    private static final DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    public static String getDate(int numberOfDays){

        Calendar calendar = Calendar.getInstance();

        calendar.add(Calendar.DAY_OF_WEEK, numberOfDays);
        String currentDatePlus = dateFormat.format(calendar.getTime());
        return currentDatePlus;
    }


}
