package ktfx.rules

import org.jetbrains.kotlin.lexer.KtTokens
import org.jetbrains.kotlin.psi.stubs.elements.KtStubElementTypes

class OpenClassRule : Rule("open-class", { node, _, emit ->
    if (node.elementType == KtStubElementTypes.CLASS &&
        node.treePrev.elementType == KtTokens.WHITE_SPACE &&
        node.treePrev.treePrev.elementType != KtTokens.OPEN_KEYWORD) {
        emit(node.startOffset, "Public classes must be open.", false)
    }
})