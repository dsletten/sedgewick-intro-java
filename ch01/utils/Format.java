//////////////////////////////////////////////////////////////////////////////
//
//   Format.java
//
//   Description
//
//   Started:           Thu Sep 22 23:26:31 2005
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
//   Notes: All methods return a string just as wide as the width argument in
//          any case. If the input string is wider than this, then a smaller
//          substring will be returned.
//
//////////////////////////////////////////////////////////////////////////////
package utils;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Format {
	public static final int LEFT = 0;
	public static final int CENTER = 1;
	public static final int RIGHT = 2;

	//
	//    Similar to Ruby's String#center(), String#ljust(), String#rjust(),
	//    but see note above.
	//    
	public static String center(String s, int width) {
		return formatField(s, width, CENTER, ' ');
	}

	public static String ljust(String s, int width) {
		return formatField(s, width, LEFT, ' ');
	}

	public static String rjust(String s, int width) {
		return formatField(s, width, RIGHT, ' ');
	}

	public static String formatField(String s, int width) {
		return formatField(s, width, RIGHT, ' ');
	}

	public static String formatField(String s, int width, int align) {
		return formatField(s, width, align, ' ');
	}

	public static String formatField(String s, int width, int align, char ch) {
		int stringWidth = s.length();
		if ( stringWidth > width ) {
			return s.substring(0, width);
		}

		if ( align == LEFT ) {
			char[] chars = new char[width-stringWidth];
			Arrays.fill(chars, ch);
			return s + new String(chars);
		} else if ( align == CENTER ) {
			int left = (width-stringWidth)/2;
			int right = width - (stringWidth+left);
			char[] chars1 = new char[left];
			char[] chars2 = new char[right];
			Arrays.fill(chars1, ch);
			Arrays.fill(chars2, ch);
			return new String(chars1) + s + new String(chars2);
		} else if ( align == RIGHT ) {
			char[] chars = new char[width-stringWidth];
			Arrays.fill(chars, ch);
			return new String(chars) + s;
		} else {
			throw new IllegalArgumentException("Invalid alignment specifier.");
		}
	}

	//
	//    Squeeze consecutive runs of given characters into single instances.
	//    See Ruby's String#squeeze
	//    
	private static final String SQUEEZE_ALL = "all";
	public static String squeeze(String s) {
		return squeeze(s, SQUEEZE_ALL);
	}

	public static String squeeze(String s, char ch) {
		return squeeze(s, String.valueOf(ch));
	}

	public static String squeeze(String s, String charClass) {
		Pattern p;
		if ( charClass == SQUEEZE_ALL ) {
			p = Pattern.compile("(.)(\\1+)");
		} else {
			p = Pattern.compile("([" + charClass + "])(\\1+)");
		}

		Matcher m = p.matcher(s);
		StringBuffer buffer = new StringBuffer();

		while ( m.find() ) {
			m.appendReplacement(buffer, m.group(1));
		}

		m.appendTail(buffer);

		return buffer.toString();
	}

	public static String pluralize(int n, String singular, String plural) {
		if ( n == 1 ) {
			return singular;
		} else {
			return plural;
		}
	}

    public static String format(String controlString, Object ... arguments) {
        int directivePosition = controlString.indexOf( '~' );
        int argIndex = 0;
        int literalIndex = 0;
        StringBuilder result = new StringBuilder(  );

        while ( directivePosition > 0 ) {
            ProcessResult pr = processDirective(controlString, directivePosition, argIndex, arguments);

            result = outputWithReplacement(result, controlString, literalIndex, directivePosition, pr.replacement);

            literalIndex = directivePosition + pr.advance + 2;
            directivePosition = controlString.indexOf( '~', literalIndex );

            if ( pr.consume ) {
                argIndex++;
            }
        }

        return result.append(controlString.substring(literalIndex)).toString();
    }

    private static class ProcessResult {
        String replacement;
        int advance;
        boolean consume;

        ProcessResult(String replacement, int advance, boolean consume) {
            this.replacement = replacement;
            this.advance = advance;
            this.consume = consume;
        }
    }

    private static ProcessResult processDirective(String controlString,
                                                  int directivePosition,
                                                  int argIndex,
                                                  Object[] arguments) {
        return processDirective( controlString, directivePosition, argIndex, arguments, null );
    }

    private static ProcessResult processDirective(String controlString,
                                                  int directivePosition,
                                                  int argIndex,
                                                  Object[] arguments,
                                                  Character modifier) {
        Object defaultArg = arguments[argIndex];
        boolean consume = true;
        String replacement = "";
        ProcessResult tempResult;

        switch ( Character.toUpperCase( controlString.charAt( directivePosition + 1 ) ) ) {
            case 'A':
                replacement = defaultArg.toString();
                break;
            case 'R':
                replacement = cardinal(defaultArg);
                break;
        }

        return new ProcessResult(replacement, modifier == null ? 0 : 1, consume);
    }

    private static StringBuilder outputWithReplacement(StringBuilder result, String controlString, int before,
                                                       int directivePosition, String replacement) {
        return result.append( controlString.substring( before, directivePosition )).append( replacement );
    }

    private static String cardinal(Object n) {
        if ( n instanceof Long ) {
            return cardinal( (Long) n );
        } else if ( n instanceof BigInteger ) {
            return cardinal( (BigInteger) n);
        } else {
            throw new IllegalArgumentException( "Not an integer." );
        }
    }

    private static String cardinal(Long n) {
        return "long";
    }

    private static String cardinal(BigInteger n) {
        return "BigInteger";
    }

	public static void main(String[] args) {
		System.out.println("|" + center("pung", 20) + "|");
		System.out.println("|" + ljust("pung", 20) + "|");
		System.out.println("|" + rjust("pung", 20) + "|");

		System.out.println("|" + formatField("pung", 20, LEFT) + "|");
		System.out.println("|" + formatField("pung", 20, CENTER) + "|");
		System.out.println("|" + formatField("pung", 20, RIGHT) + "|");

		System.out.println("|" + formatField("1234", 20, LEFT) + "|");
		System.out.println("|" + formatField("1234", 20, CENTER) + "|");
		System.out.println("|" + formatField("1234", 20, RIGHT, '0') + "|");

		System.out.println(squeeze("Is  this  not      pung?", ' '));
		System.out.println(squeeze("Is  this  not      pung?", " "));
		System.out.println(squeeze("Sexxy is better..."));
		System.out.println(squeeze("Sexxy is better...", new String("all")));
		System.out.println(squeeze("Sexxy is better...", "x."));
		System.out.println(squeeze("Doggone digger, you're outta here!!! YESS!", "a-z"));

        System.out.println(format( "Is this not ~A?", "pung" ));
        System.out.println(format( "Is ~A not ~A?", "this", "pung" ));
        System.out.println(format( "The number is: ~R", new Long(8) ));
        System.out.println(format( "The number is: ~R", new BigInteger( "8" ) ));
	}
}
