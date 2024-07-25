import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Test class for the Account class.
 * Tests the functionalities of setting/getting customer number, PIN, balance operations, and transfers.
 */

public class AccountTest {
    private Account account;

    // This method is executed before each test to initialize a fresh Account instance
    @BeforeEach
    public void setUp() {
        account = new Account(12345, 6789, 1000.00, 2000.00);
    }

    // Test that the customer number can be set and retrieved correctly
    @Test
    public void testSetAndGetCustomerNumber() {
        account.setCustomerNumber(54321);
        assertEquals(54321, account.getCustomerNumber(), "Customer number should be 54321");
    }

    // Test that the PIN can be set and retrieved correctly
    @Test
    public void testSetAndGetPinNumber() {
        account.setPinNumber(9876);
        assertEquals(9876, account.getPinNumber(), "PIN number should be 9876");
    }

    // Test that the checking account balance can be retrieved correctly
    @Test
    public void testGetCheckingBalance() {
        assertEquals(1000.00, account.getCheckingBalance(), "Checking balance should be 1000.00");
    }

    // Test that the savings account balance can be retrieved correctly
    @Test
    public void testGetSavingBalance() {
        assertEquals(2000.00, account.getSavingBalance(), "Saving balance should be 2000.00");
    }

    // Test that money can be withdrawn from the checking account and the balance updates correctly
    @Test
    public void testCalcCheckingWithdraw() {
        account.calcCheckingWithdraw(100.00);
        assertEquals(900.00, account.getCheckingBalance(), "Checking balance should be 900.00 after withdrawal");
    }

    // Test that money can be withdrawn from the savings account and the balance updates correctly
    @Test
    public void testCalcSavingWithdraw() {
        account.calcSavingWithdraw(200.00);
        assertEquals(1800.00, account.getSavingBalance(), "Saving balance should be 1800.00 after withdrawal");
    }

    // Test that money can be deposited into the checking account and the balance updates correctly
    @Test
    public void testCalcCheckingDeposit() {
        account.calcCheckingDeposit(200.00);
        assertEquals(1200.00, account.getCheckingBalance(), "Checking balance should be 1200.00 after deposit");
    }

    // Test that money can be deposited into the savings account and the balance updates correctly
    @Test
    public void testCalcSavingDeposit() {
        account.calcSavingDeposit(300.00);
        assertEquals(2300.00, account.getSavingBalance(), "Saving balance should be 2300.00 after deposit");
    }

    // Test that transferring money from checking to savings updates the balances correctly
    @Test
    public void testCalcCheckTransfer() {
        account.calcCheckTransfer(500.00);
        assertEquals(500.00, account.getCheckingBalance(), "Checking balance should be 500.00 after transfer");
        assertEquals(2500.00, account.getSavingBalance(), "Saving balance should be 2500.00 after transfer");
    }

    // Test that transferring money from savings to checking updates the balances correctly
    @Test
    public void testCalcSavingTransfer() {
        account.calcSavingTransfer(600.00);
        assertEquals(1600.00, account.getCheckingBalance(), "Checking balance should be 1600.00 after transfer");
        assertEquals(1400.00, account.getSavingBalance(), "Saving balance should be 1400.00 after transfer");
    }

    // Test that the checking account balance does not go negative after a withdrawal
    @Test
    public void testNonNegativeBalanceAfterCheckingWithdraw() {
        double initialBalance = account.getCheckingBalance();
        double withdrawAmount = 500.00;
        if (initialBalance >= withdrawAmount) {
            account.calcCheckingWithdraw(withdrawAmount);
            assertEquals(initialBalance - withdrawAmount, account.getCheckingBalance(), "Checking balance should be correctly updated after withdrawal.");
        } else {
            assertThrows(IllegalArgumentException.class, () -> {
                account.calcCheckingWithdraw(withdrawAmount);
            }, "Withdrawal amount should be valid.");
        }
    }

    // Test that the savings account balance does not go negative after a withdrawal
    @Test
    public void testNonNegativeBalanceAfterSavingWithdraw() {
        double initialBalance = account.getSavingBalance();
        double withdrawAmount = 500.00;
        if (initialBalance >= withdrawAmount) {
            account.calcSavingWithdraw(withdrawAmount);
            assertEquals(initialBalance - withdrawAmount, account.getSavingBalance(), "Saving balance should be correctly updated after withdrawal.");
        } else {
            assertThrows(IllegalArgumentException.class, () -> {
                account.calcSavingWithdraw(withdrawAmount);
            }, "Withdrawal amount should be valid.");
        }
    }

    // Test that the checking account balance is non-negative after a deposit
    @Test
    public void testNonNegativeBalanceAfterCheckingDeposit() {
        account.calcCheckingDeposit(500.00);
        assertTrue(account.getCheckingBalance() >= 0, "Checking balance should be non-negative");
    }

    // Test that the savings account balance is non-negative after a deposit
    @Test
    public void testNonNegativeBalanceAfterSavingDeposit() {
        account.calcSavingDeposit(700.00);
        assertTrue(account.getSavingBalance() >= 0, "Saving balance should be non-negative");
    }

    // Test that the customer number remains the same after being set
    @Test
    public void testSameCustomerNumber() {
        account.setCustomerNumber(11111);
        assertEquals(11111, account.getCustomerNumber(), "Customer number should be the same as set");
    }

    // Test that the PIN is different after setting a new PIN
    @Test
    public void testNotSamePinNumber() {
        int oldPin = account.getPinNumber();
        account.setPinNumber(2222);
        assertNotSame(oldPin, account.getPinNumber(), "PIN number should not be the same as the old one");
    }

    // Test that the checking account balance is not null
    @Test
    public void testNotNullCheckingBalance() {
        assertNotNull(account.getCheckingBalance(), "Checking balance should not be null");
    }

    // Test that the savings account balance is not null
    @Test
    public void testNotNullSavingBalance() {
        assertNotNull(account.getSavingBalance(), "Saving balance should not be null");
    }

    // Test that the scanner input is null
    @Test
    public void testNullScannerInput() {
        account.input = null;
        assertNull(account.input, "Scanner input should be null");
    }
}
