package ktfx.rules

import ktfx.test.RuleTest
import kotlin.test.Test

class OpenClassRuleTest : RuleTest {

    override val rule = OpenClassRule()

    @Test fun test() = assert(
        of(1, 1, "Empty modifiers, need open."),
        of(5, 1, "Public classes need open modifier.")
    ) {
        """
            class Failing
            open class Correct
            private class Correct2
            internal class Correct3
            actual class Failing2
        """
    }
}