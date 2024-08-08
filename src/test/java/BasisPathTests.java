import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

public class BasisPathTests {

    //------------------------------------------------------------
    //Basis Path Tests for getTransferInput(String accType) Method
    //------------------------------------------------------------

    // Test for a valid transfer from checking to savings
    @Test
    public void test1Path1_ValidTransferFromCheckingsToSavings() {
        // Create a new Account instance with specific initial balances
        Account account = new Account(123456, 1234, 500.00, 300.00);

        // Perform a transfer of 50.00 from checking to savings
        account.getTransferInput("Checkings", 1, 50.00);

        // Assert that the balances are updated correctly
        assertEquals(450.00, account.getCheckingBalance(), 0.01);
        assertEquals(350.00, account.getSavingBalance(), 0.01);
    }

    // Test for an invalid transfer amount from checking to savings
    @Test
    public void test1Path2_InvalidTransferFromCheckingsToSavings() {
        // Create a new Account instance with specific initial balances
        Account account = new Account(123, 456, 100.00, 200.00);

        // Attempt to transfer 500.00 from checking to savings, which exceeds the balance
        account.getTransferInput("Checkings", 1, 500.00);

        // Assert that the balances remain unchanged due to the invalid transfer amount
        assertEquals(100.00, account.getCheckingBalance(), 0.01); // Balance should remain unchanged
        assertEquals(200.00, account.getSavingBalance(), 0.01); // Balance should remain unchanged
    }

    // Test for a valid transfer from savings to checking
    @Test
    public void test1Path3_ValidTransferFromSavingsToCheckings() {
        // Create a new Account instance with specific initial balances
        Account account = new Account(123456, 1234, 500.00, 300.00);

        // Perform a transfer of 30.00 from savings to checking
        account.getTransferInput("Savings", 1, 30.00);

        // Assert that the balances are updated correctly
        assertEquals(530.00, account.getCheckingBalance(), 0.01);
        assertEquals(270.00, account.getSavingBalance(), 0.01);
    }

    // Test for an invalid transfer amount from savings to checking
    @Test
    public void test1Path4_InvalidTransferFromSavingsToCheckings() {
        // Create a new Account instance with specific initial balances
        Account account = new Account(123, 456, 100.00, 200.00);

        // Attempt to transfer 300.00 from savings to checking, which exceeds the savings balance
        account.getTransferInput("Savings", 1, 300.00);

        // Assert that the balances remain unchanged due to the invalid transfer amount
        assertEquals(100.00, account.getCheckingBalance(), 0.01); // Balance should remain unchanged
        assertEquals(200.00, account.getSavingBalance(), 0.01); // Balance should remain unchanged
    }

    // Test for an invalid choice of transfer type
    @Test
    public void test1Path5_InvalidChoice() {
        // Create a new Account instance with specific initial balances
        Account account = new Account(123456, 1234, 500.00, 300.00);

        // Attempt to make a transfer with an invalid choice (3 in this case)
        account.getTransferInput("Checkings", 3, 0.00);

        // Assert that the balances remain unchanged due to the invalid choice
        assertEquals(500.00, account.getCheckingBalance(), 0.01);
        assertEquals(300.00, account.getSavingBalance(), 0.01);
    }


    //----------------------------------------------
    // Basis Path Tests for getCheckingWithdrawInput
    //----------------------------------------------

    // Test for a valid withdrawal from checking
    @Test
    void test2Path1_testValidWithdrawal() {
        Account account = new Account(12345, 6789, 500.00, 1000.00);
        account.input = new Scanner("100");
        account.getCheckingWithdrawInput();
        assertEquals(400.00, account.getCheckingBalance());
    }

    // Test for a non-numeric withdrawal input from checking
    @Test
    void test2Path2_testWithdrawalNonNumeric() {
        Account account = new Account(12345, 6789, 500.00, 1000.00);
        account.input = new Scanner("abc\n500");
        account.getCheckingWithdrawInput();
        assertEquals(500.00, account.getCheckingBalance());
    }

    // Test for a negative withdrawal input from checking
    @Test
    void test2Path3_testNegativeWithdrawal() {
        Account account = new Account(12345, 6789, 500.00, 1000.00);
        account.input = new Scanner("-50\n500");
        account.getCheckingWithdrawInput();
        assertEquals(500.00, account.getCheckingBalance());
    }

    // Test for a withdrawal amount exceeding the balance from checking
    @Test
    void test2Path4_testWithdrawalMoreThanBalance() {
        Account account = new Account(12345, 6789, 500.00, 1000.00);
        account.input = new Scanner("600\n500");
        account.getCheckingWithdrawInput();
        assertEquals(500.00, account.getCheckingBalance());
    }
}
