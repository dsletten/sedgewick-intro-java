//////////////////////////////////////////////////////////////////////////////
//
//   Ordered.java
//
//   Description
//
//   Started:           Wed Nov 28 16:02:03 2012
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

public class Ordered {
    public static void main(String[] args) {
        if ( CommandLine.checkArgs(args, 3) ) {
            try {
                double x = Double.parseDouble(args[0]);
                double y = Double.parseDouble(args[1]);
                double z = Double.parseDouble(args[2]);

                System.out.println(areOrdered(x, y, z));
            } catch (NumberFormatException e) {
                System.err.println("Invalid input.");
            }
        } else {
            CommandLine.printUsage(Ordered.class, "x", "y", "z");
        }
    }

    public static boolean areOrdered(double x, double y, double z) {
        return _areOrdered(x, y, z) || _areOrdered(z, y, x);
    }

    private static boolean _areOrdered(double x, double y, double z) {
        return x < y && y < z;
    }
}
