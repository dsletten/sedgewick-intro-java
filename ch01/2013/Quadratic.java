//////////////////////////////////////////////////////////////////////////////
//
//   Quadratic.java
//
//   Description
//
//   Started:           Tue Mar 26 00:28:48 2013
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

public class Quadratic {
    public static void main(String[] args) {
        if ( CommandLine.checkArgs(args, 2) ) {
            try {
                double b = Double.parseDouble(args[0]);
                double c = Double.parseDouble(args[1]);

                quadratic(b, c);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } else {
            CommandLine.printUsage(Quadratic.class, "b", "c");
        }
    }

    public static void quadratic(double b, double c) {
        double discriminant = b * b - 4 * c;
        double realTerm = -b / 2;

        if ( discriminant == 0 ) {
            System.out.println("One real root: " + realTerm);
        } else if ( discriminant > 0 ) {
            double d = Math.sqrt(discriminant);
            System.out.println("Two real roots: " + (realTerm + d/2) + " and " + (realTerm - d/2));
        } else {
            double d = Math.sqrt(-discriminant);
            System.out.println("Two complex roots: " + formatComplex(realTerm, d/2) + " and " + formatComplex(realTerm, -d/2));
        }
    }

    private static String formatComplex(double real, double imaginary) {
        return String.format("%f %s %fi", real, imaginary < 0 ? "-" : "+", imaginary);
    }
}
