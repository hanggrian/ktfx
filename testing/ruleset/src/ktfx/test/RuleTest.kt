package ktfx.test

import com.google.common.truth.Truth.assertThat
import com.pinterest.ktlint.core.LintError
import com.pinterest.ktlint.core.Rule
import com.pinterest.ktlint.test.lint

/** For testing single rule, not multiple rules at the same time. */
interface RuleTest {

    val rule: Rule

    fun assertRule(vararg exactly: Triple<Int, Int, String>, text: () -> String) {
        assertThat(rule.lint(text().trimIndent()))
            .containsExactly(*exactly.map { LintError(it.first, it.second, rule.id, it.third) }.toTypedArray())
    }

    fun lintErrorOf(line: Int, col: Int, message: String) = Triple(line, col, message)
}