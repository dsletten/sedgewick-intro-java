//////////////////////////////////////////////////////////////////////////////
//
//   TestLoan.java
//
//   Description
//
//   Started:           Sat Nov 24 19:46:42 2012
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

public class TestLoan {
    @Test
    public void testComputeLoan() {
        assertEquals(Loan.computeLoan(12, 12000, 0), 12000, 1e-15);
        assertEquals(Loan.computeLoan(12, 12000, 0.08), 31340.357681, 1e-6);
        assertEquals(Loan.computeLoan(5, 12000, 0.05), 15408.305000252896, 1e-15);
    }
}
