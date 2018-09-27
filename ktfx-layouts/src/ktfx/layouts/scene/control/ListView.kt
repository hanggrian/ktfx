@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

/* ktlint-disable package-name */
package ktfx.layouts

/* ktlint-enable package-name */

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
): ListView<T> = ktfx.layouts.listView(items, init)()