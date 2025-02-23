//////////////////////////////////////////////////////////////////////////////
//
//   QuadraticParabola.java
//
//   Description
//
//   Started:           Mon Feb 17 18:50:59 2025
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
public class QuadraticParabola {
    public static void main(String[] args) {
        if (args.length == 3) {
            try {
                double a = Double.parseDouble(args[0]);
                double b = Double.parseDouble(args[1]);
                double c = Double.parseDouble(args[2]);

                Parabola p = new Parabola(a, b, c);

                System.out.println(String.format("Root 1: %f", p.firstRoot()));
                System.out.println(String.format("Root 2: %f", p.secondRoot()));
            } catch (Exception e) {
                System.err.println("Suck it!");
                System.exit(1);
            }
        }
    }
}
