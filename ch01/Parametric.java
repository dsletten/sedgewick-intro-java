//////////////////////////////////////////////////////////////////////////////
//
//   Parametric.java
//
//   Description
//
//   Started:           Fri Nov 23 19:17:46 2012
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

public class Parametric {
    public static void main(String[] args) {
        if ( CommandLine.checkArgs(args, 1) ) {
            try {
                double t = Double.parseDouble(args[0]);

                System.out.println(parameterized(t));
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        } else {
            CommandLine.printUsage(Parametric.class, "t");
        }
    }

    public static double parameterized(double t) {
        return Math.sin(2 * t) + Math.sin(3 * t);
    }
}
