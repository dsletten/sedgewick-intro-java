/*
 * $Id$
 * Copyright (C) 2011 ARIN
 */
package ch01;

import utils.CommandLine;

public class Divides
{
    public static void main(String[] args)
    {
        if ( !CommandLine.enforceArgs( Divides.class.getName(), args, "p", "q" ))
        {
            System.exit( -1 );
        }
        else
        {
            try
            {
                int p = Integer.parseInt( args[0] );
                int q = Integer.parseInt( args[1] );

                System.out.println(divides(p, q));
            }
            catch (Exception e)
            {
                System.err.println("Input should consist of two integers.");
            }
        }
    }

    private static boolean divides(int p, int q)
    {
        return p % q == 0  ||  q % p == 0;
    }
}
