package ktfx.rules

import ktfx.test.RuleTest
import org.junit.Test

class OpenClassRuleTest : RuleTest {

    override val rule = OpenClassRule()

    @Test fun test() = assert(of(1, 1, "Public classes must be open.")) {
        """
            class Failing
            open class Correct
        """
    }
}