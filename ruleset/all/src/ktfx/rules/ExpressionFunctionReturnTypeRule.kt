package ktfx.rules

import com.pinterest.ktlint.core.Rule
import org.jetbrains.kotlin.KtNodeTypes
import org.jetbrains.kotlin.com.intellij.lang.ASTNode
import org.jetbrains.kotlin.lexer.KtTokens
import org.jetbrains.kotlin.psi.stubs.elements.KtStubElementTypes

/** Expression function must have return type. */
class ExpressionFunctionReturnTypeRule : Rule("expression-function-return-type") {
    override fun visit(
        node: ASTNode,
        autoCorrect: Boolean,
        emit: (offset: Int, errorMessage: String, canBeAutoCorrected: Boolean) -> Unit
    ) {
        val type = node.elementType
        if (type == KtStubElementTypes.FUNCTION ||
            type == KtStubElementTypes.PROPERTY ||
            type == KtStubElementTypes.PROPERTY_ACCESSOR
        ) {
            val child = node.findChildByType(KtNodeTypes.VALUE_PARAMETER_LIST)
            if (child != null &&
                child.treeNext?.elementType == KtTokens.WHITE_SPACE &&
                child.treeNext?.treeNext?.elementType == KtTokens.EQ
            ) {
                emit(node.startOffset, "Expression function need return type", false)
            }
        }
    }
}
