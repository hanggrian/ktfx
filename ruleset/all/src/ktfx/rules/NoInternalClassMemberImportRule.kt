package ktfx.rules

import com.pinterest.ktlint.core.Rule
import org.jetbrains.kotlin.com.intellij.lang.ASTNode
import org.jetbrains.kotlin.psi.KtImportDirective
import org.jetbrains.kotlin.psi.stubs.elements.KtStubElementTypes

/** Cannot import internal static field/function. */
class NoInternalClassMemberImportRule : Rule("no-internal-class-member-import") {
    override fun visit(
        node: ASTNode,
        autoCorrect: Boolean,
        emit: (offset: Int, errorMessage: String, canBeAutoCorrected: Boolean) -> Unit
    ) {
        if (node.elementType == KtStubElementTypes.IMPORT_DIRECTIVE) {
            val path = node.psi<KtImportDirective>().importPath?.pathStr
            if (path != null && "internal" in path) {
                val last = path.split('.').last()
                if (last.first().isLowerCase() || // static function import
                    last.replace("_", "").all { it.isUpperCase() } // const import
                ) {
                    emit(node.startOffset, "No internal class member import", false)
                }
            }
        }
    }
}
