package com.hendraanggrian.ktfx.rules

import com.pinterest.ktlint.core.Rule
import com.hendraanggrian.ktfx.test.RuleTest
import kotlin.test.Test

class NoGetterPropertyStaticImportRuleTest : RuleTest {
    override val rule: Rule = NoGetterPropertyStaticImportRule()

    @Test fun memberAndDeclaration() = assertRule(
        lintErrorOf(2, 17, "Annotation members should static import"),
        lintErrorOf(2, 82, "Declaration should static import")
    ) {
        """
            var myString: String
                @Deprecated(KtfxInternals.NO_GETTER, level = DeprecationLevel.ERROR) get() = KtfxInternals.noGetter()
                set(value) { }
        """
    }

    @Test fun member() = assertRule(
        lintErrorOf(2, 17, "Annotation members should static import")
    ) {
        """
            var myString: String
                @Deprecated(KtfxInternals.NO_GETTER, level = DeprecationLevel.ERROR) get() = noGetter()
                set(value) { }
        """
    }

    @Test fun declaration() = assertRule(
        lintErrorOf(2, 51, "Declaration should static import")
    ) {
        """
            var myString: String
                @Deprecated(NO_GETTER, level = ERROR) get() = KtfxInternals.noGetter()
                set(value) { }
        """
    }
}