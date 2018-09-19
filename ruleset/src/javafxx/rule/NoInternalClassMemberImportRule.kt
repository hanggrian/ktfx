package javafxx.rule

import org.jetbrains.kotlin.psi.KtImportDirective
import org.jetbrains.kotlin.psi.stubs.elements.KtStubElementTypes

class NoInternalClassMemberImportRule : SimpleRule(
    "no-internal-class-member-import",
    "No internal class member import",
    { node, _, emit ->
        if (node.elementType == KtStubElementTypes.IMPORT_DIRECTIVE) {
            val path = (node.psi as KtImportDirective).importPath?.pathStr
            if (path != null && "internal" in path) {
                val last = path.split('.').last()
                if (last.first().isLowerCase() || // static function import
                    last.replace("_", "").all { it.isUpperCase() } // const import
                ) {
                    emit(node.startOffset, false)
                }
            }
        }
    }
)