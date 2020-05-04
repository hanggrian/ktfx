package com.hendraanggrian.ktfx.rules

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
        if (node.elementType != KtStubElementTypes.CLASS) {
            return
        }
        val ktClass = node.getPsi(KtClass::class.java)

        // only check top-level class
        if (ktClass.parent !is KtFile || ktClass.isInterface() || ktClass.isAnnotation()) {
            return
        }

        val modifierListNode = node.findChildByType(KtStubElementTypes.MODIFIER_LIST)
        val classKeywordNode = node.findChildByType(KtTokens.CLASS_KEYWORD)!!
        when (modifierListNode) {
            null -> emit(classKeywordNode.startOffset, "Empty modifiers, need open.", false)
            else -> {
                val ktModifierList = modifierListNode.getPsi(KtDeclarationModifierList::class.java)
                if (!ktModifierList.hasModifier(KtTokens.OPEN_KEYWORD) &&
                    !ktModifierList.hasModifier(KtTokens.PRIVATE_KEYWORD) &&
                    !ktModifierList.hasModifier(KtTokens.INTERNAL_KEYWORD)
                ) {
                    emit(classKeywordNode.startOffset, "Public classes need open modifier.", false)
                }
            }
        }
    }
}
