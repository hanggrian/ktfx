package io.github.hendraanggrian.ktfx.rules

import io.github.hendraanggrian.ktfx.test.RuleTest
import kotlin.test.Test

class NotNullAssertionOperatorRuleTest : RuleTest {
    override val rule = NotNullAssertionOperatorRule()

    @Test fun function() = assertRule(
        lintErrorOf(2, 35, "Replace `!!` with `checkNotNull` with helpful message")
    ) {
        """
            fun function() {
                val something = getSomething()!!
            }
        """
    }

    @Test fun expressionFunction() = assertRule(
        lintErrorOf(1, 37, "Replace `!!` with `checkNotNull` with helpful message")
    ) {
        """
            fun expressionFunction() = getItem()!!
        """
    }
}