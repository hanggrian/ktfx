package ktfx.rules

import com.github.shyiko.ktlint.core.RuleSet
import com.github.shyiko.ktlint.core.RuleSetProvider

class NoInstanceRuleSet : RuleSetProvider {

    override fun get() = RuleSet(
        "ktfx-no-instance-ruleset",
        NoInstanceRule()
    )
}