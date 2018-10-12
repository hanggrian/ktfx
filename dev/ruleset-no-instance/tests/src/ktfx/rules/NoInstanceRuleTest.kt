package ktfx.rules

import ktfx.test.RuleTest
import org.junit.Test

class NoInstanceRuleTest : RuleTest {

    override val rule = NoInstanceRule()

    @Test fun clazz() = assert(of(4, 1, "No instance is allowed in this module")) {
        """
            fun hello() {
            }

            class Person
        """
    }
}