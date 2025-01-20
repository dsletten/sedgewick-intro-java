//////////////////////////////////////////////////////////////////////////////
//
//   Section1_2.java
//
//   Description
//
//   Started:           Fri Apr  5 02:42:44 2013
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
import java.util.Random;

public class Section1_2 {
    //
    //    1.2.14
    //    
    public static boolean divides(int m, int n) {
        if ( m <= 0 ) {
            throw new IllegalArgumentException(m + " must a positive integer.");
        } else if ( n <= 0 ) {
            throw new IllegalArgumentException(n + " must a positive integer.");
        } else {
            return m % n == 0  ||  n % m == 0;
        }
    }

    //
    //    1.2.15
    //
    public static boolean triangle(int a, int b, int c) {
        if ( a <= 0  ||  b <= 0  ||  c <= 0 ) {
            return false;
        } else {
            return a + b > c  &&  a + c > b  &&  b + c > a;
        }
    }

    //
    //    1.2.18
    //
    public static double distance(double x, double y) {
        return Math.sqrt(x*x + y*y);
    }

    //
    //    1.2.19
    //
    private static Random random = new Random();
    public static int randomInt(int a, int b) {
        if ( a == b ) {
            return a;
        } else if ( b < a ) {
            return randomInt(b, a);
        } else {
            return random.nextInt(b - a + 1) + a;
        }
    }

    //
    //    1.2.20
    //
    public static int rollDie() {
        return randomInt(1, 6);
    }

    public static int rollDice() {
        return rollDie() + rollDie();
    }

    public static void main(String[] args) {
        
    }
}
