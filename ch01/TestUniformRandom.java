//////////////////////////////////////////////////////////////////////////////
//
//   TestUniformRandom.java
//
//   Description
//
//   Started:           Sat Dec  1 16:41:13 2012
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

import java.util.*;

public class TestUniformRandom {
    @Test
    public void testAverage() {
        assertEquals(UniformRandom.average(Arrays.asList(1, 2, 3, 4, 5)), 3.0);
        assertEquals(UniformRandom.average(Arrays.asList(5, 4, 3, 2, 1)), 3.0);
    }

    @Test
    public void testMin() {
        assertEquals((int) UniformRandom.min(Arrays.asList(1, 2, 3, 4, 5)), (int) 1);
        assertEquals((int) UniformRandom.min(Arrays.asList(5, 4, 3, 2, 1)), (int) 1);
    }
    @Test
    public void testMax() {
        assertEquals((int) UniformRandom.max(Arrays.asList(1, 2, 3, 4, 5)), (int) 5);
        assertEquals((int) UniformRandom.max(Arrays.asList(5, 4, 3, 2, 1)), (int) 5);
    }
}
