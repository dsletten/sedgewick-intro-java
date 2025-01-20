//////////////////////////////////////////////////////////////////////////////
//
//   ToPolar.java
//
//   Description
//
//   Started:           Mon Nov 26 00:28:36 2012
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

public class ToPolar {
    public static void main(String[] args) {
        if ( CommandLine.checkArgs(args, 2) ) {
            try {
                double x = Double.parseDouble(args[0]);
                double y = Double.parseDouble(args[1]);

                System.out.println(new PolarCoordinates(x, y));
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        } else {
            CommandLine.printUsage(ToPolar.class, "x", "y");
        }
    }
}
