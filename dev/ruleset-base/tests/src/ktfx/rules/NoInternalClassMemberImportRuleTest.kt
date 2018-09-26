package ktfx.rules

import ktfx.test.SimpleRuleTest
import org.junit.Test

class NoInternalClassMemberImportRuleTest : SimpleRuleTest {

    override val instance = NoInternalClassMemberImportRule()

    @Test fun method() = assert(of(2, 1, "No internal class member import")) {
        """
            import a.b.c
            import a.internal.someMethod
        """
    }

    @Test fun property() = assert(of(3, 1, "No internal class member import")) {
        """
            import a.b.c
            import d.e.f
            import a.internal.SOME_PROPERTY
        """
    }
}