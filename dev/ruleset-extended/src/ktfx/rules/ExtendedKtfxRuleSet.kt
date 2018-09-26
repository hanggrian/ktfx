package ktfx.rules

import com.github.shyiko.ktlint.core.RuleSet
import com.github.shyiko.ktlint.core.RuleSetProvider

class ExtendedKtfxRuleSet : RuleSetProvider {

    override fun get() = RuleSet(
        "ktfx-extended-ruleset",
        SingularPackageRule()
    )
}