//////////////////////////////////////////////////////////////////////////////
//
//   PolarCoordinates2.java
//
//   Description
//
//   Started:           Sun Feb 23 14:07:59 2025
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
public class PolarCoordinates2 {
    private double r;
    private double θ;

    public PolarCoordinates2(double r, double θ) {
        this.r = r;
        this.θ = θ;
    }

    public String toString() {
        return String.format("r: %f θ: %f", r, θ);
    }

    public static PolarCoordinates2 cartesianToPolar(double x, double y) {
        return new PolarCoordinates2(Math.hypot(x, y), Math.atan2(y, x));
    }

    public static void main(String[] args) {
        if ( args.length == 2 ) {
            try {
                double x = Double.parseDouble(args[0]);
                double y = Double.parseDouble(args[1]);

                PolarCoordinates2 polar = PolarCoordinates2.cartesianToPolar(x, y);

                System.out.println(String.format("(%f,%f) -> %s", x, y, polar));
            } catch (Exception e) {
                System.err.println("Corrupt");
                System.exit(1);
            }
        }
    }
}
