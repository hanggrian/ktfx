package ktfx.rules

import ktfx.test.RuleTest
import org.junit.Test

class ExpressionFunctionReturnTypeRuleTest : RuleTest {

    override val rule = ExpressionFunctionReturnTypeRule()

    @Test fun test() = assert(of(3, 1, "Expression function need return type")) {
        """
            fun get(): String = ""

            fun getMore() = ""
        """
    }
}