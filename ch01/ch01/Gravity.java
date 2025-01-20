/*
 * $Id$
 * Copyright (C) 2011 ARIN
 */
package ch01;

import utils.CommandLine;

public class Gravity {
    public static double G = 9.78033;

    public static void main(String[] args) {
        if ( !CommandLine.enforceArgs(Gravity.class.getSimpleName(), args, "x0", "v0", "t") ) {
            System.exit( -1 );
        } else {
            try {
                double x0 = Double.parseDouble( args[0] );
                double v0 = Double.parseDouble( args[1] );
                double t = Double.parseDouble( args[2] );

                System.out.println(displacement(x0, v0, t));

            } catch (NumberFormatException e) {
                System.err.println("Please enter 3 numbers.");
            }
        }
    }

    private static double displacement(double x0, double v0, double t) {
        return x0 + v0 * t - G * t * t;
    }
}
