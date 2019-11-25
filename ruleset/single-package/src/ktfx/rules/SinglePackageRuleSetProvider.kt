package ktfx.rules

import com.pinterest.ktlint.core.RuleSet
import com.pinterest.ktlint.core.RuleSetProvider

class SinglePackageRuleSetProvider : RuleSetProvider {
    override fun get() = RuleSet(
        "single-package-ruleset",
        PredefinedPackageRule(),
        OpenClassRule()
    )
}