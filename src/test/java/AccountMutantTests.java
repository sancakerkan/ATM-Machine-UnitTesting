import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Test class for the AccountMutant class.
 * Tests the functionalities of the mutant versions of the Account class.
 */
public class AccountMutantTests {
    private AccountMutant account;

    // This method is executed before each test to initialize a fresh AccountMutant instance
    @BeforeEach
    public void setUp() {
        account = new AccountMutant(12345, 6789, 1000.00, 2000.00);
    }

    // Test that money deposited into the checking account updates balance incorrectly (Mutant 1)
    @Test
    // Mutant 1
    public void testCalcCheckingDepositMutant() {
        account.calcCheckingDeposit(200.00);
        assertEquals(1200.00, account.getCheckingBalance(), "Checking balance should be 1200.00 after deposit");
    }

    // Test that money withdrawn from the checking account updates balance incorrectly (Mutant 2)
    @Test
    // Mutant 2
    public void testCalcCheckingWithdrawMutant() {
        account.calcCheckingWithdraw(100.00);
        assertEquals(900.00, account.getCheckingBalance(), "Checking balance should be 900.00 after withdrawal");
    }

    // Test that checking deposit input with incorrect balance check (Mutant 3)
    @Test
    // Mutant 3
    public void testGetCheckingDepositInputMutant() {
        // Use a similar method to the original but expect failure due to mutant
        account.calcCheckingDeposit(200.00);
        assertTrue(account.getCheckingBalance() < 0, "Checking balance should incorrectly handle deposit due to mutant.");
    }

    // Test that transferring money from savings to checking updates balances correctly (no mutant)
    @Test
    // Mutant 4
    public void testCalcSavingTransferMutant() {
        account.calcSavingTransfer(600.00);
        assertEquals(1600.00, account.getCheckingBalance(), "Checking balance should be 1600.00 after transfer");
        assertEquals(2600.00, account.getSavingBalance(), "Saving balance should be 1400.00 after transfer");
    }

    // Test that money withdrawn from the savings account updates balance incorrectly (Mutant 5)
    @Test
    // Mutant 5
    public void testCalcSavingWithdrawMutant() {
        account.calcSavingWithdraw(200.00);
        assertEquals(1800.00, account.getSavingBalance(), "Saving balance should be 1800.00 after withdrawal");
    }

    // Test that money deposited into the savings account updates balance incorrectly (Mutant 6)
    @Test
    // Mutant 6
    public void testCalcSavingDepositMutant() {
        account.calcSavingDeposit(300.00);
        assertEquals(2300.00, account.getSavingBalance(), "Saving balance should be 2300.00 after deposit");
    }

    // Test that savings transfer input with incorrect balance check (Mutant 7)
    @Test
    // Mutant 7
    public void testGetTransferInputMutant() {
        account.calcSavingTransfer(500.00);
        assertTrue(account.getCheckingBalance() < 0, "Checking balance should incorrectly handle transfer due to mutant.");
        assertTrue(account.getSavingBalance() >= 0, "Saving balance should incorrectly handle transfer due to mutant.");
    }

    // Test that transferring money from checking to savings updates balances incorrectly (Mutant 8)
    @Test
    // Mutant 8
    public void testCalcCheckTransferMutant() {
        account.calcCheckTransfer(500.00);
        assertEquals(1500.00, account.getCheckingBalance(), "Checking balance should be 500.00 after transfer");
        assertEquals(2500.00, account.getSavingBalance(), "Saving balance should be 2500.00 after transfer");
    }
}
