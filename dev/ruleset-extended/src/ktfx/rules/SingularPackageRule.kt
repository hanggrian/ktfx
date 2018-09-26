package ktfx.rules

import org.jetbrains.kotlin.psi.KtPackageDirective
import org.jetbrains.kotlin.psi.stubs.elements.KtStubElementTypes

class SingularPackageRule : SimpleRule("singular-package", { node, _, emit ->
    if (node.elementType == KtStubElementTypes.PACKAGE_DIRECTIVE) {
        val names = (node.psi as KtPackageDirective).qualifiedName.split('.')
        when {
            names.size != 2 -> emit(node.startOffset, "Invalid package levels", false)
            names.first() != "ktfx" -> emit(node.startOffset, "Prefix package must be `ktfx`", false)
            names.last() != "coroutines" &&
                names.last() != "layouts" &&
                names.last() != "listeners" &&
                names.last() != "styles" &&
                names.last() != "controlsfx" &&
                names.last() != "jfoenix"
            -> emit(node.startOffset, "See modules.kt for correct suffix packages", false)
        }
    }
})