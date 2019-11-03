package ktfx.rules

import com.pinterest.ktlint.core.Rule
import org.jetbrains.kotlin.com.intellij.lang.ASTNode
import org.jetbrains.kotlin.psi.KtPackageDirective
import org.jetbrains.kotlin.psi.stubs.elements.KtStubElementTypes

class PredefinedPackageRule : Rule("predefined-package") {
    private val predefinedPackageSet = setOf(
        "ktfx.coroutines",
        "ktfx.layouts",
        "ktfx.listeners",
        "ktfx.test",
        "ktfx.thirdparty.controlsfx.coroutines",
        "ktfx.thirdparty.controlsfx.layouts",
        "ktfx.thirdparty.jfoenix.coroutines",
        "ktfx.thirdparty.jfoenix.layouts"
    )

    override fun visit(
        node: ASTNode,
        autoCorrect: Boolean,
        emit: (offset: Int, errorMessage: String, canBeAutoCorrected: Boolean) -> Unit
    ) {
        if (node.elementType == KtStubElementTypes.PACKAGE_DIRECTIVE) {
            val name = node.psi<KtPackageDirective>().qualifiedName
            if (name !in predefinedPackageSet) {
                emit(node.startOffset, "Illegal package name.", false)
            }
        }
    }
}