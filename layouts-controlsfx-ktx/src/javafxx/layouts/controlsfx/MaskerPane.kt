@file:Suppress("NOTHING_TO_INLINE")

package javafxx.layouts.controlsfx

import javafx.scene.Node
import javafxx.layouts.LayoutDsl
import javafxx.layouts.LayoutManager
import org.controlsfx.control.MaskerPane

/** Creates a [MaskerPane]. */
fun maskerPane(
    init: ((@LayoutDsl MaskerPane).() -> Unit)? = null
): MaskerPane = MaskerPane().also {
    init?.invoke(it)
}

/** Creates a [MaskerPane] and add it to this [LayoutManager]. */
inline fun LayoutManager<Node>.maskerPane(
    noinline init: ((@LayoutDsl MaskerPane).() -> Unit)? = null
): MaskerPane = javafxx.layouts.controlsfx.maskerPane(init)()

/** Create a styled [MaskerPane]. */
fun styledMaskerPane(
    styleClass: String,
    init: ((@LayoutDsl MaskerPane).() -> Unit)? = null
): MaskerPane = MaskerPane().also {
    it.styleClass += styleClass
    init?.invoke(it)
}

/** Creates a styled [MaskerPane] and add it to this [LayoutManager]. */
inline fun LayoutManager<Node>.styledMaskerPane(
    styleClass: String,
    noinline init: ((@LayoutDsl MaskerPane).() -> Unit)? = null
): MaskerPane = javafxx.layouts.controlsfx.styledMaskerPane(styleClass, init)()