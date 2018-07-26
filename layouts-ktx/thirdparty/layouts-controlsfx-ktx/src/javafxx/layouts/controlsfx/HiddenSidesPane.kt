@file:Suppress("NOTHING_TO_INLINE")

package javafxx.layouts.controlsfx

import javafx.scene.Node
import javafxx.layouts.LayoutDsl
import javafxx.layouts.LayoutManager
import org.controlsfx.control.HiddenSidesPane

/** Creates a [HiddenSidesPane]. */
fun hiddenSidesPane(
    content: Node? = null,
    top: Node? = null,
    right: Node? = null,
    bottom: Node? = null,
    left: Node? = null,
    init: ((@LayoutDsl HiddenSidesPane).() -> Unit)? = null
): HiddenSidesPane = HiddenSidesPane(content, top, right, bottom, left).also {
    init?.invoke(it)
}

/** Creates a [HiddenSidesPane] and add it to this [LayoutManager]. */
inline fun LayoutManager<Node>.hiddenSidesPane(
    content: Node? = null,
    top: Node? = null,
    right: Node? = null,
    bottom: Node? = null,
    left: Node? = null,
    noinline init: ((@LayoutDsl HiddenSidesPane).() -> Unit)? = null
): HiddenSidesPane = javafxx.layouts.controlsfx.hiddenSidesPane(content, top, right, bottom, left, init)()

/** Create a styled [HiddenSidesPane]. */
fun styledHiddenSidesPane(
    styleClass: String,
    content: Node? = null,
    top: Node? = null,
    right: Node? = null,
    bottom: Node? = null,
    left: Node? = null,
    init: ((@LayoutDsl HiddenSidesPane).() -> Unit)? = null
): HiddenSidesPane = HiddenSidesPane(content, top, right, bottom, left).also {
    it.styleClass += styleClass
    init?.invoke(it)
}

/** Creates a styled [HiddenSidesPane] and add it to this [LayoutManager]. */
inline fun LayoutManager<Node>.styledHiddenSidesPane(
    styleClass: String,
    content: Node? = null,
    top: Node? = null,
    right: Node? = null,
    bottom: Node? = null,
    left: Node? = null,
    noinline init: ((@LayoutDsl HiddenSidesPane).() -> Unit)? = null
): HiddenSidesPane =
    javafxx.layouts.controlsfx.styledHiddenSidesPane(styleClass, content, top, right, bottom, left, init)()