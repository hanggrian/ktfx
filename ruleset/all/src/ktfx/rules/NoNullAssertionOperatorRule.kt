package ktfx.rules

import com.pinterest.ktlint.core.Rule
import org.jetbrains.kotlin.com.intellij.lang.ASTNode
import org.jetbrains.kotlin.com.intellij.psi.impl.source.tree.LeafPsiElement
import org.jetbrains.kotlin.lexer.KtSingleValueToken

/**
 * Cannot use Kotlin non-null operator `!!`,
 * use `checkNotNull` with appropriate message instead.
 */
class NoNullAssertionOperatorRule : Rule("no-null-assertion-operator") {
    override fun visit(
        node: ASTNode,
        autoCorrect: Boolean,
        emit: (offset: Int, errorMessage: String, canBeAutoCorrected: Boolean) -> Unit
    ) {
        if (node is LeafPsiElement) {
            if ((node.elementType as? KtSingleValueToken)?.value == "!!") {
                emit(node.startOffset, "Replace `!!` with `checkNotNull` with helpful message", false)
            }
        }
    }
}
