package io.github.hendraanggrian.ktfx.rules

import com.pinterest.ktlint.core.RuleSet
import com.pinterest.ktlint.core.RuleSetProvider

class NonCommonsRuleSetProvider : RuleSetProvider {

    override fun get() = RuleSet(
        "non-commons-ruleset",
        PredefinedPackageRule()
    )
}