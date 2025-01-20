//////////////////////////////////////////////////////////////////////////////
//
//   UseThree.java
//
//   Description
//
//   Started:           Wed Nov 14 16:19:06 2012
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
//   javac -cp .:/home/slytobias/java/packages/ UseThree.java
//   java -cp .:/home/slytobias/java/packages/ UseThree Alice Bob Carol
//
//////////////////////////////////////////////////////////////////////////////
import java.util.*;
import utils.*;

public class UseThree {
    public static void main(String[] args) {
        if ( CommandLine.checkArgs(args, 3) ) {
            System.out.println(String.format("Hi %s.", reverseArgs(args)));
        } else {
            CommandLine.printUsage(UseThree.class, "name1", "name2", "name3");
        }
    }

    public static String reverseArgs(String... args) {
        List<String> l = Arrays.asList(args);
        Collections.reverse(l);
        
        return StringUtils.commifyList(l);
    }
}
