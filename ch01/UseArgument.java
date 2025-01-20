//////////////////////////////////////////////////////////////////////////////
//
//   UseArgument.java
//
//   Description
//
//   Started:           Wed Nov 14 16:04:04 2012
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
import utils.CommandLine;

public class UseArgument {
    public static void main(String[] args) {
        if ( CommandLine.checkArgs(args, "name") ) {
            System.out.println(String.format("Hi, %s. How are you?", args[0]));
        } else {
            CommandLine.printUsage(UseArgument.class, "name");
        }
    }
}
