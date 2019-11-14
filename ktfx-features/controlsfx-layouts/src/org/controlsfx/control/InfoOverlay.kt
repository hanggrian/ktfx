@file:JvmMultifileClass
@file:JvmName("ControlsFxLayoutsKt")
@file:UseExperimental(ExperimentalContracts::class)

package ktfx.controlsfx.layouts

import javafx.scene.Node
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract
import ktfx.layouts.NodeManager
import ktfx.layouts.addNode
import org.controlsfx.control.InfoOverlay

/**
 * [InfoOverlay] with dynamic-layout dsl support.
 * Invoking dsl will only set its content.
 */
open class KtfxInfoOverlay(graphic: Node?, text: String?) : InfoOverlay(graphic, text), NodeManager {

    final override fun <T : Node> addNode(node: T): T =
        node.also { content = it }
}

/** Create a [InfoOverlay] with initialization block. */
inline fun infoOverlay(
    graphic: Node? = null,
    text: String? = null,
    init: KtfxInfoOverlay.() -> Unit
): InfoOverlay {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    return KtfxInfoOverlay(graphic, text).apply(init)
}

/** Add a [InfoOverlay] to this manager. */
fun NodeManager.infoOverlay(
    graphic: Node? = null,
    text: String? = null
): InfoOverlay = addNode(InfoOverlay(graphic, text))

/** Add a [InfoOverlay] with initialization block to this manager. */
inline fun NodeManager.infoOverlay(
    graphic: Node? = null,
    text: String? = null,
    init: KtfxInfoOverlay.() -> Unit
): InfoOverlay {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    return addNode(KtfxInfoOverlay(graphic, text), init)
}
