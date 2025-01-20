/*
 * $Id$
 * Copyright (C) 2011 ARIN
 */
package ch01;

import utils.CommandLine;

public class Triangle
{
    public static void main(String[] args)
    {
        if ( !CommandLine.enforceArgs( Triangle.class.getName(), args, "a", "b", "c" ))
        {
            System.exit( -1 );
        }
        else
        {
            try
            {
                int a = Integer.parseInt( args[0] );
                int b = Integer.parseInt( args[1] );
                int c = Integer.parseInt( args[2] );

                validateSides(a, b, c);

                System.out.println(isTriangle(a, b, c));
            }
            catch (NumberFormatException e)
            {
                System.err.println("Input should be three positive integers.");
            }
        }
    }

    private static void validateSides(int a, int b, int c)
    {
        if ( a <= 0  ||  b <= 0  ||  c <= 0 )
        {
            throw new NumberFormatException(  );
        }
    }

    private static boolean isTriangle(int a, int b, int c)
    {
        return a < b + c  &&
               b < a + c  &&
               c < a + b;
    }
}
