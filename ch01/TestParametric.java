//////////////////////////////////////////////////////////////////////////////
//
//   TestParametric.java
//
//   Description
//
//   Started:           Fri Nov 23 19:48:11 2012
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

public class TestParametric {
    @Test
    public void testParameterized() {
        assertEquals(Parametric.parameterized(Math.PI), 0, 1e-15);
        assertEquals(Parametric.parameterized(Math.PI/2), -1, 1e-15);
    }
}
