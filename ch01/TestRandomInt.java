//////////////////////////////////////////////////////////////////////////////
//
//   TestRandomInt.java
//
//   Description
//
//   Started:           Fri Nov 23 18:49:58 2012
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

public class TestRandomInt {
    @Test
    public void testGetRandomInt() {
        for (int i = 0; i < 10000; i++) {
            int r = RandomInt.getRandomInt(4, 13);
            if ( r < 4  ||  r > 13 ) {
                fail("Random value outside acceptable range: " + r);
            }
        }
    }
}
