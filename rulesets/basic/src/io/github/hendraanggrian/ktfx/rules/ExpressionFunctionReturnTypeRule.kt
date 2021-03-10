package io.github.hendraanggrian.ktfx.rules

import com.pinterest.ktlint.core.Rule
import org.jetbrains.kotlin.KtNodeTypes
import org.jetbrains.kotlin.com.intellij.lang.ASTNode
import org.jetbrains.kotlin.psi.stubs.elements.KtStubElementTypes

/** Expression function and property must have return type. */
class ExpressionFunctionReturnTypeRule : Rule("expression-function-return-type") {

    override fun visit(node: ASTNode, autoCorrect: Boolean, emit: (Int, String, Boolean) -> Unit) {
        val typeName = when {
            node.elementType == KtStubElementTypes.FUNCTION &&
                node.findChildByType(KtNodeTypes.BLOCK) == null -> "Expression function"
            node.elementType == KtStubElementTypes.PROPERTY -> "Property"
            else -> return
        }

        // only check top-level declaration
        if (node.treeParent?.elementType != KtStubElementTypes.FILE) {
            return
        }

        if (node.findChildByType(KtStubElementTypes.TYPE_REFERENCE) == null) {
            emit(node.startOffset, "$typeName need return type", false)
        }
    }
}
