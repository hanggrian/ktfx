package ktfx.testing

import com.google.common.truth.Truth
import com.pinterest.ktlint.core.LintError
import com.pinterest.ktlint.core.Rule
import com.pinterest.ktlint.test.lint

/** For testing single rule, not multiple rules at the same time. */
interface RuleTest {

    val rule: Rule

    fun assert(
        vararg exactly: Triple<Int, Int, String>,
        text: () -> String
    ) {
        Truth.assertThat(rule.lint(text().trimIndent()))
            .containsExactly(*exactly.map { LintError(it.first, it.second, rule.id, it.third) }.toTypedArray())
    }

    fun of(line: Int, col: Int, message: String): Triple<Int, Int, String> =
        Triple(line, col, message)
}