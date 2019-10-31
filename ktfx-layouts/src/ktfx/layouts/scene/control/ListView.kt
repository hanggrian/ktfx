@file:Suppress("PackageDirectoryMismatch")

package ktfx.layouts

import javafx.collections.ObservableList
import javafx.scene.control.ListView
import ktfx.collections.observableListOf

/** Create a [ListView] with initialization block. */
inline fun <T> listView(
    items: ObservableList<T> = observableListOf(),
    init: (@LayoutDslMarker ListView<T>).() -> Unit
): ListView<T> = ListView(items).apply(init)

/** Add a [ListView] to this manager. */
fun <T> NodeManager.listView(
    items: ObservableList<T> = observableListOf()
): ListView<T> = addNode(ListView(items))

/** Add a [ListView] with initialization block to this manager. */
inline fun <T> NodeManager.listView(
    items: ObservableList<T> = observableListOf(),
    init: (@LayoutDslMarker ListView<T>).() -> Unit
): ListView<T> = addNode(ListView(items), init)
