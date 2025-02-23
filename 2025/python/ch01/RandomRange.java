//////////////////////////////////////////////////////////////////////////////
//
//   RandomRange.java
//
//   Description
//
//   Started:           Sun Feb 16 14:43:45 2025
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
//   Notes: Ex. 1.2.16
//
//////////////////////////////////////////////////////////////////////////////
import java.util.Random;

public class RandomRange {
    public static void main(String[] args) {
        if ( args.length == 2 ) {
            try {
                int a = Integer.parseInt(args[0]);
                int b = Integer.parseInt(args[1]);

                System.out.println(String.format("Random [%d,%d]: %d", a, b, randomRange(a, b)));                
            } catch (Exception e) {
                System.err.println("Corrupt");
                System.exit(1);
            }
        }
    }

    private static int randomRange(int a, int b) {
        if (a > b) {
            return randomRange(b, a);
        } else {
            Random r = new Random();

            return r.nextInt(b - a + 1) + a;
        }
    }
}
