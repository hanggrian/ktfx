package ktfx.test

import com.github.shyiko.ktlint.core.LintError
import com.github.shyiko.ktlint.test.lint
import com.google.common.truth.Truth
import ktfx.rules.SimpleRule

/** For testing single rule, not multiple rules at the same time. */
interface SimpleRuleTest {

    val instance: SimpleRule

    fun assert(
        vararg exactly: Triple<Int, Int, String>,
        text: () -> String
    ) {
        Truth
            .assertThat(instance.lint(text().trimIndent()))
            .containsExactly(*exactly.map {
                LintError(
                    it.first,
                    it.second,
                    instance.id,
                    it.third
                )
            }.toTypedArray())
    }

    fun of(line: Int, col: Int, message: String): Triple<Int, Int, String> = Triple(line, col, message)
}