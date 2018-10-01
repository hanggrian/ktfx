package ktfx.rules

import com.github.shyiko.ktlint.core.RuleSet
import com.github.shyiko.ktlint.core.RuleSetProvider

class BaseKtfxRuleSet : RuleSetProvider {

    override fun get() = RuleSet(
        "ktfx-base-ruleset",
        NoInternalClassMemberImportRule(),
        NoNullAssertionOperatorRule(),
        ExpressionFunctionReturnTypeRule()
    )
}