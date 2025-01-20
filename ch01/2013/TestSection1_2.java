//////////////////////////////////////////////////////////////////////////////
//
//   TestSection1_2.java
//
//   Description
//
//   Started:           Fri Apr  5 02:54:32 2013
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

public class TestSection1_2 {
    @Test
    public void testDivides() {
        assertTrue(Section1_2.divides(3, 12));
        assertTrue(Section1_2.divides(60, 5));
        
        assertFalse(Section1_2.divides(3, 11));
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testDividesNegative() {
        Section1_2.divides(-3, 9);
    }
    
    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testDividesZero() {
        Section1_2.divides(3, 0);
//         Section1_2.divides(0, 4);
    }

    @Test
    public void testTriangle() {
        assertTrue(Section1_2.triangle(3, 4, 5));
        assertTrue(Section1_2.triangle(5, 12, 13));
        assertTrue(Section1_2.triangle(1, 2, 2));

        assertFalse(Section1_2.triangle(1, 2, 3));
        assertFalse(Section1_2.triangle(-3, -4, -5));
        assertFalse(Section1_2.triangle(0, 0, 0));
    }
    
    @Test
    public void testRandomInt() {
        for (int i = 0; i < 10000; i++) {
            int r = Section1_2.randomInt(4, 13);
            if ( r < 4  ||  r > 13 ) {
                fail("Random value outside acceptable range: " + r);
            }
        }

        for (int i = 0; i < 10000; i++) {
            int r = Section1_2.randomInt(13, 4);
            if ( r < 4  ||  r > 13 ) {
                fail("Random value outside acceptable range: " + r);
            }
        }
    }

}
