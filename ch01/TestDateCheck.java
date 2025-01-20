//////////////////////////////////////////////////////////////////////////////
//
//   TestDateCheck.java
//
//   Description
//
//   Started:           Fri Nov 23 21:08:19 2012
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

public class TestDateCheck {
    @Test
    public void testDateIsInRange() {
        assertTrue(DateCheck.dateIsInRange(3, 20));
        assertTrue(DateCheck.dateIsInRange(4, 20));
        assertTrue(DateCheck.dateIsInRange(6, 20));
        assertFalse(DateCheck.dateIsInRange(3, 19));
        assertFalse(DateCheck.dateIsInRange(6, 21));
        assertFalse(DateCheck.dateIsInRange(2, 21));
        assertFalse(DateCheck.dateIsInRange(9, 21));
    }
}
