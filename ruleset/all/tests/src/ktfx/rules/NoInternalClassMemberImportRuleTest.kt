package ktfx.rules

import ktfx.test.RuleTest
import kotlin.test.Test

class NoInternalClassMemberImportRuleTest : RuleTest {

    override val rule = NoInternalClassMemberImportRule()

    @Test fun method() = assertRule(lintErrorOf(2, 1, "No internal class member import")) {
        """
            import a.b.c
            import a.internal.someMethod
        """
    }

    @Test fun property() = assertRule(lintErrorOf(3, 1, "No internal class member import")) {
        """
            import a.b.c
            import d.e.f
            import a.internal.SOME_PROPERTY
        """
    }
}