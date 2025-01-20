//////////////////////////////////////////////////////////////////////////////
//
//   RollDice.java
//
//   Description
//
//   Started:           Fri Nov 23 19:14:47 2012
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

public class RollDice {
    public static void main(String[] args) {
        System.out.println(getRandomInt(1, 6) + getRandomInt(1, 6));
    }

    private static Random rand = new Random();
    public static int getRandomInt(int m, int n) {
        return m + rand.nextInt(n - m + 1);
    }
}
