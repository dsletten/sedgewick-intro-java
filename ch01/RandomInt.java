//////////////////////////////////////////////////////////////////////////////
//
//   RandomInt.java
//
//   Description
//
//   Started:           Fri Nov 23 18:40:23 2012
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
import utils.CommandLine;
import java.util.Random;

public class RandomInt {
    public static void main(String[] args) {
        if ( CommandLine.checkArgs(args, 2) ) {
            try {
                int m = Integer.parseInt(args[0]);
                int n = Integer.parseInt(args[1]);

                if ( m <= 0  ||  n <= 0 ) {
                    throw new IllegalArgumentException("Values must be positive integers.");
                } else {
                    if ( m < n ) {
                        System.out.println(getRandomInt(m, n));
                    } else if ( n < m ) {
                        System.out.println(getRandomInt(n, m));
                    } else {
                        System.out.println(m);
                    }
                }
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        } else {
            CommandLine.printUsage(RandomInt.class, "a", "b");
        }
    }

    private static Random rand = new Random();
    public static int getRandomInt(int m, int n) {
        return m + rand.nextInt(n - m + 1);
    }
}
