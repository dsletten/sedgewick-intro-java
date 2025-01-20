//////////////////////////////////////////////////////////////////////////////
//
//   TestWindChill.java
//
//   Description
//
//   Started:           Sat Nov 24 20:12:56 2012
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

public class TestWindChill {
    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testInvalidTemperature() {
        WindChill.computeWindChill(-90, 20);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testInvalidWindSpeed() {
        WindChill.computeWindChill(-20, 220);
    }

    @Test
    public void testComputeWindChill() {
        assertEquals(WindChill.computeWindChill(-30, 50), -73.73891019012603, 1e-15);
    }
}
