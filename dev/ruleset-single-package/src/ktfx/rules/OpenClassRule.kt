package ktfx.rules

import org.jetbrains.kotlin.com.intellij.lang.ASTNode
import org.jetbrains.kotlin.lexer.KtTokens
import org.jetbrains.kotlin.psi.stubs.elements.KtStubElementTypes

class OpenClassRule : Rule("open-class", { node, _, emit ->
    if (node.elementType == KtStubElementTypes.CLASS) {
        val modifiers = mutableListOf<ASTNode>()
        var tree = node.treePrev
        while (tree != null && tree.elementType != KtTokens.CLASS_KEYWORD) {
            modifiers += tree
            tree = tree.treePrev
        }
        /**/

        /*var isOpen = true
        var prevTree = node.treePrev
        while (prevTree != null && prevTree.elementType != KtTokens.CLASS_KEYWORD) {
            if (prevTree.elementType == KtTokens.PRIVATE_KEYWORD || prevTree.elementType == KtTokens.INTERNAL_KEYWORD) {
                isOpen = false
                break
            }
            prevTree = prevTree.treePrev
        }
        */
    }
})