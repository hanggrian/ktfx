package io.github.hendraanggrian.ktfx.rules

import com.pinterest.ktlint.core.Rule
import org.jetbrains.kotlin.com.intellij.lang.ASTNode
import org.jetbrains.kotlin.psi.KtAnnotationEntry
import org.jetbrains.kotlin.psi.KtDotQualifiedExpression
import org.jetbrains.kotlin.psi.KtPropertyAccessor
import org.jetbrains.kotlin.psi.psiUtil.getParentOfType
import org.jetbrains.kotlin.psi.psiUtil.startOffset
import org.jetbrains.kotlin.psi.stubs.elements.KtStubElementTypes

/** Mutable property with no getter should static import all members and declaration. */
class NoGetterPropertyStaticImportRule : Rule("no-getter-property-static-import") {

    override fun visit(node: ASTNode, autoCorrect: Boolean, emit: (Int, String, Boolean) -> Unit) {
        if (node.elementType != KtStubElementTypes.ANNOTATION_ENTRY) {
            return
        }
        val ktAnnotationEntry = node.getPsi(KtAnnotationEntry::class.java)
            .takeIf { it.shortName?.asString() == "Deprecated" }
            ?: return

        // check members
        ktAnnotationEntry.valueArguments
            .mapNotNull { it.asElement().firstChild as? KtDotQualifiedExpression }
            .takeIf { it.isNotEmpty() }
            ?.let { emit(it.first().startOffset, "Annotation members should static import", false) }
        // check declaration
        ktAnnotationEntry.getParentOfType<KtPropertyAccessor>(true)
            ?.bodyExpression
            ?.takeIf { it is KtDotQualifiedExpression }
            ?.let { emit(it.startOffset, "Declaration should static import", false) }
    }
}