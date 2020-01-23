package ktfx.rules

import ktfx.test.RuleTest
import kotlin.test.Test

class ExpressionFunctionReturnTypeRuleTest : RuleTest {
    override val rule = ExpressionFunctionReturnTypeRule()

    @Test fun function() = assertRule(
        lintErrorOf(2, 5, "Expression function need return type")
    ) {
        """
            fun function() { }
            fun expressionFunction() = "Hello world"
        """
    }

    @Test fun property() = assertRule(
        lintErrorOf(1, 5, "Property need return type"),
        lintErrorOf(2, 5, "Property need return type")
    ) {
        """
            var property = "Hello"
            var propertyAccessor get() = "World"
        """
    }
}