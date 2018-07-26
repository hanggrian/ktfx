@file:Suppress("NOTHING_TO_INLINE")

package javafxx.layouts

import javafx.scene.Node
import javafx.scene.shape.Path
import javafx.scene.shape.PathElement

/** Creates a [Path]. */
fun path(
    vararg elements: PathElement,
    init: ((@LayoutDsl Path).() -> Unit)? = null
): Path = Path(*elements).also {
    init?.invoke(it)
}

/** Creates a [Path] and add it to this [LayoutManager]. */
inline fun LayoutManager<Node>.path(
    vararg elements: PathElement,
    noinline init: ((@LayoutDsl Path).() -> Unit)? = null
): Path = javafxx.layouts.path(*elements, init = init)()

/** Create a styled [Path]. */
fun styledPath(
    styleClass: String,
    vararg elements: PathElement,
    init: ((@LayoutDsl Path).() -> Unit)? = null
): Path = Path(*elements).also {
    it.styleClass += styleClass
    init?.invoke(it)
}

/** Creates a styled [Path] and add it to this [LayoutManager]. */
inline fun LayoutManager<Node>.styledPath(
    styleClass: String,
    vararg elements: PathElement,
    noinline init: ((@LayoutDsl Path).() -> Unit)? = null
): Path = javafxx.layouts.styledPath(styleClass, *elements, init = init)()