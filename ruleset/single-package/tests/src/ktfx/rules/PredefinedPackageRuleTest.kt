package ktfx.rules

import ktfx.test.RuleTest
import org.junit.Test

class PredefinedPackageRuleTest : RuleTest {

    override val rule = PredefinedPackageRule()

    @Test fun test() = assert(of(1, 1, "See artifacts.kt for pre-defined packages")) {
        """
            package ktfx.coroutiness

            import some.shit
        """
    }
}