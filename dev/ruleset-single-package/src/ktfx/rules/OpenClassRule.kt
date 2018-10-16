package ktfx.rules

import org.jetbrains.kotlin.lexer.KtTokens
import org.jetbrains.kotlin.psi.stubs.elements.KtStubElementTypes

class OpenClassRule : Rule("open-class", { node, _, emit ->
    val type = node.elementType
    if (type == KtStubElementTypes.CLASS) {
        val child = node.findChildByType(KtTokens.CLASS_KEYWORD)
        if (child != null &&
            child.treeNext.elementType == KtTokens.WHITE_SPACE &&
            child.treeNext.treeNext.elementType != KtTokens.OPEN_KEYWORD
        ) {
            emit(node.startOffset, "Expression function need return type", false)
        }
    }
})