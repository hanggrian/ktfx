@file:Suppress("NOTHING_TO_INLINE")

package ktfx.layouts.controlsfx

import javafx.scene.Node
import ktfx.layouts.LayoutDsl
import ktfx.layouts.LayoutManager
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
): StatusBar = ktfx.layouts.controlsfx.statusBar(init)()

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
): StatusBar = ktfx.layouts.controlsfx.styledStatusBar(styleClass, init)()