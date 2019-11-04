package ktfx.rules

import ktfx.testing.RuleTest
import kotlin.test.Test

class PredefinedPackageRuleTest : RuleTest {

    override val rule = PredefinedPackageRule()

    @Test
    fun test() = assert(of(1, 1, "Illegal package name.")) {
        """
            package ktfx.coroutiness

            import some.shit
        """
    }
}