package javafxx.rule

import com.github.shyiko.ktlint.core.Rule
import org.jetbrains.kotlin.com.intellij.lang.ASTNode

/** Declare ktlint rule like `Spek` test framework. */
abstract class SimpleRule(
    id: String,
    val message: String,
    private val action: (
        node: ASTNode,
        autoCorrect: Boolean,
        emit: (offset: Int, canBeAutoCorrected: Boolean) -> Unit
    ) -> Unit
) : Rule(id) {

    override fun visit(
        node: ASTNode,
        autoCorrect: Boolean,
        emit: (offset: Int, errorMessage: String, canBeAutoCorrected: Boolean) -> Unit
    ) = action(node, autoCorrect) { offset, canBeAutoCorrected ->
        emit(offset, message, canBeAutoCorrected)
    }
}