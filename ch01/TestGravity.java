//////////////////////////////////////////////////////////////////////////////
//
//   TestGravity.java
//
//   Description
//
//   Started:           Fri Nov 23 20:24:46 2012
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

public class TestGravity {
    @Test
    public void testAltitude() {
        assertEquals(Gravity.altitude(0, Gravity.G, 1), 0, 1e-15);
        assertEquals(Gravity.altitude(20, Gravity.G, 1), 20, 1e-15);
        assertEquals(Gravity.altitude(0, 10, 0.1), 0.9021967, 1e-15);
        assertEquals(Gravity.altitude(0, 20, 0.8), 9.740588800000001, 1e-15);
    }
}
