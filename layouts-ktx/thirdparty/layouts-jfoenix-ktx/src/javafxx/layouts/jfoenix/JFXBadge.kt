@file:Suppress("NOTHING_TO_INLINE")

package javafxx.layouts.jfoenix

import com.jfoenix.controls.JFXBadge
import javafx.geometry.Pos
import javafx.geometry.Pos.TOP_RIGHT
import javafx.scene.Node
import javafxx.layouts.LayoutDsl
import javafxx.layouts.LayoutManager

/** Creates a [JFXBadge]. */
fun jfxBadge(
    control: Node? = null,
    pos: Pos = TOP_RIGHT,
    init: ((@LayoutDsl JFXBadge).() -> Unit)? = null
): JFXBadge = JFXBadge(control, pos).also {
    init?.invoke(it)
}

/** Creates a [JFXBadge] and add it to this [LayoutManager]. */
inline fun LayoutManager<Node>.jfxBadge(
    control: Node? = null,
    pos: Pos = TOP_RIGHT,
    noinline init: ((@LayoutDsl JFXBadge).() -> Unit)? = null
): JFXBadge = javafxx.layouts.jfoenix.jfxBadge(control, pos, init)()

/** Create a styled [JFXBadge]. */
fun styledJFXBadge(
    styleClass: String,
    control: Node? = null,
    pos: Pos = TOP_RIGHT,
    init: ((@LayoutDsl JFXBadge).() -> Unit)? = null
): JFXBadge = JFXBadge(control, pos).also {
    it.styleClass += styleClass
    init?.invoke(it)
}

/** Creates a styled [JFXBadge] and add it to this [LayoutManager]. */
inline fun LayoutManager<Node>.styledJFXBadge(
    styleClass: String,
    control: Node? = null,
    pos: Pos = TOP_RIGHT,
    noinline init: ((@LayoutDsl JFXBadge).() -> Unit)? = null
): JFXBadge = javafxx.layouts.jfoenix.styledJFXBadge(styleClass, control, pos, init)()