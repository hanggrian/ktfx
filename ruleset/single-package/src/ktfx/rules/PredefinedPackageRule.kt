package ktfx.rules

import com.pinterest.ktlint.core.Rule
import org.jetbrains.kotlin.com.intellij.lang.ASTNode
import org.jetbrains.kotlin.psi.KtPackageDirective
import org.jetbrains.kotlin.psi.stubs.elements.KtStubElementTypes

/** Classes and extension functions may only be deployed to single pre-defined package. */
class PredefinedPackageRule : Rule("predefined-package") {
    private val predefinedPackageSet = setOf(
        "ktfx.coroutines",
        "ktfx.layouts",
        "ktfx.listeners",
        "ktfx.test",
        "ktfx.controlsfx.coroutines",
        "ktfx.controlsfx.layouts",
        "ktfx.controlsfx.listeners",
        "ktfx.jfoenix.coroutines",
        "ktfx.jfoenix.layouts",
        "ktfx.jfoenix.listeners"
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
