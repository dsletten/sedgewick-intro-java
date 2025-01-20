//////////////////////////////////////////////////////////////////////////////
//
//   UseArgument.java
//
//   Description
//
//   Started:           Fri Feb 25 10:47:06 2011
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
public class UseArgument {
    public static void main(String[] args) {
        if ( args.length > 0 ) {
            System.out.println("Hi " + join(reverse(args)));
        } else {
            System.out.println("Usage: java UseArgument <name-1> ... <name-n>");
        }
    }

    private static String[] reverse(String[] a) {
        String[] result = new String[a.length];

        for (int i = 0, j = a.length-1; i < a.length; i++, j--) {
            result[j] = a[i];
        }

        return result;
    }

    private static String join(String[] a) {
        switch ( a.length ) {
        case 0:
            return "";
        case 1:
            return a[0];
        case 2:
            return a[0] + " and " + a[1];
        default:
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < a.length-1; i++) {
                sb.append(a[i]);
                sb.append(", ");
            }
            sb.append("and ");
            sb.append(a[a.length-1]);
            return sb.toString();
        }
    }
}
