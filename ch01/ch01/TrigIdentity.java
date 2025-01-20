/*
 * $Id$
 * Copyright (C) 2011 ARIN
 */
package ch01;

import utils.CommandLine;

public class TrigIdentity
{
    public static void main(String[] args)
    {
        if ( !CommandLine.enforceArgs( TrigIdentity.class.getName(), args, "theta" ) )
        {
            System.exit( -1 );
        }
        else
        {
            double theta = Double.parseDouble( args[0] );
            double sin = Math.sin( theta );
            double cos = Math.cos( theta );
            System.out.println(sin * sin + cos * cos);
        }
    }
}
