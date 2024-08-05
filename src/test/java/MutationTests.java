import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MutationTests {

    private Account account;

    @BeforeEach
    public void setUp() {
        account = new Account(12345, 6789, 1000.00, 2000.00);
    }

    //---TEST-1
    // Test that money can be withdrawn from the checking account and the balance updates correctly
    @Test
    public void testCalcCheckingWithdraw() {
        account.calcCheckingWithdraw(100.00);
        assertEquals(900.00, account.getCheckingBalance(), "Checking balance should be 900.00 after withdrawal");
    }
    //-------------- MUTANTS ------------
    // Mutant 1: Change Withdrawal Amount
    @Test
    public void testCalcCheckingWithdraw_Mutant1() {
        account.calcCheckingWithdraw(50.00);  // Mutant: Changed withdrawal amount
        assertEquals(900.00, account.getCheckingBalance(), "Checking balance should be 900.00 after withdrawal");
    }
    // Mutant 2: Incorrect Expected Balance
    @Test
    public void testCalcCheckingWithdraw_Mutant2() {
        account.calcCheckingWithdraw(100.00);
        assertEquals(950.00, account.getCheckingBalance(), "Checking balance should be 950.00 after withdrawal");  // Mutant: Incorrect expected balance
    }
    // Mutant 3: Withdraw from Savings Instead of Checking
    @Test
    public void testCalcCheckingWithdraw_Mutant3() {
        account.calcSavingWithdraw(100.00);  // Mutant: Withdraw from savings instead of checking
        assertEquals(900.00, account.getCheckingBalance(), "Checking balance should be 900.00 after withdrawal");
    }
    // Mutant 4: Forget to Perform Withdrawal
    @Test
    public void testCalcCheckingWithdraw_Mutant4() {
        // account.calcCheckingWithdraw(100.00);  // Mutant: Forgot to perform the withdrawal
        assertEquals(900.00, account.getCheckingBalance(), "Checking balance should be 900.00 after withdrawal");
    }
    //--------------


    //---TEST-2
    // Test that the checking account balance is non-negative after a deposit
    @Test
    public void testNonNegativeBalanceAfterCheckingDeposit() {
        account.calcCheckingDeposit(500.00);
        assertTrue(account.getCheckingBalance() >= 0, "Checking balance should be non-negative");
    }
    //-------------- MUTANTS ------------
    // Mutant 1: Negative Deposit Amount
    @Test
    public void testNonNegativeBalanceAfterCheckingDeposit_Mutant1() {
        account.calcCheckingDeposit(-5000.00);  // Mutant: Negative deposit amount
        assertTrue(account.getCheckingBalance() >= 0, "Checking balance should be non-negative even with negative deposit");
    }
    // Mutant 2: Incorrect Balance Check
    @Test
    public void testNonNegativeBalanceAfterCheckingDeposit_Mutant2() {
        account.calcCheckingDeposit(500.00);
        assertTrue(account.getCheckingBalance() == 1000.00, "Checking balance should not be the initial value after deposit");  // Mutant: Incorrect balance check
    }
    // Mutant 3: Assertion Changed to Expect Balance to be Zero
    @Test
    public void testNonNegativeBalanceAfterCheckingDeposit_Mutant3() {
        account.calcCheckingDeposit(500.00);  // Mutant: Assertion changed to expect balance to be zero
        assertTrue(account.getCheckingBalance() == 0, "Checking balance should be 0 if deposit operation is omitted");
    }
    // Mutant 4: Incorrect Assertion to Test for Negative Balance
    @Test
    public void testNonNegativeBalanceAfterCheckingDeposit_Mutant4() {
        account.calcCheckingDeposit(500.00);
        assertTrue(account.getCheckingBalance() < 0, "Checking balance should not be negative after deposit");  // Mutant: Incorrect assertion to test for negative balance
    }
    //--------------------------

}