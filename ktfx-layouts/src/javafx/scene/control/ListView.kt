@file:JvmMultifileClass
@file:JvmName("LayoutsKt")

package ktfx.layouts

import javafx.collections.FXCollections
import javafx.collections.ObservableList
import javafx.scene.control.ListView

/** Create a [ListView] with initialization block. */
inline fun <T> listView(
    items: ObservableList<T> = FXCollections.observableArrayList(),
    init: (@LayoutDslMarker ListView<T>).() -> Unit
): ListView<T> = ListView(items).apply(init)

/** Add a [ListView] to this manager. */
fun <T> NodeManager.listView(
    items: ObservableList<T> = FXCollections.observableArrayList()
): ListView<T> = addNode(ListView(items))

/** Add a [ListView] with initialization block to this manager. */
inline fun <T> NodeManager.listView(
    items: ObservableList<T> = FXCollections.observableArrayList(),
    init: (@LayoutDslMarker ListView<T>).() -> Unit
): ListView<T> = addNode(ListView(items), init)
