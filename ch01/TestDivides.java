//////////////////////////////////////////////////////////////////////////////
//
//   TestDivides.java
//
//   Description
//
//   Started:           Fri Nov 23 17:43:35 2012
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

public class TestDivides {
    @Test
    public void testDoesDivide() {
        assertTrue(Divides.doesDivide(2, 8));
        assertTrue(Divides.doesDivide(8, 2));
        assertFalse(Divides.doesDivide(9, 4));
    }
}
