//////////////////////////////////////////////////////////////////////////////
//
//   CompoundInterest.java
//
//   Description
//
//   Started:           Mon Feb 17 18:41:02 2025
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
//   Notes: Ex. 1.2.21
//
//////////////////////////////////////////////////////////////////////////////
public class CompoundInterest {
    public static void main(String[] args) {
        if ( args.length == 3 ) {
            try {
                double p = convert(args[0]);
                double r = convert(args[1]);
                double t = convert(args[2]);

                if (Double.isNaN(p) || Double.isNaN(r) || Double.isNaN(t)) {
                    throw new IllegalArgumentException("Bad");
                } else {
                    System.out.println(String.format("Amount: %.2f", compound(p, r / 100.0, t)));
                }
            } catch (Exception e) {
                System.err.println("Corrupt");
                System.exit(1);
            }
        }

    }

    private static double convert(String s) throws NumberFormatException {
        double x = Double.parseDouble(s);

        if (x > 0) {
            return x;
        } else {
            return Double.NaN;
        }
    }

    private static double compound(double p, double r, double t) {
        return p * Math.exp(r * t);
    }
}
