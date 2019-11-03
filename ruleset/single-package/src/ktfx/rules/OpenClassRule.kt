package ktfx.rules

import com.pinterest.ktlint.core.Rule
import org.jetbrains.kotlin.com.intellij.lang.ASTNode
import org.jetbrains.kotlin.lexer.KtTokens
import org.jetbrains.kotlin.psi.KtClass
import org.jetbrains.kotlin.psi.KtDeclarationModifierList
import org.jetbrains.kotlin.psi.stubs.elements.KtStubElementTypes

class OpenClassRule : Rule("open-class") {
    override fun visit(
        node: ASTNode,
        autoCorrect: Boolean,
        emit: (offset: Int, errorMessage: String, canBeAutoCorrected: Boolean) -> Unit
    ) {
        if (node.elementType == KtStubElementTypes.CLASS) {
            val ktClass = node.psi<KtClass>()
            // builder indicates that the class is only used within DSL context only
            val isClass = !ktClass.isInterface() && !ktClass.isAnnotation()
            if (isClass && "Builder" !in ktClass.name!!) {
                val child = node.findChildByType(KtStubElementTypes.MODIFIER_LIST)
                if (child == null) {
                    emit(node.startOffset, "Empty modifiers, need open.", false)
                } else {
                    val modifiers = child.psi<KtDeclarationModifierList>()
                    if (!modifiers.hasModifier(KtTokens.OPEN_KEYWORD) &&
                        !modifiers.hasModifier(KtTokens.PRIVATE_KEYWORD) &&
                        !modifiers.hasModifier(KtTokens.INTERNAL_KEYWORD)
                    ) {
                        emit(node.startOffset, "Public classes need open modifier.", false)
                    }
                }
            }
        }
    }
}