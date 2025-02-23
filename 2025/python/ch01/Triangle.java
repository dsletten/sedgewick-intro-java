//////////////////////////////////////////////////////////////////////////////
//
//   Triangle.java
//
//   Description
//
//   Started:           Mon Feb 17 18:45:31 2025
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
import java.util.Collections;
import java.util.stream.DoubleStream;

//
//    https://en.wikipedia.org/wiki/Triangle_inequality
//
//    Explicitly: a + b > c  &  b + c > a  &  a + c > b
//    Equivalently: |a - b| < c < a + b
//    or
//    max(a, b, c) < a + b + c - max(a, b, c) => 2 max(a, b, c) < a + b + c
//    or
//    Area of triangle > 0.
//    

public class Triangle {
    public static void main(String[] args) {
        if (args.length == 3) {
            try {
                double a = Double.parseDouble(args[0]);
                double b = Double.parseDouble(args[1]);
                double c = Double.parseDouble(args[2]);

                System.out.println(isTriangleSedgewick(a, b, c) ? "True" : "False");
                System.out.println(isTriangle(a, b, c) ? "True" : "False");
                System.out.println(isTriangleAbs(a, b, c) ? "True" : "False");
                System.out.println(isTriangleMax(a, b, c) ? "True" : "False");
                System.out.println(isTriangleArea(a, b, c) ? "True" : "False");
            } catch (Exception e) {
                System.err.println("Corrupt");
                System.exit(1);
            }
        }
    }

    private static boolean isTriangle(double a, double b, double c) {
        return a < (b + c) && b < (a + c) && c < (a + b);
    }

    private static boolean isTriangleSedgewick(double a, double b, double c) {
        return !(a >= (b + c) || b >= (a + c) || c >= (a + b));
    }

    private static boolean isTriangleAbs(double a, double b, double c) {
        return Math.abs(a - b) < c && c < a + b;
    }

    private static boolean isTriangleMax(double a, double b, double c) {
        return 2 * Math.max(a, Math.max(b, c)) < a + b + c;
    }

    private static boolean isTriangleArea(double a, double b, double c) {
        return goldbergHeron(a, b, c) > 0;
    }

    private static double goldbergHeron(double a, double b, double c) {
        return heron(DoubleStream.of(a, b, c).boxed().sorted(Collections.reverseOrder()).mapToDouble(Double::doubleValue).toArray());
    }

    //
    //    Assumes a ≥ b ≥ c
    //
    private static double heron(double... sides) {
        double a = sides[0];
        double b = sides[1];
        double c = sides[2];
  
        double product = (a + (b + c)) * (c - (a - b)) * (c + (a - b)) * (a + (b - c));

        if (product < 0) {
            return 0;
        } else {
            return Math.sqrt(product) / 4;
        }
    }
}
