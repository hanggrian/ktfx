package ktfx.rules

import org.jetbrains.kotlin.psi.stubs.elements.KtStubElementTypes

/** In future interface and object should also be included. */
class NoInstanceRule : Rule("no-instance", { node, _, emit ->
    val type = node.elementType
    if (type == KtStubElementTypes.CLASS) {
        emit(node.startOffset, "No instance is allowed in this module", false)
    }
})