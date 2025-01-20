//////////////////////////////////////////////////////////////////////////////
//
//   Gravity.java
//
//   Description
//
//   Started:           Fri Nov 23 20:17:37 2012
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

public class Gravity {
    public static final double G = 9.78033;

    public static void main(String[] args) {
        if ( CommandLine.checkArgs(args, 3) ) {
            try {
                double x0 = Double.parseDouble(args[0]);
                double v0 = Double.parseDouble(args[1]);
                double t = Double.parseDouble(args[2]);

                System.out.println(altitude(x0, v0, t));
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        } else {
            CommandLine.printUsage(Gravity.class, "x0", "v0", "t");
        }
    }

    public static double altitude(double x0, double v0, double t) {
        return -G * t * t + v0 * t + x0;
    }
}
