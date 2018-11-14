package ktfx.rules

import com.github.shyiko.ktlint.core.RuleSet
import com.github.shyiko.ktlint.core.RuleSetProvider

class AllRuleset : RuleSetProvider {

    override fun get() = RuleSet(
        "all-ruleset",
        NoInternalClassMemberImportRule(),
        NoNullAssertionOperatorRule(),
        ExpressionFunctionReturnTypeRule()
    )
}