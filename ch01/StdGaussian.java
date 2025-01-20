//////////////////////////////////////////////////////////////////////////////
//
//   StdGaussian.java
//
//   Description
//
//   Started:           Mon Nov 26 01:30:14 2012
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
//   Notes: How to test this?
//
//////////////////////////////////////////////////////////////////////////////
public class StdGaussian {
    public static void main(String[] args) {
        System.out.println(generateGaussian());
    }

    public static double generateGaussian() {
        double u = Math.random();
        double v = Math.random();

        return Math.sin(2 * Math.PI * v) * Math.sqrt(-2 * Math.log(u));
    }
}
