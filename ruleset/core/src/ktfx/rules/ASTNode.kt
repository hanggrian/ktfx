package ktfx.rules

import org.jetbrains.kotlin.com.intellij.lang.ASTNode
import org.jetbrains.kotlin.com.intellij.psi.PsiElement
import org.jetbrains.kotlin.lexer.KtModifierKeywordToken
import org.jetbrains.kotlin.psi.KtDeclarationModifierList
import org.jetbrains.kotlin.psi.stubs.elements.KtStubElementTypes

const val STRATEGY_ANY = 0
const val STRATEGY_ALL = 1
const val STRATEGY_NONE = 2

inline fun <reified T : PsiElement> ASTNode.psi(): T =
    getPsi(T::class.java)

fun ASTNode.hasModifiersOr(
    fallback: Boolean,
    vararg tokens: KtModifierKeywordToken,
    strategy: Int = STRATEGY_ALL
): Boolean {
    val child = findChildByType(KtStubElementTypes.MODIFIER_LIST) ?: return fallback
    val modifiers = child.psi<KtDeclarationModifierList>()
    return when (strategy) {
        STRATEGY_ANY -> tokens.any { modifiers.hasModifier(it) }
        STRATEGY_ALL -> tokens.all { modifiers.hasModifier(it) }
        else -> tokens.none { modifiers.hasModifier(it) }
    }
}