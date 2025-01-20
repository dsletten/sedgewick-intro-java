//////////////////////////////////////////////////////////////////////////////
//
//   DateCheck.java
//
//   Description
//
//   Started:           Fri Nov 23 20:47:52 2012
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
import java.util.*;

public class DateCheck {
    public static void main(String[] args) {
        if ( CommandLine.checkArgs(args, 2) ) {
            try {
                int month = Integer.parseInt(args[0]);
                int day = Integer.parseInt(args[1]);

                if ( !isValidMonth(month)  ||  !isValidDay(day, month) ) {
                    throw new IllegalArgumentException("Invalid date");
                } else {
                    System.out.println(dateIsInRange(month, day));
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } else {
            CommandLine.printUsage(DateCheck.class, "month", "day");
        }
    }

    public static boolean dateIsInRange(int month, int day) {
        return (month > 3  &&  month < 6)  ||
            (month == 3  &&  day >= 20)  ||
            (month == 6  &&  day <= 20);
    }
    
//     public static boolean dateIsInRange(int month, int day) {
//         if ( month < 3  ||  month > 6 ) {
//             return false;
//         } else if ( month == 3  &&  day < 20 ) {
//             return false;
//         } else if ( month == 6  &&  day > 20 ) {
//             return false;
//         } else {
//             return true;
//         }
//     }

    private static boolean isValidMonth(int month) {
        return month >= 1  &&  month <= 12;
    }

    private static boolean isValidDay(int day, int month) {
        GregorianCalendar now = new GregorianCalendar();
        now.set(Calendar.MONTH, month-1);

        return day >= 1  &&  day <= now.getActualMaximum(Calendar.DAY_OF_MONTH);
    }
}
