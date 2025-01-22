//////////////////////////////////////////////////////////////////////////////
//
//   QuadraticSedgewick.java
//
//   Description
//
//   Started:           Tue Jan 21 02:58:58 2025
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
public class QuadraticSedgewick {
    public static void main(String[] args) {
        if (args.length == 2) {
            try {
                double b = Double.parseDouble(args[0]);
                double c = Double.parseDouble(args[1]);

                double discriminant = b * b - 4 * c;
                double d = Math.sqrt(discriminant);

                System.out.println(String.format("Root 1: %f", (-b + d) / 2));
                System.out.println(String.format("Root 2: %f", (-b - d) / 2));
            } catch (Exception e) {
                System.err.println("Suck it!");
                System.exit(1);
            }
        }
    }
}
