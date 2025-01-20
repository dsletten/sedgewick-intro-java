//////////////////////////////////////////////////////////////////////////////
//
//   PolarCoordinates.java
//
//   Description
//
//   Started:           Sat Nov 24 20:18:04 2012
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
public class PolarCoordinates {
    private double r;
    private double theta;
    
    public PolarCoordinates(double x, double y) {
        r = Math.hypot(x, y);
        theta = Math.atan2(y, x);
    }

    public double getR() {
        return r;
    }

    public double getTheta() {
        return theta;
    }

    public String toString() {
        return "[" + r + ", " + theta + "]";
    }
}
