package ktfx.rules

import com.github.shyiko.ktlint.core.RuleSet
import com.github.shyiko.ktlint.core.RuleSetProvider

class AllKtfxRuleSet : RuleSetProvider {

    override fun get() = RuleSet(
        "ktfx-all-ruleset",
        NoInternalClassMemberImportRule(),
        NoNullAssertionOperatorRule(),
        ExpressionFunctionReturnTypeRule()
    )
}