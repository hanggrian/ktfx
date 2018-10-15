package ktfx.rules

import ktfx.test.RuleTest
import org.junit.Test

class OpenClassRuleTest : RuleTest {

    override val rule = OpenClassRule()

    @Test fun test() = assert(of(4, 1, "Public classes must be open.")) {
        """
            open class Correct
            private inner class OkayBecausePrivate
            inner internal class AlsoOkay
            class Failing
        """
    }
}