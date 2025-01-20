/*
 * $Id$
 * Copyright (C) 2011 ARIN
 */
package ch01;

import utils.CommandLine;

public class DateCheck
{
    public static void main(String[] args) {
        if ( !CommandLine.enforceArgs(DateCheck.class.getSimpleName(), args, "m", "d") ) {
            System.exit( -1 );
        } else {
            try {
                int month = Integer.parseInt( args[0] );
                int day = Integer.parseInt( args[1] );

                if ( !isValidMonth( month )  ||  !isValidDay( month, day ) ) {
                    reportInvalid( month,  day);
                } else {
                    System.out.println(checkDate(month, day));
                }
            } catch (NumberFormatException e) {
                reportInvalid( args[0], args[1] );
            }
        }
    }

    private static boolean isValidMonth(int month) {
        return month >= 1 && month <= 12;
    }

    private static boolean isValidDay(int month, int day) {
        if ( month < 1 ) {
            return false;
        } else {
            switch (month) {
                case 4:
                case 6:
                case 9:
                case 11:
                    return day <= 30;
                case 2:
                    return day <= 29;
                default:
                    return day <= 31;
            }
        }
    }

    private static boolean checkDate(int month, int day) {
        switch ( month ) {
            case 3:
                return day >= 20;
            case 4:
            case 5:
                return true;
            case 6:
                return day <= 20;
            default:
                return false;
        }
    }

//    private static boolean checkDate(int month, int day) {
//        if ( month < 3  ||  month > 6 ) {
//            return false;
//        } else if ( month == 3 ) {
//            return day >= 20;
//        } else if ( month == 6 ) {
//            return day <= 20;
//        } else {
//            return true;
//        }
//    }

    private static void reportInvalid(Object m, Object d) {
        System.err.println("The values " + m + " and " + d + " do not represent a valid month and day.");
    }
}
