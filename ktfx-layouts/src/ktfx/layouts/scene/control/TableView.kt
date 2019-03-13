@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.collections.ObservableList
import javafx.scene.control.TableView
import ktfx.collections.observableListOf

/** Creates a [TableView]. */
fun <S> tableView(
    items: ObservableList<S> = observableListOf(),
    init: ((@LayoutDslMarker TableView<S>).() -> Unit)? = null
): TableView<S> = TableView<S>(items).also { init?.invoke(it) }

/** Creates a [TableView] and add it to this manager. */
inline fun <S> NodeManager.tableView(
    items: ObservableList<S> = observableListOf(),
    noinline init: ((@LayoutDslMarker TableView<S>).() -> Unit)? = null
): TableView<S> = ktfx.layouts.tableView(items, init).add()