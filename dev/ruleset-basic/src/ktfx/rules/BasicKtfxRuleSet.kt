package ktfx.rules

import com.github.shyiko.ktlint.core.RuleSet
import com.github.shyiko.ktlint.core.RuleSetProvider

class BasicKtfxRuleSet : RuleSetProvider {

    override fun get() = RuleSet(
        "ktfx-basic-ruleset",
        NoInternalClassMemberImportRule(),
        NoNullAssertionOperatorRule(),
        ExpressionFunctionReturnTypeRule()
    )
}