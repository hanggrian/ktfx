package ktfx.rules

import com.pinterest.ktlint.core.Rule
import org.jetbrains.kotlin.com.intellij.lang.ASTNode
import org.jetbrains.kotlin.lexer.KtTokens
import org.jetbrains.kotlin.psi.KtClass
import org.jetbrains.kotlin.psi.KtDeclarationModifierList
import org.jetbrains.kotlin.psi.stubs.elements.KtStubElementTypes

/**
 * Public classes must remain `open`, unless its name contains `Builder`
 * (usually Kotlin DSL support class) or `Constraints`
 * (only relevant in `ktfx-layouts`).
 */
class OpenClassRule : Rule("open-class") {

    override fun visit(node: ASTNode, autoCorrect: Boolean, emit: (Int, String, Boolean) -> Unit) {
        if (node.elementType == KtStubElementTypes.CLASS) {
            val ktClass = node.getPsi(KtClass::class.java)
            // builder indicates that the class is only used within DSL context only
            val isClass = !ktClass.isInterface() && !ktClass.isAnnotation()
            val name = ktClass.name!!
            if (isClass && "Builder" !in name && "Constraints" !in name) {
                val child = node.findChildByType(KtStubElementTypes.MODIFIER_LIST)
                if (child == null) {
                    emit(node.startOffset, "Empty modifiers, need open.", false)
                } else {
                    val modifiers = child.getPsi(KtDeclarationModifierList::class.java)
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
