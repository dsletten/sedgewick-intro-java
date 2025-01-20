//////////////////////////////////////////////////////////////////////////////
//
//   Loan.java
//
//   Description
//
//   Started:           Sat Nov 24 19:12:31 2012
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

public class Loan {
    public static void main(String[] args) {
        if ( CommandLine.checkArgs(args, 3) ) {
            try {
                int t = Integer.parseInt(args[0]);
                double P = Double.parseDouble(args[1]);
                double r = Double.parseDouble(args[2]);

                if ( t <= 0  ||  P <= 0  ||  r <= 0 ) {
                    throw new IllegalArgumentException("Invalid input");
                } else {
                    double total = computeLoan(t, P, r);
                    System.out.println(String.format("Total payment on %f principal: %.2f", P, total));
                    System.out.println(String.format("Monthly payment: %.2f", total / t / 12));
                }
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        } else {
            CommandLine.printUsage(Loan.class, "t", "P", "r");
        }
    }

    public static double computeLoan(int t, double P, double r) {
        return P * Math.exp(r * t);
    }
}
