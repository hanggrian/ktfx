package io.github.hendraanggrian.ktfx.rules

import io.github.hendraanggrian.ktfx.test.RuleTest
import kotlin.test.Test

class OpenClassRuleTest : RuleTest {
    override val rule = OpenClassRule()

    @Test fun test() = assertRule(
        lintErrorOf(1, 1, "Empty modifiers, need open."),
        lintErrorOf(5, 8, "Public classes need open modifier.")
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