package ktfx.rules

import ktfx.test.RuleTest
import kotlin.test.Test

class PredefinedPackageRuleTest : RuleTest {
    override val rule = PredefinedPackageRule()

    @Test fun test() = assertRule(
        lintErrorOf(1, 9, "Illegal package name.")
    ) {
        """
            package ktfx.coroutiness
        """
    }
}