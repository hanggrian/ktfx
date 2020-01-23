package ktfx.rules

import com.pinterest.ktlint.core.Rule
import org.jetbrains.kotlin.com.intellij.lang.ASTNode
import org.jetbrains.kotlin.psi.KtPackageDirective
import org.jetbrains.kotlin.psi.psiUtil.startOffset
import org.jetbrains.kotlin.psi.stubs.elements.KtStubElementTypes

/** Classes and extension functions may only be deployed to single pre-defined package. */
class PredefinedPackageRule : Rule("predefined-package") {
    private companion object {
        val PREDEFINED_PACKAGES = setOf(
            "ktfx.coroutines",
            "ktfx.layouts",
            "ktfx.listeners",
            "ktfx.controlsfx.coroutines",
            "ktfx.controlsfx.layouts",
            "ktfx.controlsfx.listeners",
            "ktfx.jfoenix.coroutines",
            "ktfx.jfoenix.layouts",
            "ktfx.jfoenix.listeners"
        )
    }

    override fun visit(node: ASTNode, autoCorrect: Boolean, emit: (Int, String, Boolean) -> Unit) {
        if (node.elementType == KtStubElementTypes.PACKAGE_DIRECTIVE) {
            val packageDirective = node.getPsi(KtPackageDirective::class.java)
            if (packageDirective.qualifiedName !in PREDEFINED_PACKAGES) {
                emit(packageDirective.packageNameExpression!!.startOffset, "Illegal package name.", false)
            }
        }
    }
}
