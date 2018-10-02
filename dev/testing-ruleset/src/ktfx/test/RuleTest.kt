package ktfx.test

import com.github.shyiko.ktlint.core.LintError
import com.github.shyiko.ktlint.test.lint
import com.google.common.truth.Truth
import ktfx.rules.Rule

/** For testing single rule, not multiple rules at the same time. */
interface RuleTest {

    val rule: Rule

    fun assert(
        vararg exactly: Triple<Int, Int, String>,
        text: () -> String
    ) {
        Truth
            .assertThat(rule.lint(text().trimIndent()))
            .containsExactly(*exactly.map {
                LintError(
                    it.first,
                    it.second,
                    rule.id,
                    it.third
                )
            }.toTypedArray())
    }

    fun of(line: Int, col: Int, message: String): Triple<Int, Int, String> = Triple(line, col, message)
}