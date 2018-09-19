package javafxx.rule

import com.github.shyiko.ktlint.core.LintError
import com.github.shyiko.ktlint.test.lint
import com.google.common.truth.Truth

/** For testing single rule, not multiple rules at the same time. */
interface SimpleRuleTest {

    val instance: SimpleRule

    fun assert(
        vararg exactly: Pair<Int, Int>,
        text: () -> String
    ) {
        Truth
            .assertThat(instance.lint(text().trimIndent()))
            .containsExactly(*exactly.map {
                LintError(
                    it.first,
                    it.second,
                    instance.id,
                    instance.message
                )
            }.toTypedArray())
    }
}