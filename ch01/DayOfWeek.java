//////////////////////////////////////////////////////////////////////////////
//
//   DayOfWeek.java
//
//   Description
//
//   Started:           Wed Nov 28 16:33:23 2012
//   Modifications:
//
//   Purpose:
//
//   Calling Sequence:
//
//
//   Inputs:
//
//
//   Outputs:
//
//
//   Example:
//
//   Notes:
//
//////////////////////////////////////////////////////////////////////////////
import utils.CommandLine;
import java.text.DateFormatSymbols;

public class DayOfWeek {
    public static void main(String[] args) {
        if ( CommandLine.checkArgs(args, 3) ) {
            try {
                int month = Integer.parseInt(args[0]);
                int day = Integer.parseInt(args[1]);
                int year = Integer.parseInt(args[2]);

                System.out.println(getWeekday(dayOfWeek(year, month, day)));
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        } else {
            CommandLine.printUsage(DayOfWeek.class, "month", "day", "year");
        }
    }

    private static boolean isValidYear(int year) {
        return year >= 1582;
    }

    private static boolean isValidMonth(int month) {
        return month >= 1 && month <= 12;
    }

    private static boolean isValidDay(int year, int month, int day) {
        if ( day < 1 ) {
            return false;
        } else {
            switch ( month ) {
                case 9:
                case 4:
                case 6:
                case 11:
                    return day <= 30;
                case 2:
                    return isLeapYear(year) ? day <= 29 : day <= 28;
                default:
                    return day <= 31;
            }
        }
    }

    private static boolean isLeapYear(int year) {
        return year % 400 == 0  ||  (year % 100 != 0  &&  year % 4 == 0);
    }

    public static int dayOfWeek(int year, int month, int day) {
        if ( !isValidYear(year)  ||  !isValidMonth(month)  ||  !isValidDay(year, month, day) ) {
            throw new IllegalArgumentException("Invalid input.");
        } else {
            int y0 = year - (14 - month) / 12;
            int x = y0 + y0/4 - y0/100 + y0/400;
            int m0 = month + 12 * ((14 - month) / 12) - 2;
            int d0 = (day + x + (31 * m0) / 12) % 7;
            
            return d0;
        }
    }

    private static String[] weekdays = new DateFormatSymbols().getWeekdays();
    public static String getWeekday(int dayOfWeek) {
        return weekdays[dayOfWeek+1];
    }
}
