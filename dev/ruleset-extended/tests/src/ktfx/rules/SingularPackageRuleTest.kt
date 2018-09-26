package ktfx.rules

import ktfx.test.SimpleRuleTest
import org.junit.Test

class SingularPackageRuleTest : SimpleRuleTest {

    override val instance = SingularPackageRule()

    @Test fun packageLevel() = assert(of(1, 1, "Invalid package levels")) {
        """
            package my.awesome.app

            import some.shit
        """
    }

    @Test fun prefixPackage() = assert(of(1, 1, "Prefix package must be `ktfx`")) {
        """
            package ktfxx.coroutines

            import some.shit
        """
    }

    @Test fun suffixPackage() = assert(of(1, 1, "See modules.kt for correct suffix packages")) {
        """
            package ktfx.coroutiness

            import some.shit
        """
    }
}