package ktfx.rules

import com.pinterest.ktlint.core.Rule
import org.jetbrains.kotlin.com.intellij.lang.ASTNode
import org.jetbrains.kotlin.lexer.KtTokens
import org.jetbrains.kotlin.psi.KtClass
import org.jetbrains.kotlin.psi.KtDeclarationModifierList
import org.jetbrains.kotlin.psi.KtFile
import org.jetbrains.kotlin.psi.stubs.elements.KtStubElementTypes

/** Top-level classes must remain open. */
class OpenClassRule : Rule("open-class") {

    override fun visit(node: ASTNode, autoCorrect: Boolean, emit: (Int, String, Boolean) -> Unit) {
        if (node.elementType == KtStubElementTypes.CLASS) {
            val ktClass = node.getPsi(KtClass::class.java)
            if (ktClass.parent is KtFile && !ktClass.isInterface() && !ktClass.isAnnotation()) {
                val childNode = node.findChildByType(KtStubElementTypes.MODIFIER_LIST)
                if (childNode == null) {
                    emit(node.startOffset, "Empty modifiers, need open.", false)
                } else {
                    val ktModifiers = childNode.getPsi(KtDeclarationModifierList::class.java)
                    if (!ktModifiers.hasModifier(KtTokens.OPEN_KEYWORD) &&
                        !ktModifiers.hasModifier(KtTokens.PRIVATE_KEYWORD) &&
                        !ktModifiers.hasModifier(KtTokens.INTERNAL_KEYWORD)
                    ) {
                        emit(childNode.startOffset, "Public classes need open modifier.", false)
                    }
                }
            }
        }
    }
}
