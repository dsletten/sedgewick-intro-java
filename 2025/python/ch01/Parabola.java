//////////////////////////////////////////////////////////////////////////////
//
//   Parabola.java
//
//   Description
//
//   Started:           Wed Jan 22 22:21:19 2025
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

public class Parabola {
    private double a;
    private double b;
    private double c;
    private double root1;
    private double root2;

    public Parabola(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;

        calculateRoots();
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public double getC() {
        return c;
    }

    public double firstRoot() {
        return root1;
    }

    public double secondRoot() {
        return root2;
    }

    private void calculateRoots() {
        double discriminant = b * b - 4 * a * c;
        double d = Math.sqrt(discriminant);

        if (b >= 0) {
            root1 = normalize((2 * c) / (-b - d));
            root2 = normalize((-b - d) / (2 * a));
        } else {
            root1 = normalize((-b + d) / (2 * a));
            root2 = normalize((2 * c) / (-b + d));
        }
    }

    private static double normalize(double x) {
        return x == 0 ? Math.abs(x) : x;
    }
}
