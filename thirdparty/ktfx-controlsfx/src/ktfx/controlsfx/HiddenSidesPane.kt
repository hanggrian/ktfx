@file:Suppress("NOTHING_TO_INLINE")

package ktfx.controlsfx

import javafx.scene.Node
import ktfx.layouts.LayoutDsl
import ktfx.layouts.LayoutManager
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
): HiddenSidesPane = ktfx.controlsfx.hiddenSidesPane(content, top, right, bottom, left, init)()