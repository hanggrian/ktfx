package com.hendraanggrian.ktfx.rules

import com.pinterest.ktlint.core.RuleSet
import com.pinterest.ktlint.core.RuleSetProvider

class BasicRuleSetProvider : RuleSetProvider {

    override fun get() = RuleSet(
        "basic-ruleset",
        ExpressionFunctionReturnTypeRule(),
        NoGetterPropertyStaticImportRule(),
        NotNullAssertionOperatorRule()
    )
}