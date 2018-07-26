@file:Suppress("NOTHING_TO_INLINE")

package javafxx.layouts.controlsfx

import javafx.scene.Node
import javafxx.layouts.LayoutDsl
import javafxx.layouts.LayoutManager
import org.controlsfx.control.StatusBar

/** Creates a [StatusBar]. */
fun statusBar(
    init: ((@LayoutDsl StatusBar).() -> Unit)? = null
): StatusBar = StatusBar().also {
    init?.invoke(it)
}

/** Creates a [StatusBar] and add it to this [LayoutManager]. */
inline fun LayoutManager<Node>.statusBar(
    noinline init: ((@LayoutDsl StatusBar).() -> Unit)? = null
): StatusBar = javafxx.layouts.controlsfx.statusBar(init)()

/** Create a styled [StatusBar]. */
fun styledStatusBar(
    styleClass: String,
    init: ((@LayoutDsl StatusBar).() -> Unit)? = null
): StatusBar = StatusBar().also {
    it.styleClass += styleClass
    init?.invoke(it)
}

/** Creates a styled [StatusBar] and add it to this [LayoutManager]. */
inline fun LayoutManager<Node>.styledStatusBar(
    styleClass: String,
    noinline init: ((@LayoutDsl StatusBar).() -> Unit)? = null
): StatusBar = javafxx.layouts.controlsfx.styledStatusBar(styleClass, init)()