package ktfx.rules

import com.pinterest.ktlint.core.Rule
import org.jetbrains.kotlin.KtNodeTypes
import org.jetbrains.kotlin.com.intellij.lang.ASTNode
import org.jetbrains.kotlin.lexer.KtTokens
import org.jetbrains.kotlin.psi.stubs.elements.KtStubElementTypes

/** Expression function and property must have return type. */
class ExpressionFunctionReturnTypeRule : Rule("expression-function-return-type") {

    override fun visit(node: ASTNode, autoCorrect: Boolean, emit: (Int, String, Boolean) -> Unit) {
        val typeName = when (node.elementType) {
            KtStubElementTypes.FUNCTION -> "Expression function"
            KtStubElementTypes.PROPERTY -> "Property"
            else -> return
        }
        // only check top-level declaration
        if (node.treeParent?.elementType == KtStubElementTypes.FILE) {
            val identifier = node.findChildByType(KtTokens.IDENTIFIER)
            val parent = identifier?.treeParent
            // function with block expression is allowed
            if (typeName == "Expression function" && parent?.findChildByType(KtNodeTypes.BLOCK) != null) {
                return
            }
            if (parent?.findChildByType(KtStubElementTypes.TYPE_REFERENCE) == null) {
                emit(identifier!!.startOffset, "$typeName need return type", false)
            }
        }
    }
}
