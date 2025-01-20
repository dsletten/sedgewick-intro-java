//////////////////////////////////////////////////////////////////////////////
//
//   TerminalIO.java
//
//   Description
//
//   Started:           Tue Apr 26 13:56:32 2005
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
package utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TerminalIO {
    public static final boolean ALLOW_EMPTY = true;
    public static final boolean NO_EMPTY = false;
    
    private static final BufferedReader IN =
        new BufferedReader(new InputStreamReader(System.in));

    private TerminalIO() {};
    
    public static void prompt(String prompt) {
        System.out.print(prompt);
        System.out.flush();
    }
    
    public static String readLine() {
        try {
            return IN.readLine();
        } catch (IOException e) {
            System.err.println(e.getMessage());
            return readLine();
        }
    }
	
    public static String readLine(String prompt) {
        prompt(prompt);
        return readLine();
    }

    public static String readLine(String prompt, boolean emptyStringAllowed) {
        return readLine(prompt, emptyStringAllowed, "");
    }

    public static String readLine(String prompt, boolean emptyStringAllowed,
                                  String errorMsg) {
        String s = readLine(prompt);

        if ( emptyStringAllowed == NO_EMPTY  &&  s.length() == 0 ) {
            // 	if ( !emptyStringAllowed  &&  s.length() == 0 ) {
            if ( !errorMsg.equals("") ) {
                System.err.println(errorMsg);
            }
            return readLine(prompt, emptyStringAllowed, errorMsg);
        } else {
            return s;
        }
    }

    public static double readDouble(String prompt) {
    	return readDouble(prompt, "");
    }
    
    public static double readDouble(String prompt, String errorMsg) {
        String s = readLine(prompt).trim();

        try {
            return Double.parseDouble(s);
        } catch (NumberFormatException e) {
            if ( !errorMsg.equals("") ) {
                System.err.println(errorMsg);
            }
            return readDouble(prompt);
        }
    }
    
    public static double readDouble(String prompt, double min) {
    	return readDouble(prompt, min, min, "");
    }
    
    public static double readDouble(String prompt, double min, double max) {
    	return readDouble(prompt, min, max, "");
    }
    
    public static double readDouble(String prompt, double min, double max, String errorMsg) {
        double d = readDouble(prompt, errorMsg);

        if ( min == max ) {
        	if ( d >= min ) {
        		return d;
        	} else {
        		printMinError(min);
        		return readDouble(prompt, min, max, errorMsg);
        	}
        } else if ( d >= min  &&  d <= max ) {
            return d;
        } else {
        	printRangeError(min, max);
            return readDouble(prompt, min, max, errorMsg);
        }
    }
    
    public static int readInt(String prompt) {
        return readInt(prompt, "");
    }
    
    public static int readInt(String prompt, String errorMsg) {
        String s = readLine(prompt).trim();

        try {
            return Integer.parseInt(s);
        } catch (NumberFormatException e) {
            if ( !errorMsg.equals("") ) {
                System.err.println(errorMsg);
            }
            return readInt(prompt);
        }
    }
    
    public static int readInt(String prompt, int min) {
    	return readInt(prompt, min, min, "");
    }

    public static int readInt(String prompt, int min, int max) {
        return readInt(prompt, min, max, "");
    }
    
    public static int readInt(String prompt, int min, int max, String errorMsg) {
        int n = readInt(prompt, errorMsg);

        if ( min == max ) {
        	if ( n >= min ) {
        		return n;
        	} else {
        		printMinError(min);
        		return readInt(prompt, min, max, errorMsg);
        	}
        } else if ( n >= min  &&  n <= max ) {
            return n;
        } else {
        	printRangeError(min, max);
            return readInt(prompt, min, max, errorMsg);
        }
    }

    private static void printMinError(Number min) {
		System.out.println("Number must be at least " + min);
    }

    private static void printRangeError(Number min, Number max) {
        System.out.println("Number must be between " + min + " and " + max);
    }
    
    public static boolean yesOrNo(String prompt) {
        return _yesOrNo(prompt, "yes", "no", true);
    }
    
    public static boolean yOrN(String prompt) {
        return _yesOrNo(prompt, "y", "n", false);
    }
    
    private static boolean _yesOrNo(String prompt, String yes, String no,
                                    boolean strict) {
        String response =
            readLine(prompt + " (" + yes + " or " + no + ") ").trim();

        if ( response.equalsIgnoreCase(yes)  ||
             (!strict && response.toLowerCase().startsWith(yes)) ) {
            return true;
        } else if ( response.equalsIgnoreCase(no)  ||
                    (!strict && response.toLowerCase().startsWith(no)) ) {
            return false;
        } else {
            System.err.println("Please type \"" + yes + "\" for yes or \"" +
                               no + "\" for no.");
            return _yesOrNo(prompt, yes, no, strict);
        }
    }

    public static void main(String[] args) {
        prompt("Show me what ya got: ");
        System.out.println(readLine());

        System.out.println(readLine("Give me something to work with: ", NO_EMPTY));

        System.out.println(readLine("Enter some pung: "));
        System.out.println(readDouble("Enter a number: "));

        System.out.println(readInt("Enter a non-negative number: ", 0));
        System.out.println(readDouble("Enter a non-negative number: ", 0));
        
        System.out.println(readInt("Enter a number between 1 and 6: ", 1, 6));
        System.out.println(readDouble("Enter a number between 1 and 6: ", 1, 6));
        
        System.out.println(yesOrNo("Is this not pung?"));
        System.out.println(yOrN("Is this not pung?"));
    }
}
