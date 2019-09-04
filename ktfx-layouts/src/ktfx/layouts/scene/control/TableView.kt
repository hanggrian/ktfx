@file:Suppress("PackageDirectoryMismatch")

package ktfx.layouts

import javafx.collections.ObservableList
import javafx.scene.control.TableView
import ktfx.collections.observableListOf

/** Add a [TableView] to this manager. */
fun <S> NodeManager.tableView(
    items: ObservableList<S> = observableListOf()
): TableView<S> = TableView(items).add()

/** Add a [TableView] with initialization block to this manager. */
inline fun <S> NodeManager.tableView(
    items: ObservableList<S> = observableListOf(),
    init: (@LayoutDslMarker TableView<S>).() -> Unit
): TableView<S> = tableView(items).apply(init)
