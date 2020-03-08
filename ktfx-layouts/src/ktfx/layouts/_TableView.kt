@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:OptIn(ExperimentalContracts::class)

package ktfx.layouts

import javafx.collections.FXCollections.observableArrayList
import javafx.collections.ObservableList
import javafx.scene.control.TableView
import kotlin.String
import kotlin.Unit
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind.EXACTLY_ONCE
import kotlin.contracts.contract
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName
import ktfx.internal.KtfxInternals.newChild

/**
 * Add a [TableView] to this manager.
 */
fun <S> NodeManager.tableView(items: ObservableList<S> = observableArrayList()): TableView<S> =
        tableView(items = items) { }

/**
 * Create a [TableView] with configuration block.
 */
inline fun <S> tableView(
    items: ObservableList<S> = observableArrayList(),
    configuration: (@LayoutDslMarker TableView<S>).() -> Unit
): TableView<S> {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return newChild(TableView<S>(items), configuration = configuration)
}

/**
 * Add a [TableView] with configuration block to this manager.
 */
inline fun <S> NodeManager.tableView(
    items: ObservableList<S> = observableArrayList(),
    configuration: (@LayoutDslMarker TableView<S>).() -> Unit
): TableView<S> {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return addChild(newChild(TableView<S>(items), configuration = configuration))
}

/**
 * Create a styled [TableView].
 */
fun <S> styledTableView(
    items: ObservableList<S> = observableArrayList(),
    vararg styleClass: String,
    id: String? = null
): TableView<S> = styledTableView(items = items, styleClass = *styleClass, id = id) { }

/**
 * Add a styled [TableView] to this manager.
 */
fun <S> NodeManager.styledTableView(
    items: ObservableList<S> = observableArrayList(),
    vararg styleClass: String,
    id: String? = null
): TableView<S> = styledTableView(items = items, styleClass = *styleClass, id = id) { }

/**
 * Create a styled [TableView] with configuration block.
 */
inline fun <S> styledTableView(
    items: ObservableList<S> = observableArrayList(),
    vararg styleClass: String,
    id: String? = null,
    configuration: (@LayoutDslMarker TableView<S>).() -> Unit
): TableView<S> {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return newChild(TableView<S>(items), styleClass = *styleClass, id = id, configuration =
            configuration)
}

/**
 * Add a styled [TableView] with configuration block to this manager.
 */
inline fun <S> NodeManager.styledTableView(
    items: ObservableList<S> = observableArrayList(),
    vararg styleClass: String,
    id: String? = null,
    configuration: (@LayoutDslMarker TableView<S>).() -> Unit
): TableView<S> {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    return addChild(newChild(TableView<S>(items), styleClass = *styleClass, id = id, configuration =
            configuration))
}
