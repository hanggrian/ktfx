@file:Suppress("NOTHING_TO_INLINE")

package ktfx.jfoenix

import com.jfoenix.controls.JFXBadge
import javafx.geometry.Pos
import javafx.geometry.Pos.TOP_RIGHT
import javafx.scene.Node
import ktfx.layouts.LayoutDsl
import ktfx.layouts.LayoutManager

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
): JFXBadge = ktfx.jfoenix.jfxBadge(control, pos, init)()