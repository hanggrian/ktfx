@file:Suppress("NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.collections.ObservableList
import javafx.scene.Node
import javafx.scene.control.ListView
import ktfx.collections.mutableObservableListOf

/** Creates a [ListView]. */
fun <T> listView(
    items: ObservableList<T> = mutableObservableListOf(),
    init: ((@LayoutDsl ListView<T>).() -> Unit)? = null
): ListView<T> = ListView(items).also {
    init?.invoke(it)
}

/** Creates a [ListView] and add it to this [LayoutManager]. */
inline fun <T> LayoutManager<Node>.listView(
    items: ObservableList<T> = mutableObservableListOf(),
    noinline init: ((@LayoutDsl ListView<T>).() -> Unit)? = null
): ListView<T> = ktfx.layouts.listView(items, init).add()

/** Create a styled [ListView]. */
fun <T> styledListView(
    styleClass: String,
    items: ObservableList<T> = mutableObservableListOf(),
    init: ((@LayoutDsl ListView<T>).() -> Unit)? = null
): ListView<T> = ListView(items).also {
    it.styleClass += styleClass
    init?.invoke(it)
}

/** Creates a styled [ListView] and add it to this [LayoutManager]. */
inline fun <T> LayoutManager<Node>.styledListView(
    styleClass: String,
    items: ObservableList<T> = mutableObservableListOf(),
    noinline init: ((@LayoutDsl ListView<T>).() -> Unit)? = null
): ListView<T> = ktfx.layouts.styledListView(styleClass, items, init).add()