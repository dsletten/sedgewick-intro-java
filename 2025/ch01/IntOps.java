//////////////////////////////////////////////////////////////////////////////
//
//   IntOps.java
//
//   Description
//
//   Started:           Thu Jan 16 02:19:36 2025
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
import java.math.BigInteger;

public class IntOps {
    public static void main(String[] args) {
        long a = Long.parseLong(args[0]);
        long b = Long.parseLong(args[1]);

        long sum = a + b;
        long difference = a - b;
        long product = a * b;
        long quotient = a / b;
        long remainder = a % b;
        BigInteger power = BigInteger.valueOf(a).pow((int) b);

        System.out.println(String.format("%d + %d = %d", a, b, sum));
        System.out.println(String.format("%d - %d = %d", a, b, difference));
        System.out.println(String.format("%d * %d = %d", a, b, product));
        System.out.println(String.format("%d / %d = %d", a, b, quotient));
        System.out.println(String.format("%d %% %d = %d", a, b, remainder));
        System.out.println(String.format("%d ^ %d = %s", a, b, power.toString()));
    }
}
