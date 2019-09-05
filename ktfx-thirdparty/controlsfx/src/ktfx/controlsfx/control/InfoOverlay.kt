@file:Suppress("PackageDirectoryMismatch")

package ktfx.controlsfx

import javafx.scene.Node
import ktfx.layouts.LayoutDslMarker
import ktfx.layouts.NodeManager
import org.controlsfx.control.InfoOverlay

/** Add a [InfoOverlay] to this manager. */
fun NodeManager.infoOverlay(
    graphic: Node? = null,
    text: String? = null
): InfoOverlay = InfoOverlay(graphic, text).add()

/** Add a [InfoOverlay] with initialization block to this manager. */
inline fun NodeManager.infoOverlay(
    graphic: Node? = null,
    text: String? = null,
    init: (@LayoutDslMarker InfoOverlay).() -> Unit
): InfoOverlay = infoOverlay(graphic, text).apply(init)
