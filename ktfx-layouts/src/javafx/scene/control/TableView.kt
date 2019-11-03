@file:JvmMultifileClass
@file:JvmName("LayoutsKt")

package ktfx.layouts

import javafx.collections.FXCollections
import javafx.collections.ObservableList
import javafx.scene.control.TableView

/** Create a [TableView] with initialization block. */
inline fun <S> tableView(
    items: ObservableList<S> = FXCollections.observableArrayList(),
    init: (@LayoutDslMarker TableView<S>).() -> Unit
): TableView<S> = TableView(items).apply(init)

/** Add a [TableView] to this manager. */
fun <S> NodeManager.tableView(
    items: ObservableList<S> = FXCollections.observableArrayList()
): TableView<S> = addNode(TableView(items))

/** Add a [TableView] with initialization block to this manager. */
inline fun <S> NodeManager.tableView(
    items: ObservableList<S> = FXCollections.observableArrayList(),
    init: (@LayoutDslMarker TableView<S>).() -> Unit
): TableView<S> = addNode(TableView(items), init)
