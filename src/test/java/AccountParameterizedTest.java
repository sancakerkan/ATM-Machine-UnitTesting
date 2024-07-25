import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class AccountParameterizedTest {

    /**
     * Tests various withdrawal amounts from the checking account.
     * Verifies that the checking balance is updated correctly.
     *
     * @param withdrawAmount the amount to withdraw from the checking account
     * @param expectedBalance the expected balance of the checking account after withdrawal
     */
    @ParameterizedTest
    @CsvSource({
            "100.00, 900.00", // withdraw 100.00, balance should be 900.00
            "200.00, 800.00", // withdraw 200.00, balance should be 800.00
            "300.00, 700.00"  // withdraw 300.00, balance should be 700.00
    })
    void testCalcCheckingWithdraw(double withdrawAmount, double expectedBalance) {
        Account account = new Account(12345, 6789, 1000.00, 2000.00);
        account.calcCheckingWithdraw(withdrawAmount);
        assertEquals(expectedBalance, account.getCheckingBalance(),
                "Checking balance should be updated correctly after withdrawal");
    }

    /**
     * Tests various deposit amounts into the savings account.
     * Verifies that the saving balance is updated correctly.
     *
     * @param depositAmount the amount to deposit into the savings account
     * @param expectedBalance the expected balance of the savings account after deposit
     */
    @ParameterizedTest
    @CsvSource({
            "200.00, 2200.00", // deposit 200.00, balance should be 2200.00
            "300.00, 2300.00", // deposit 300.00, balance should be 2300.00
            "500.00, 2500.00"  // deposit 500.00, balance should be 2500.00
    })
    void testCalcSavingDeposit(double depositAmount, double expectedBalance) {
        Account account = new Account(12345, 6789, 1000.00, 2000.00);
        account.calcSavingDeposit(depositAmount);
        assertEquals(expectedBalance, account.getSavingBalance(),
                "Saving balance should be updated correctly after deposit");
    }

    /**
     * Tests various withdrawal amounts from the savings account.
     * Verifies that the saving balance is updated correctly.
     *
     * @param withdrawAmount the amount to withdraw from the savings account
     * @param expectedBalance the expected balance of the savings account after withdrawal
     */
    @ParameterizedTest
    @CsvSource({
            "100.00, 1900.00", // withdraw 100.00, balance should be 1900.00
            "200.00, 1800.00", // withdraw 200.00, balance should be 1800.00
            "300.00, 1700.00"  // withdraw 300.00, balance should be 1700.00
    })
    void testCalcSavingWithdraw(double withdrawAmount, double expectedBalance) {
        Account account = new Account(12345, 6789, 1000.00, 2000.00);
        account.calcSavingWithdraw(withdrawAmount);
        assertEquals(expectedBalance, account.getSavingBalance(),
                "Saving balance should be updated correctly after withdrawal");
    }

    /**
     * Tests various transfer amounts from the checking account to the savings account.
     * Verifies that both checking and saving balances are updated correctly after the transfer.
     *
     * @param transferAmount the amount to transfer from checking to savings
     * @param expectedCheckingBalance the expected balance of the checking account after transfer
     * @param expectedSavingBalance the expected balance of the savings account after transfer
     */
    @ParameterizedTest
    @CsvSource({
            "100.00, 900.00, 2100.00", // transfer 100.00, checking should be 900.00, savings should be 2100.00
            "200.00, 800.00, 2200.00", // transfer 200.00, checking should be 800.00, savings should be 2200.00
            "300.00, 700.00, 2300.00"  // transfer 300.00, checking should be 700.00, savings should be 2300.00
    })
    void testCalcCheckTransfer(double transferAmount, double expectedCheckingBalance, double expectedSavingBalance) {
        Account account = new Account(12345, 6789, 1000.00, 2000.00);
        account.calcCheckTransfer(transferAmount);
        assertEquals(expectedCheckingBalance, account.getCheckingBalance(),
                "Checking balance should be updated correctly after transfer");
        assertEquals(expectedSavingBalance, account.getSavingBalance(),
                "Saving balance should be updated correctly after transfer");
    }

}
