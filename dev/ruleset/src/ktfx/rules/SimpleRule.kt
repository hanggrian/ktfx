package ktfx.rules

import com.github.shyiko.ktlint.core.Rule
import org.jetbrains.kotlin.com.intellij.lang.ASTNode

/** Declare ktlint rule like `Spek` test framework. */
abstract class SimpleRule(
    id: String,
    private val action: (
        node: ASTNode,
        autoCorrect: Boolean,
        emit: (offset: Int, message: String, canBeAutoCorrected: Boolean) -> Unit
    ) -> Unit
) : Rule(id) {

    override fun visit(
        node: ASTNode,
        autoCorrect: Boolean,
        emit: (offset: Int, errorMessage: String, canBeAutoCorrected: Boolean) -> Unit
    ) = action(node, autoCorrect, emit)
}