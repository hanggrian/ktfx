package javafxx.rule

import org.jetbrains.kotlin.com.intellij.psi.impl.source.tree.LeafPsiElement
import org.jetbrains.kotlin.lexer.KtSingleValueToken

class NoNullAssertionOperatorRule : SimpleRule(
    "no-null-assertion-operator",
    "Replace `!!` with `checkNotNull` with helpful message",
    { node, _, emit ->
        if (node is LeafPsiElement) {
            if ((node.elementType as? KtSingleValueToken)?.value == "!!") {
                emit(node.startOffset, false)
            }
        }
    }
)