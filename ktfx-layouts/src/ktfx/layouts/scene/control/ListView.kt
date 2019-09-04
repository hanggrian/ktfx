@file:Suppress("PackageDirectoryMismatch")

package ktfx.layouts

import javafx.collections.ObservableList
import javafx.scene.control.ListView
import ktfx.collections.observableListOf

/** Add a [ListView] to this manager. */
fun <T> NodeManager.listView(
    items: ObservableList<T> = observableListOf()
): ListView<T> = ListView(items).add()

/** Add a [ListView] with initialization block to this manager. */
inline fun <T> NodeManager.listView(
    items: ObservableList<T> = observableListOf(),
    init: (@LayoutDslMarker ListView<T>).() -> Unit
): ListView<T> = listView(items).apply(init)
