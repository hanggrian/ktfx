@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.collections.ObservableList
import javafx.scene.control.ListView
import ktfx.collections.observableListOf

/** Creates a [ListView]. */
fun <T> listView(
    items: ObservableList<T> = observableListOf(),
    init: ((@LayoutDsl ListView<T>).() -> Unit)? = null
): ListView<T> = ListView(items).also { init?.invoke(it) }

/** Creates a [ListView] and add it to this manager. */
inline fun <T> NodeInvokable.listView(
    items: ObservableList<T> = observableListOf(),
    noinline init: ((@LayoutDsl ListView<T>).() -> Unit)? = null
): ListView<T> = ktfx.layouts.listView(items, init)()