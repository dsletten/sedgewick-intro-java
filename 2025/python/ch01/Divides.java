//////////////////////////////////////////////////////////////////////////////
//
//   Divides.java
//
//   Description
//
//   Started:           Sun Feb  2 15:05:45 2025
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

public class Divides {
    public static void main(String[] args) {
        if (args.length == 2) {
            try {
                long m = Long.parseLong(args[0]);
                long n = Long.parseLong(args[1]);
                
                if (m <= 0  ||  n <= 0) {
                    corrupt();
                } else {
                    System.out.println((m % n == 0 || n % m == 0) ? "True" : "False");
                }
            } catch (NumberFormatException e) {
                corrupt();
            }
        }
    }

    private static void corrupt() {
        System.err.println("Corrupt");
        System.exit(1);
    }
}
