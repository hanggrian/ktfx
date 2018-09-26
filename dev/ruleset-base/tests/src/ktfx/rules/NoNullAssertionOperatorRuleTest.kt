package ktfx.rules

import ktfx.test.SimpleRuleTest
import org.junit.Test

class NoNullAssertionOperatorRuleTest : SimpleRuleTest {

    override val instance = NoNullAssertionOperatorRule()

    @Test fun test() = assert(of(3, 29, "Replace `!!` with `checkNotNull` with helpful message")) {
        """
            fun getItem(): Any? = null

            fun someMethod() = getItem()!!
        """
    }
}