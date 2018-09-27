@file:Suppress("NOTHING_TO_INLINE")

package ktfx.jfoenix

import com.jfoenix.controls.JFXListView
import javafx.scene.Node
import ktfx.layouts.LayoutDsl
import ktfx.layouts.LayoutManager

/** Creates a [JFXListView]. */
fun <T> jfxListView(
    init: ((@LayoutDsl JFXListView<T>).() -> Unit)? = null
): JFXListView<T> = JFXListView<T>().also {
    init?.invoke(it)
}

/** Creates a [JFXListView] and add it to this [LayoutManager]. */
inline fun <T> LayoutManager<Node>.jfxListView(
    noinline init: ((@LayoutDsl JFXListView<T>).() -> Unit)? = null
): JFXListView<T> = ktfx.jfoenix.jfxListView(init)()