import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Test class for the OptionMenu class.
 * Tests the functionalities of account management and login operations.
 */
public class OptionMenuTest {
    private OptionMenu optionMenu;

    // This method is executed before each test to initialize a fresh OptionMenu instance
    // and populate it with sample Account data.
    @BeforeEach
    public void setUp() {
        optionMenu = new OptionMenu();
        optionMenu.data.put(952141, new Account(952141, 191904, 1000, 5000));
        optionMenu.data.put(123, new Account(123, 123, 20000, 50000));
    }

    // Test that the initial data setup correctly initializes the OptionMenu with the
    // expected accounts.
    @Test
    public void testInitialDataSetup() {
        assertNotNull(optionMenu.data, "Data map should not be null");
        assertEquals(2, optionMenu.data.size(), "Data map should contain 2 accounts");
        assertTrue(optionMenu.data.containsKey(952141), "Data map should contain account with customer number 952141");
        assertTrue(optionMenu.data.containsKey(123), "Data map should contain account with customer number 123");
    }

    // Test that a new account can be added to the OptionMenu and is retrievable
    // with the correct PIN number.
    @Test
    public void testCreateAccountAddsNewAccount() {
        try {
            optionMenu.data.put(999999, new Account(999999, 4321));
            assertTrue(optionMenu.data.containsKey(999999), "Data map should contain the new account with customer number 999999");
            assertEquals(4321, optionMenu.data.get(999999).getPinNumber(), "PIN number of new account should be 4321");
        } catch (Exception e) {
            fail("Exception occurred while adding new account: " + e.getMessage());
        }
    }

    // Test that the account with a specific customer number can be retrieved
    // and has the correct PIN number.
    @Test
    public void testGetLoginCorrectAccount() {
        int customerNumber = 123;
        int pinNumber = 123;
        Account account = optionMenu.data.get(customerNumber);
        assertNotNull(account, "Account should not be null");
        assertEquals(pinNumber, account.getPinNumber(), "PIN number of the account should be 123");
    }

    // Test that the checking and saving balances of an account are correctly retrieved.
    @Test
    public void testAccessCheckingsAccount() {
        Account account = optionMenu.data.get(952141);
        assertNotNull(account, "Account should not be null");
        assertEquals(1000.00, account.getCheckingBalance(), "Checking balance should be 1000.00");
        assertEquals(5000.00, account.getSavingBalance(), "Saving balance should be 5000.00");
    }
}
