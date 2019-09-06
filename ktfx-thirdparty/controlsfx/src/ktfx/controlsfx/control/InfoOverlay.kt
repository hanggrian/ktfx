@file:Suppress("PackageDirectoryMismatch")

package ktfx.controlsfx

import javafx.scene.Node
import ktfx.layouts.LayoutDslMarker
import ktfx.layouts.NodeManager
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
): InfoOverlay = addNode(ktfx.controlsfx.infoOverlay(graphic, text) { })

/** Add a [InfoOverlay] with initialization block to this manager. */
inline fun NodeManager.infoOverlay(
    graphic: Node? = null,
    text: String? = null,
    init: (@LayoutDslMarker InfoOverlay).() -> Unit
): InfoOverlay = addNode(ktfx.controlsfx.infoOverlay(graphic, text, init))
