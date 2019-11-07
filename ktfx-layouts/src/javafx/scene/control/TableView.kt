@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:UseExperimental(ExperimentalContracts::class)

package ktfx.layouts

import javafx.collections.FXCollections
import javafx.collections.ObservableList
import javafx.scene.control.TableView
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

/** Create a [TableView] with initialization block. */
inline fun <S> tableView(
    items: ObservableList<S> = FXCollections.observableArrayList(),
    init: (@LayoutDslMarker TableView<S>).() -> Unit
): TableView<S> {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    return TableView(items).apply(init)
}
/** Add a [TableView] to this manager. */
fun <S> NodeManager.tableView(
    items: ObservableList<S> = FXCollections.observableArrayList()
): TableView<S> = addNode(TableView(items))

/** Add a [TableView] with initialization block to this manager. */
inline fun <S> NodeManager.tableView(
    items: ObservableList<S> = FXCollections.observableArrayList(),
    init: (@LayoutDslMarker TableView<S>).() -> Unit
): TableView<S> {
    contract { callsInPlace(init, InvocationKind.EXACTLY_ONCE) }
    return addNode(TableView(items), init)
}
