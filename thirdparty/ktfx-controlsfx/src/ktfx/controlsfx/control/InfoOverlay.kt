@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

package ktfx.controlsfx

import javafx.scene.Node
import ktfx.NodeManager
import ktfx.annotations.LayoutDsl
import org.controlsfx.control.InfoOverlay

/** Creates a [InfoOverlay]. */
fun infoOverlay(
    graphic: Node? = null,
    text: String? = null,
    init: ((@LayoutDsl InfoOverlay).() -> Unit)? = null
): InfoOverlay = InfoOverlay(graphic, text).also { init?.invoke(it) }

/** Creates a [InfoOverlay] and add it to this manager. */
inline fun NodeManager.infoOverlay(
    graphic: Node? = null,
    text: String? = null,
    noinline init: ((@LayoutDsl InfoOverlay).() -> Unit)? = null
): InfoOverlay = ktfx.controlsfx.infoOverlay(graphic, text, init)()