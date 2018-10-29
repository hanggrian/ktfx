package ktfx.rules

import com.github.shyiko.ktlint.core.RuleSet
import com.github.shyiko.ktlint.core.RuleSetProvider

class SinglePackageRuleset : RuleSetProvider {

    override fun get() = RuleSet(
        "single-package-ruleset",
        PredefinedPackageRule()
    )
}