package io.github.hendraanggrian.ktfx.rules

import com.pinterest.ktlint.core.Rule
import org.jetbrains.kotlin.com.intellij.lang.ASTNode
import org.jetbrains.kotlin.lexer.KtTokens

/** Cannot use non-null operator `!!`, use `checkNotNull` with appropriate message instead. */
class NotNullAssertionOperatorRule : Rule("not-null-assertion-operator") {

    override fun visit(node: ASTNode, autoCorrect: Boolean, emit: (Int, String, Boolean) -> Unit) {
        if (node.elementType == KtTokens.EXCLEXCL) {
            emit(node.startOffset, "Replace `!!` with `checkNotNull` with helpful message", false)
        }
    }
}
