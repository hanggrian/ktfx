package ktfx.rules

import org.jetbrains.kotlin.com.intellij.psi.impl.source.tree.LeafPsiElement
import org.jetbrains.kotlin.lexer.KtSingleValueToken

class NoNullAssertionOperatorRule : Rule("no-null-assertion-operator", { node, _, emit ->
    if (node is LeafPsiElement) {
        if ((node.elementType as? KtSingleValueToken)?.value == "!!") {
            emit(node.startOffset, "Replace `!!` with `checkNotNull` with helpful message", false)
        }
    }
})