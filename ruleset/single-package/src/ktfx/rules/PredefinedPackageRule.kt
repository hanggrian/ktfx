package ktfx.rules

import org.jetbrains.kotlin.psi.KtPackageDirective
import org.jetbrains.kotlin.psi.stubs.elements.KtStubElementTypes

class PredefinedPackageRule : Rule("predefined-package", { node, _, emit ->
    if (node.elementType == KtStubElementTypes.PACKAGE_DIRECTIVE) {
        val convert: (String) -> String = {
            when {
                ':' !in it -> it
                else -> it.substringAfter(':')
            }.replace('-', '.')
        }
        val name = node.psi<KtPackageDirective>().qualifiedName
        if (name != convert("ktfx-coroutines") &&
            name != convert("ktfx-layouts") &&
            name != convert("ktfx-listeners") &&
            name != convert("ktfx-controlsfx") &&
            name != convert("ktfx-jfoenix") &&
            name != convert("ktfx-testfx")
        ) {
            emit(node.startOffset, "See artifacts.kt for pre-defined packages", false)
        }
    }
})