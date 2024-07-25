import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({
        AccountTest.class,
        AccountParameterizedTest.class
})
public class AccountTestSuite {
    // This class remains empty and serves as a holder for the above annotations
}
