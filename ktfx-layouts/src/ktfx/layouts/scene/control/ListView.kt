@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

/* ktlint-disable package-name */
package ktfx.layouts

/* ktlint-enable package-name */

import javafx.collections.FXCollections
import javafx.collections.ObservableList
import javafx.scene.Node
import javafx.scene.control.ListView

/** Creates a [ListView]. */
fun <T> listView(
    items: ObservableList<T> = FXCollections.observableArrayList(),
    init: ((@LayoutDsl ListView<T>).() -> Unit)? = null
): ListView<T> = ListView(items).also { init?.invoke(it) }

/** Creates a [ListView] and add it to this [LayoutManager]. */
inline fun <T> LayoutManager<Node>.listView(
    items: ObservableList<T> = FXCollections.observableArrayList(),
    noinline init: ((@LayoutDsl ListView<T>).() -> Unit)? = null
): ListView<T> = ktfx.layouts.listView(items, init)()