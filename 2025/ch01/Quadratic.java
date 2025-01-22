//////////////////////////////////////////////////////////////////////////////
//
//   Quadratic.java
//
//   Description
//
//   Started:           Tue Jan 21 02:59:09 2025
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
import java.util.List;
import java.util.ArrayList;

public class Quadratic {
    public static void main(String[] args) {
        if (args.length == 3) {
            try {
                double a = Double.parseDouble(args[0]);
                double b = Double.parseDouble(args[1]);
                double c = Double.parseDouble(args[2]);

                //                List<Double> roots = quadratic(a, b, c);
                List<Double> roots = goldbergQuadratic(a, b, c);

                System.out.println(String.format("Root 1: %f", roots.get(0)));
                System.out.println(String.format("Root 2: %f", roots.get(1)));
            } catch (Exception e) {
                System.err.println("Suck it!");
                System.exit(1);
            }
        }
    }

    //  Goldberg -- What Every Computer Scientist Should Know... pg. 162
    private static List<Double> goldbergQuadratic(double a, double b, double c) {
        List<Double> roots = new ArrayList<Double>();
        double discriminant = b * b - 4 * a * c;
        double d = Math.sqrt(discriminant);

        if (b >= 0) {
            roots.add((2 * c) / (-b - d));
            roots.add((-b - d) / (2 * a));
        } else {
            roots.add((-b + d) / (2 * a));
            roots.add((2 * c) / (-b + d));
        }

        return roots;
    }

    private static List<Double> quadratic(double a, double b, double c) {
        List<Double> roots = new ArrayList<Double>();
        double discriminant = b * b - 4 * a * c;
        double d = Math.sqrt(discriminant);

        roots.add((-b + d) / (2 * a));
        roots.add((-b - d) / (2 * a));

        return roots;
    }
}
