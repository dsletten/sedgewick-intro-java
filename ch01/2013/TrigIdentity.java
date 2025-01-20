//////////////////////////////////////////////////////////////////////////////
//
//   TrigIdentity.java
//
//   Description
//
//   Started:           Fri Mar 29 00:12:06 2013
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
public class TrigIdentity {
    public static void main(String[] args) {
        for (double theta = 0; theta <= Math.PI; theta += 0.01) {
            System.out.println(theta + ": " + sumSquares(Math.cos(theta), Math.sin(theta)));
        }
    }

    private static double sumSquares(double x, double y) {
        return square(x) + square(y);
    }

    private static double square(double x) {
        return x * x;
    }
}
