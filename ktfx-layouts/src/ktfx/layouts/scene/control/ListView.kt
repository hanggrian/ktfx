@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.collections.FXCollections
import javafx.collections.ObservableList
import javafx.scene.control.ListView
import ktfx.NodeInvokable
import ktfx.LayoutDsl

/** Creates a [ListView]. */
fun <T> listView(
    items: ObservableList<T> = FXCollections.observableArrayList(),
    init: ((@LayoutDsl ListView<T>).() -> Unit)? = null
): ListView<T> = ListView(items).also { init?.invoke(it) }

/** Creates a [ListView] and add it to this manager. */
inline fun <T> NodeInvokable.listView(
    items: ObservableList<T> = FXCollections.observableArrayList(),
    noinline init: ((@LayoutDsl ListView<T>).() -> Unit)? = null
): ListView<T> = ktfx.layouts.listView(items, init)()