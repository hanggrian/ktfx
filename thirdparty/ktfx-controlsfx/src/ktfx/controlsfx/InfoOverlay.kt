@file:Suppress("NOTHING_TO_INLINE")

package ktfx.controlsfx

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

/** Create a styled [InfoOverlay]. */
fun styledInfoOverlay(
    styleClass: String,
    graphic: Node? = null,
    text: String? = null,
    init: ((@LayoutDsl InfoOverlay).() -> Unit)? = null
): InfoOverlay = InfoOverlay(graphic, text).also {
    it.styleClass += styleClass
    init?.invoke(it)
}

/** Creates a styled [InfoOverlay] and add it to this [LayoutManager]. */
inline fun LayoutManager<Node>.styledInfoOverlay(
    styleClass: String,
    graphic: Node? = null,
    text: String? = null,
    noinline init: ((@LayoutDsl InfoOverlay).() -> Unit)? = null
): InfoOverlay = ktfx.controlsfx.styledInfoOverlay(styleClass, graphic, text, init)()