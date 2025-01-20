//////////////////////////////////////////////////////////////////////////////
//
//   Divides.java
//
//   Description
//
//   Started:           Fri Nov 23 17:43:17 2012
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

public class Divides {
    public static void main(String[] args) {
        if ( CommandLine.checkArgs(args, 2) ) {
            int x;
            int y;
            try {
                x = Integer.parseInt(args[0]);
                y = Integer.parseInt(args[1]);

                if ( x <= 0  ||  y <= 0 ) {
                    throw new IllegalArgumentException("Positive integers required.");
                } else {
                    System.out.println(doesDivide(x, y));
                }
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }                                                  
        } else {
            CommandLine.printUsage(Divides.class, "x", "y");
        }
    }

    public static boolean doesDivide(int m, int n) {
        return m % n == 0  ||  n % m == 0;
    }
}
