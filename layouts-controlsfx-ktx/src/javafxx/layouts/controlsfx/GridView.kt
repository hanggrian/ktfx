@file:Suppress("NOTHING_TO_INLINE")

package javafxx.layouts.controlsfx

import javafx.collections.ObservableList
import javafx.scene.Node
import javafxx.collections.mutableObservableListOf
import javafxx.layouts.LayoutDsl
import javafxx.layouts.LayoutManager
import org.controlsfx.control.GridView

/** Creates a [GridView]. */
fun <T> gridView(
    items: ObservableList<T> = mutableObservableListOf(),
    init: ((@LayoutDsl GridView<T>).() -> Unit)? = null
): GridView<T> = GridView(items).also {
    init?.invoke(it)
}

/** Creates a [GridView] and add it to this [LayoutManager]. */
inline fun <T> LayoutManager<Node>.gridView(
    items: ObservableList<T> = mutableObservableListOf(),
    noinline init: ((@LayoutDsl GridView<T>).() -> Unit)? = null
): GridView<T> = javafxx.layouts.controlsfx.gridView(items, init)()

/** Create a styled [GridView]. */
fun <T> styledGridView(
    styleClass: String,
    items: ObservableList<T> = mutableObservableListOf(),
    init: ((@LayoutDsl GridView<T>).() -> Unit)? = null
): GridView<T> = GridView(items).also {
    it.styleClass += styleClass
    init?.invoke(it)
}

/** Creates a styled [GridView] and add it to this [LayoutManager]. */
inline fun <T> LayoutManager<Node>.styledGridView(
    styleClass: String,
    items: ObservableList<T> = mutableObservableListOf(),
    noinline init: ((@LayoutDsl GridView<T>).() -> Unit)? = null
): GridView<T> = javafxx.layouts.controlsfx.styledGridView(styleClass, items, init)()