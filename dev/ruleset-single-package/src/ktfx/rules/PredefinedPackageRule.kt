package ktfx.rules

import com.hendraanggrian.ktfx.rules.BuildConfig
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
        if (name != convert(BuildConfig.ARTIFACT_COROUTINES) &&
            name != convert(BuildConfig.ARTIFACT_LAYOUTS) &&
            name != convert(BuildConfig.ARTIFACT_LISTENERS) &&
            name != convert(BuildConfig.ARTIFACT_THIRDPARTY_CONTROLSFX) &&
            name != convert(BuildConfig.ARTIFACT_THIRDPARTY_JFOENIX)
        ) {
            emit(node.startOffset, "See artifacts.kt for pre-defined packages", false)
        }
    }
})