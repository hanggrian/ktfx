package ktfx.rules

import ktfx.test.SimpleRuleTest
import org.junit.Test

class PredefinedPackageRuleTest : SimpleRuleTest {

    override val instance = PredefinedPackageRule()

    @Test fun test() = assert(of(1, 1, "See artifacts.kt for pre-defined packages")) {
        """
            package ktfx.coroutiness

            import some.shit
        """
    }
}