package ktfx.rules

import ktfx.test.SimpleRuleTest
import org.junit.Test

class ExpressionFunctionReturnTypeRuleTest : SimpleRuleTest {

    override val instance = ExpressionFunctionReturnTypeRule()

    @Test fun test() = assert(of(3, 1, "Expression function need return type")) {
        """
            fun get(): String = ""

            fun getMore() = ""
        """
    }
}