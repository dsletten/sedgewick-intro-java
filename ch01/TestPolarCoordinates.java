//////////////////////////////////////////////////////////////////////////////
//
//   TestPolarCoordinates.java
//
//   Description
//
//   Started:           Mon Nov 26 01:14:55 2012
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

public class TestPolarCoordinates {
    @Test
    public void testPolarCoordinates() {
        PolarCoordinates p = new PolarCoordinates(1, 0);
        assertEquals(p.getR(), 1.0);
        assertEquals(p.getTheta(), 0.0);

        p = new PolarCoordinates(0, 1);
        assertEquals(p.getR(), 1.0);
        assertEquals(p.getTheta(), Math.PI/2);

        p = new PolarCoordinates(-1, 0);
        assertEquals(p.getR(), 1.0);
        assertEquals(p.getTheta(), Math.PI);

        p = new PolarCoordinates(0, -1.0);
        assertEquals(p.getR(), 1.0);
        assertEquals(p.getTheta(), -Math.PI/2);
    }
}
