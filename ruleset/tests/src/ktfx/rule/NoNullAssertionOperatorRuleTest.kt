package ktfx.rule

import org.junit.Test

class NoNullAssertionOperatorRuleTest : SimpleRuleTest {

    override val instance = NoNullAssertionOperatorRule()

    @Test fun test() = assert(3 to 29) {
        """
            fun getItem(): Any? = null

            fun someMethod() = getItem()!!
        """
    }
}