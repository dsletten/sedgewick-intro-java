//////////////////////////////////////////////////////////////////////////////
//
//   TestUseThree.java
//
//   Description
//
//   Started:           Wed Nov 21 19:10:55 2012
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
import static org.testng.Assert.*;
import org.testng.annotations.Test;

public class TestUseThree {
    @Test
    public void testReverseArgs() {
        assertEquals(UseThree.reverseArgs("pung", "foo"), "foo and pung");
        assertEquals(UseThree.reverseArgs("pung", "foo", "bar"), "bar, foo, and pung");
    }
}
