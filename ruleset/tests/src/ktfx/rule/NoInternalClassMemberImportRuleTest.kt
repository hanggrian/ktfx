package ktfx.rule

import org.junit.Test

class NoInternalClassMemberImportRuleTest : SimpleRuleTest {

    override val instance = NoInternalClassMemberImportRule()

    @Test fun method() = assert(2 to 1) {
        """
            import a.b.c
            import a.internal.someMethod
        """
    }

    @Test fun property() = assert(3 to 1) {
        """
            import a.b.c
            import d.e.f
            import a.internal.SOME_PROPERTY
        """
    }
}