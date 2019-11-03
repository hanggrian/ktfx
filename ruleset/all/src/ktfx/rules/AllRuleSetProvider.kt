package ktfx.rules

import com.pinterest.ktlint.core.RuleSet
import com.pinterest.ktlint.core.RuleSetProvider

class AllRuleSetProvider : RuleSetProvider {

    override fun get() = RuleSet(
        "all-ruleset",
        NoInternalClassMemberImportRule(),
        NoNullAssertionOperatorRule(),
        ExpressionFunctionReturnTypeRule()
    )
}