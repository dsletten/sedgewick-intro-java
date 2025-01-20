/*
 */
package ch01;

import utils.StringUtils;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ReverseArguments
{
    public static void main( String[] args )
    {
        List<String> elts = Arrays.asList( args );
        Collections.reverse( elts );

        String[] reverseArgs = new String[args.length];
        System.out.println( StringUtils.commify(elts.toArray(reverseArgs)) );
    }
}
