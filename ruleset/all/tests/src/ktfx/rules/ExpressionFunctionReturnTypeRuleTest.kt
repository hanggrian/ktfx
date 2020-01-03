package ktfx.rules

import ktfx.test.RuleTest
import kotlin.test.Test

class ExpressionFunctionReturnTypeRuleTest : RuleTest {

    override val rule = ExpressionFunctionReturnTypeRule()

    @Test fun test() = assertRule(lintErrorOf(3, 1, "Expression function need return type")) {
        """
            fun get(): String = ""

            fun getMore() = ""
        """
    }
}