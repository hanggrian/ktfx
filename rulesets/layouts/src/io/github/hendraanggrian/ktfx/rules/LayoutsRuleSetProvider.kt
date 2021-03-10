package io.github.hendraanggrian.ktfx.rules

import com.pinterest.ktlint.core.RuleSet
import com.pinterest.ktlint.core.RuleSetProvider

class LayoutsRuleSetProvider : RuleSetProvider {

    override fun get() = RuleSet(
        "layouts-ruleset",
        OpenClassRule()
    )
}