package ktfx.rules

import ktfx.testing.RuleTest
import kotlin.test.Test

class ExpressionFunctionReturnTypeRuleTest : RuleTest {

    override val rule = ExpressionFunctionReturnTypeRule()

    @Test
    fun test() = assert(of(3, 1, "Expression function need return type")) {
        """
            fun get(): String = ""

            fun getMore() = ""
        """
    }
}