package com.hendraanggrian.ktfx.rules

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
            "ktfx.internal",
            "ktfx.controlsfx.coroutines",
            "ktfx.controlsfx.layouts",
            "ktfx.controlsfx.listeners",
            "ktfx.jfoenix.coroutines",
            "ktfx.jfoenix.layouts",
            "ktfx.jfoenix.listeners"
        )
    }

    private var currentPackageName: String? = null

    override fun visit(node: ASTNode, autoCorrect: Boolean, emit: (Int, String, Boolean) -> Unit) {
        if (node.elementType != KtStubElementTypes.PACKAGE_DIRECTIVE) {
            return
        }
        val ktPackageDirective = node.getPsi(KtPackageDirective::class.java)
        val packageName = ktPackageDirective.qualifiedName

        // to ensure single package
        if (currentPackageName == null) {
            currentPackageName = packageName
        }

        when {
            packageName != currentPackageName ->
                emit(ktPackageDirective.packageNameExpression!!.startOffset, "Non-single package detected.", false)
            packageName !in PREDEFINED_PACKAGES ->
                emit(ktPackageDirective.packageNameExpression!!.startOffset, "Illegal package name.", false)
        }
    }
}
