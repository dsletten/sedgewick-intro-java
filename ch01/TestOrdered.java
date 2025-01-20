//////////////////////////////////////////////////////////////////////////////
//
//   TestOrdered.java
//
//   Description
//
//   Started:           Wed Nov 28 16:19:20 2012
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

public class TestOrdered {
    @Test
    public void testAreOrdered() {
        assertTrue(Ordered.areOrdered(1, 2, 3));
        assertTrue(Ordered.areOrdered(-1, -2, -3));
        assertTrue(Ordered.areOrdered(3, 2, 1));
        assertTrue(Ordered.areOrdered(-3, -2, -1));
        assertFalse(Ordered.areOrdered(1, 2, 2));
        assertFalse(Ordered.areOrdered(1, 1, 1));
        assertFalse(Ordered.areOrdered(1, 8, 4));
    }
}
