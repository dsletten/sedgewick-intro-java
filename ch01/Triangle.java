//////////////////////////////////////////////////////////////////////////////
//
//   Triangle.java
//
//   Description
//
//   Started:           Fri Nov 23 17:58:02 2012
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

public class Triangle {
    public static void main(String[] args) {
        if ( CommandLine.checkArgs(args, 3) ) {
            try {
                int a = Integer.parseInt(args[0]);
                int b = Integer.parseInt(args[1]);
                int c = Integer.parseInt(args[2]);

                if ( !areAllPositive(a, b, c) ) {
                    throw new IllegalArgumentException("Values must be positive integers.");
                } else {
                    System.out.println(failsTriangleInequality(a, b, c));
                }
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        } else {
            CommandLine.printUsage(Triangle.class, "a", "b", "c");
        }
    }

    public static boolean areAllPositive(int... ints) {
        for (int i : ints) {
            if ( i <= 0 ) {
                return false;
            }
        }

        return true;
    }

    public static boolean failsTriangleInequality(int a, int b, int c) {
        return a >= b + c  ||  b >= a + c  ||  c >= a + b;
    }
}
