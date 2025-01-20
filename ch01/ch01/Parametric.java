/*
 * $Id$
 * Copyright (C) 2011 ARIN
 */
package ch01;

import utils.CommandLine;

public class Parametric {
    public static void main(String[] args) {
        if ( !CommandLine.enforceArgs( Parametric.class.getSimpleName(), args, "t" ) ) {
            System.exit( -1 );
        } else {
            try {
                double t = Double.parseDouble( args[0] );
                System.out.println(Math.sin( 2 * t ) + Math.sin( 3 * t ));
            } catch (NumberFormatException e) {
                System.err.println("Please enter a number.");
            }
        }
    }
}
