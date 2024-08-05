import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TableBasedTests {

    private Account account;

    @BeforeEach
    public void setUp() {
        account = new Account(12345, 6789, 1000.00, 2000.00);
    }

    // Test Case 1: Withdrawal of $100 from $1000 balance should result in $900 balance
    @Test
    public void testCalcCheckingWithdraw_TC1() {
        account.calcCheckingWithdraw(100.00);
        assertEquals(900.00, account.getCheckingBalance(), "Checking balance should be $900.00 after withdrawal of $100.00");
    }

    // Test Case 2: Withdrawal of $0 from $1000 balance should result in no change
    @Test
    public void testCalcCheckingWithdraw_TC2() {
        account.calcCheckingWithdraw(0.00);
        assertEquals(1000.00, account.getCheckingBalance(), "Checking balance should remain $1000.00 after withdrawal of $0.00");
    }

    // Test Case 3: Withdrawal of $1100 from $1000 balance should not be allowed (assuming no overdraft)
    @Test
    public void testCalcCheckingWithdraw_TC3() {
        account.calcCheckingWithdraw(1100.00);
        assertEquals(1000.00, account.getCheckingBalance(), "Checking balance should remain $1000.00 if withdrawal exceeds balance");
    }

    // Test Case 4: Withdrawal of a negative amount should not be allowed
    @Test
    public void testCalcCheckingWithdraw_TC4() {
        account.calcCheckingWithdraw(-100.00);
        assertEquals(1000.00, account.getCheckingBalance(), "Checking balance should remain $1000.00 if a negative withdrawal is attempted");
    }
}
