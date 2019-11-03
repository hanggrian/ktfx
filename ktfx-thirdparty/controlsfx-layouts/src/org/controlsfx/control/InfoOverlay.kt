@file:JvmMultifileClass
@file:JvmName("ControlsFxLayoutsKt")

package ktfx.thirdparty.controlsfx.layouts

import javafx.scene.Node
import ktfx.layouts.LayoutDslMarker
import ktfx.layouts.NodeManager
import ktfx.layouts.addNode
import org.controlsfx.control.InfoOverlay

/** Create a [InfoOverlay] with initialization block. */
inline fun infoOverlay(
    graphic: Node? = null,
    text: String? = null,
    init: (@LayoutDslMarker InfoOverlay).() -> Unit
): InfoOverlay = InfoOverlay(graphic, text).apply(init)

/** Add a [InfoOverlay] to this manager. */
fun NodeManager.infoOverlay(
    graphic: Node? = null,
    text: String? = null
): InfoOverlay = addNode(InfoOverlay(graphic, text))

/** Add a [InfoOverlay] with initialization block to this manager. */
inline fun NodeManager.infoOverlay(
    graphic: Node? = null,
    text: String? = null,
    init: (@LayoutDslMarker InfoOverlay).() -> Unit
): InfoOverlay = addNode(InfoOverlay(graphic, text), init)
