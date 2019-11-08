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

/** Create a [InfoOverlay] with initialization block. */
inline fun infoOverlay(
    graphic: Node? = null,
    text: String? = null,
    init: InfoOverlay.() -> Unit
): InfoOverlay {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    return InfoOverlay(graphic, text).apply(init)
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
    init: InfoOverlay.() -> Unit
): InfoOverlay {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    return addNode(InfoOverlay(graphic, text), init)
}
