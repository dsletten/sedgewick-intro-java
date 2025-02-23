//////////////////////////////////////////////////////////////////////////////
//
//   WindChill.java
//
//   Description
//
//   Started:           Wed Feb 19 20:17:09 2025
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
//   Notes:  Ex. 1.2.22
//
//////////////////////////////////////////////////////////////////////////////
import java.util.function.DoublePredicate;

public class WindChill {
    public static void main(String[] args) {
        if ( args.length == 2 ) {
            try {
                double t = Double.parseDouble(args[0]);
                double v = Double.parseDouble(args[1]);

                if (isValid(t, (DoublePredicate) temp -> Math.abs(temp) <= 50) &&
                    isValid(v, (DoublePredicate) vel -> 3 <= vel && vel <= 120)) {
                    System.out.println(String.format("Wind chill: %.2f", windChill(t, v)));
                } else {
                    throw new IllegalArgumentException("Bad");
                }
            } catch (Exception e) {
                System.err.println("Corrupt");
                System.exit(1);
            }
        }
    }

    private static boolean isValid(double x, DoublePredicate p) {
        return p.test(x);
    }

    private static double windChill(double t, double v) {
        return 35.74 + 0.6215 * t + (0.4275 * t - 35.75) * Math.pow(v, 0.16);
    }
}
