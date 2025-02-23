//////////////////////////////////////////////////////////////////////////////
//
//   PolarCoordinates.java
//
//   Description
//
//   Started:           Sat Feb 22 19:02:35 2025
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
//   Notes:  Ex. 1.2.23
//
//////////////////////////////////////////////////////////////////////////////
import java.util.ArrayList;
import java.util.List;

public class PolarCoordinates {
    public static void main(String[] args) {
        if ( args.length == 2 ) {
            try {
                double x = Double.parseDouble(args[0]);
                double y = Double.parseDouble(args[1]);

                List<Double> coordinates = cartesianToPolar(x, y);
                double r = coordinates.get(0);
                double θ = coordinates.get(1);

                System.out.println(String.format("(%f,%f) -> r: %f θ: %f", x, y, r, θ));
            } catch (Exception e) {
                System.err.println("Corrupt");
                System.exit(1);
            }
        }
    }

    private static List<Double> cartesianToPolar(double x, double y) {
        List<Double> coordinates = new ArrayList<Double>();
        coordinates.add(Math.hypot(x, y));
        coordinates.add(Math.atan2(y, x));

        return coordinates;
    }
}
