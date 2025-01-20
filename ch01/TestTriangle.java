//////////////////////////////////////////////////////////////////////////////
//
//   TestTriangle.java
//
//   Description
//
//   Started:           Fri Nov 23 17:58:10 2012
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

public class TestTriangle {
    @Test
    public void testAreAllPositive() {
        assertTrue(Triangle.areAllPositive(1, 2, 3));
        assertFalse(Triangle.areAllPositive(1, 2, 0));
        assertFalse(Triangle.areAllPositive(1, -2, 8));
    }

    @Test
    public void testFailsTriangleInequality() {
        assertTrue(Triangle.failsTriangleInequality(2, 2, 4));
        assertFalse(Triangle.failsTriangleInequality(3, 4, 5));
        assertFalse(Triangle.failsTriangleInequality(13, 12, 5));
        assertFalse(Triangle.failsTriangleInequality(2, 3, 4));
    }
}
