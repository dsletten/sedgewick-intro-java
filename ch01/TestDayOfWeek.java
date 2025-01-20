//////////////////////////////////////////////////////////////////////////////
//
//   TestDayOfWeek.java
//
//   Description
//
//   Started:           Wed Nov 28 19:12:56 2012
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

public class TestDayOfWeek {
    @Test
    public void testDayOfWeek() {
        assertEquals(DayOfWeek.getWeekday(DayOfWeek.dayOfWeek(1996, 2, 24)), "Saturday");
        assertEquals(DayOfWeek.getWeekday(DayOfWeek.dayOfWeek(1999, 7, 16)), "Friday");
        assertEquals(DayOfWeek.getWeekday(DayOfWeek.dayOfWeek(2001, 9, 11)), "Tuesday");
        assertEquals(DayOfWeek.getWeekday(DayOfWeek.dayOfWeek(2012, 11, 28)), "Wednesday");
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testInvalidYear() {
        DayOfWeek.dayOfWeek(1400, 1, 1);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testInvalidMonth() {
        DayOfWeek.dayOfWeek(2000, -1, 1);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testInvalidDay() {
        DayOfWeek.dayOfWeek(2000, 3, 40);
        DayOfWeek.dayOfWeek(1999, 2, 29);
    }
}
