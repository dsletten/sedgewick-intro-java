//////////////////////////////////////////////////////////////////////////////
//
//   FloatOps.java
//
//   Description
//
//   Started:           Sun Jan 19 04:07:18 2025
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

public class FloatOps {
    public static void main(String[] args) {
        double a = Double.parseDouble(args[0]);
        double b = Double.parseDouble(args[1]);

        double sum = a + b;
        double difference = a - b;
        double product = a * b;
        double quotient = a / b;
        //        double remainder = a % b;
        double power = Math.pow(a, b);

        System.out.println(String.format("%f + %f = %f", a, b, sum));
        System.out.println(String.format("%f - %f = %f", a, b, difference));
        System.out.println(String.format("%f * %f = %f", a, b, product));
        System.out.println(String.format("%f / %f = %f", a, b, quotient));
        //        System.out.println(String.format("%f %% %f = %f", a, b, remainder));
        //        System.out.println(String.format("%f ^ %f = %f", a, b, power)); // !!!!!!!!
        System.out.println(String.format("%f ^ %f = %g", a, b, power));
    }
}
