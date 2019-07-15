package ktfx.rules

import org.jetbrains.kotlin.lexer.KtTokens
import org.jetbrains.kotlin.psi.KtClass
import org.jetbrains.kotlin.psi.KtDeclarationModifierList
import org.jetbrains.kotlin.psi.stubs.elements.KtStubElementTypes

class OpenClassRule : KtfxRule("open-class", { node, _, emit ->
    if (node.elementType == KtStubElementTypes.CLASS) {
        val ktClass = node.psi<KtClass>()
        // builder indicates that the class is only used within DSL context only
        if (ktClass.isClass() && "Builder" !in ktClass.name!!) {
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
})

fun KtClass.isClass(): Boolean = !isInterface() && !isAnnotation()