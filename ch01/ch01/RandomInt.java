/*
 * $Id$
 * Copyright (C) 2011 ARIN
 */
package ch01;

import utils.CommandLine;

public class RandomInt {
    public static void main(String[] args) {
        if ( !CommandLine.enforceArgs( RandomInt.class.getSimpleName(), args, "a", "b" ) ) {
            System.exit( -1 );
        } else {
            try {
                int a = Integer.parseInt( args[0] );
                int b = Integer.parseInt( args[1] );

                if ( !validate(a, b) ) {
                    throw new IllegalArgumentException("a should be less than b."  );
                }

                System.out.println(getRandom(a, b));
            } catch (NumberFormatException e) {
                System.err.println("Please enter two integers.");
            } catch (IllegalArgumentException e) {
                System.err.println(e.getMessage());
            }
        }
    }

    private static int getRandom(int a, int b) {
        return (int) (a + (b - a + 1) * Math.random());
    }

    private static boolean validate(int a, int b) {
        return a < b;
    }
}
