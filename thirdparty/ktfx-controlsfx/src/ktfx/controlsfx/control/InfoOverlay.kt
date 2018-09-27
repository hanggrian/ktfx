@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

/* ktlint-disable package-name */
package ktfx.controlsfx

/* ktlint-enable package-name */

import javafx.scene.Node
import ktfx.layouts.LayoutDsl
import ktfx.layouts.LayoutManager
import org.controlsfx.control.InfoOverlay

/** Creates a [InfoOverlay]. */
fun infoOverlay(
    graphic: Node? = null,
    text: String? = null,
    init: ((@LayoutDsl InfoOverlay).() -> Unit)? = null
): InfoOverlay = InfoOverlay(graphic, text).also {
    init?.invoke(it)
}

/** Creates a [InfoOverlay] and add it to this [LayoutManager]. */
inline fun LayoutManager<Node>.infoOverlay(
    graphic: Node? = null,
    text: String? = null,
    noinline init: ((@LayoutDsl InfoOverlay).() -> Unit)? = null
): InfoOverlay = ktfx.controlsfx.infoOverlay(graphic, text, init)()