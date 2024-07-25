import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({
        AccountTest.class,
        OptionMenuTest.class,
        AccountParameterizedTest.class
})
public class AllTestSuite {
    // This class remains empty and serves as a holder for the above annotations
}
