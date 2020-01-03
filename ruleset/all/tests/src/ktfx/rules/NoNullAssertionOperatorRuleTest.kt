package ktfx.rules

import ktfx.test.RuleTest
import kotlin.test.Test

class NoNullAssertionOperatorRuleTest : RuleTest {

    override val rule = NoNullAssertionOperatorRule()

    @Test fun test() = assertRule(lintErrorOf(3, 29, "Replace `!!` with `checkNotNull` with helpful message")) {
        """
            fun getItem(): Any? = null

            fun someMethod() = getItem()!!
        """
    }
}