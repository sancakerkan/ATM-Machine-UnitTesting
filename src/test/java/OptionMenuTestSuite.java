import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({
        OptionMenuTest.class
})
public class OptionMenuTestSuite {
    // This class remains empty and serves as a holder for the above annotations
}
