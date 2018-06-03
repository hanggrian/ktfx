@file:Suppress("NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.layout.Region

/** Creates a [Region]. */
fun region(
    init: ((@LayoutDsl Region).() -> Unit)? = null
): Region = Region().also {
    init?.invoke(it)
}

/** Creates a [Region] and add it to this [LayoutManager]. */
inline fun LayoutManager<Node>.region(
    noinline init: ((@LayoutDsl Region).() -> Unit)? = null
): Region = ktfx.layouts.region(init)()

/** Create a styled [Region]. */
fun styledRegion(
    styleClass: String,
    init: ((@LayoutDsl Region).() -> Unit)? = null
): Region = Region().also {
    it.styleClass += styleClass
    init?.invoke(it)
}

/** Creates a styled [Region] and add it to this [LayoutManager]. */
inline fun LayoutManager<Node>.styledRegion(
    styleClass: String,
    noinline init: ((@LayoutDsl Region).() -> Unit)? = null
): Region = ktfx.layouts.styledRegion(styleClass, init)()