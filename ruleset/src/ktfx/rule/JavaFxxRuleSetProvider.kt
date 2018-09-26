package ktfx.rule

import com.github.shyiko.ktlint.core.RuleSet
import com.github.shyiko.ktlint.core.RuleSetProvider

class JavaFxxRuleSetProvider : RuleSetProvider {

    override fun get() = RuleSet(
        "javafxx-rules",
        NoInternalClassMemberImportRule(),
        NoNullAssertionOperatorRule()
    )
}