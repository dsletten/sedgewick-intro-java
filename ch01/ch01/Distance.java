/*
 * $Id$
 * Copyright (C) 2011 ARIN
 */
package ch01;

import utils.CommandLine;

public class Distance
{
    public static void main(String[] args)
    {
        if ( !CommandLine.enforceArgs( Distance.class.getName(), args, "x", "y" ))
        {
            System.exit( -1 );
        }
        else
        {
            try
            {
                double x = Double.parseDouble( args[0] );
                double y = Double.parseDouble( args[1] );

                System.out.println(distance(x, y));
            }
            catch (NumberFormatException e)
            {
                System.err.println("Invalid input.");
            }
        }
    }

    private static double distance(double x, double y)
    {
        return distance( x, y, 0, 0 );
    }

    private static double distance(double x0, double y0, double x1, double y1)
    {
        return Math.hypot( x0 - x1, y0 - y1 );
    }
}
