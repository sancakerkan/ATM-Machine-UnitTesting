import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TableBasedTests {
    private Account account;

    @BeforeEach
    public void setUp() {
        account = new Account(12345, 1234, 1000.0, 500.0);
    }

    //----------------------------------------------
    // Table Based Tests for getTransferInput method
    //----------------------------------------------

    // Case 1: Checkings, Transfer, Positive amount
    @Test
    public void testCheckingsTransferPositiveAmount() {
        account.getTransferInput("Checkings", 1, 200.0);
        assertEquals(800.0, account.getCheckingBalance()); // 1000 - 200
        assertEquals(700.0, account.getSavingBalance());   // 500 + 200
    }

    // Case 2: Checkings, Transfer, Negative amount
    @Test
    public void testCheckingsTransferNegativeAmount() {
        account.getTransferInput("Checkings", 1, -200.0);
        assertEquals(1000.0, account.getCheckingBalance()); // No change
        assertEquals(500.0, account.getSavingBalance());   // No change
    }

    // Case 3: Checkings, Exit, Positive amount
    @Test
    public void testCheckingsExitPositiveAmount() {
        account.getTransferInput("Checkings", 2, 200.0);
        assertEquals(1000.0, account.getCheckingBalance()); // No change
        assertEquals(500.0, account.getSavingBalance());   // No change
    }

    // Case 4: Checkings, Exit, Negative amount
    @Test
    public void testCheckingsExitNegativeAmount() {
        account.getTransferInput("Checkings", 2, -200.0);
        assertEquals(1000.0, account.getCheckingBalance()); // No change
        assertEquals(500.0, account.getSavingBalance());   // No change
    }

    // Case 5: Savings, Transfer, Positive amount
    @Test
    public void testSavingsTransferPositiveAmount() {
        account.getTransferInput("Savings", 1, 200.0);
        assertEquals(1200.0, account.getCheckingBalance()); // 1000 + 200
        assertEquals(300.0, account.getSavingBalance());   // 500 - 200
    }

    // Case 6: Savings, Transfer, Negative amount
    @Test
    public void testSavingsTransferNegativeAmount() {
        account.getTransferInput("Savings", 1, -200.0);
        assertEquals(1000.0, account.getCheckingBalance()); // No change
        assertEquals(500.0, account.getSavingBalance());   // No change
    }

    // Case 7: Savings, Exit, Positive amount
    @Test
    public void testSavingsExitPositiveAmount() {
        account.getTransferInput("Savings", 2, 200.0);
        assertEquals(1000.0, account.getCheckingBalance()); // No change
        assertEquals(500.0, account.getSavingBalance());   // No change
    }

    // Case 8: Savings, Exit, Negative amount
    @Test
    public void testSavingsExitNegativeAmount() {
        account.getTransferInput("Savings", 2, -200.0);
        assertEquals(1000.0, account.getCheckingBalance()); // No change
        assertEquals(500.0, account.getSavingBalance());   // No change
    }

    //----------------------------------------------
    // Table Based Tests for calcCheckingWithdraw method
    //----------------------------------------------

    // Case 1: Withdraw amount is less than current balance
    @Test
    public void testWithdrawAmountLessThanBalance() {
        account.calcCheckingWithdraw(200.0);
        assertEquals(800.0, account.getCheckingBalance()); // 1000 - 200
    }

    // Case 2: Withdraw amount is equal to current balance
    @Test
    public void testWithdrawAmountEqualToBalance() {
        account.calcCheckingWithdraw(1000.0);
        assertEquals(0.0, account.getCheckingBalance()); // 1000 - 1000
    }

    // Case 3: Withdraw amount is greater than current balance
    @Test
    public void testWithdrawAmountGreaterThanBalance() {
        account.calcCheckingWithdraw(1200.0);
        assertEquals(1000.0, account.getCheckingBalance()); // No change
    }

    // Case 4: Withdraw amount is negative
    @Test
    public void testWithdrawNegativeAmount() {
        account.calcCheckingWithdraw(-100.0);
        assertEquals(1000.0, account.getCheckingBalance()); // No change
    }
}
