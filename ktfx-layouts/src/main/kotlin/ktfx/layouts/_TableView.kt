@file:JvmMultifileClass
@file:JvmName("KtfxLayoutsKt")
@file:OptIn(ExperimentalContracts::class)
@file:Suppress("ktlint")

package ktfx.layouts

import javafx.collections.FXCollections.observableArrayList
import javafx.collections.ObservableList
import javafx.scene.control.TableView
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind.EXACTLY_ONCE
import kotlin.contracts.contract
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName

/**
 * Add a [TableView] to this container.
 *
 * @return the control added.
 */
public fun <S> NodeContainer.tableView(items: ObservableList<S> = observableArrayList()):
        TableView<S> = tableView(items = items) { }

/**
 * Create a [TableView] with configuration block.
 * @param configuration the configuration block.
 *
 * @return the control created.
 */
public inline fun <S> tableView(items: ObservableList<S> = observableArrayList(),
        configuration: (@KtfxLayoutDslMarker TableView<S>).() -> Unit): TableView<S> {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = TableView<S>(items)
    child.configuration()
    return child
}

/**
 * Add a [TableView] with configuration block to this container.
 * @param configuration the configuration block.
 *
 * @return the control added.
 */
public inline fun <S> NodeContainer.tableView(items: ObservableList<S> = observableArrayList(),
        configuration: (@KtfxLayoutDslMarker TableView<S>).() -> Unit): TableView<S> {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = TableView<S>(items)
    child.configuration()
    return addChild(child)
}

/**
 * Create a styled [TableView].
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 *
 * @return the styled control created.
 */
public fun <S> styledTableView(
    items: ObservableList<S> = observableArrayList(),
    vararg styleClass: String,
    id: String? = null,
): TableView<S> = styledTableView(items = items, styleClass = *styleClass, id = id) { }

/**
 * Add a styled [TableView] to this container.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 *
 * @return the styled control added.
 */
public fun <S> NodeContainer.styledTableView(
    items: ObservableList<S> = observableArrayList(),
    vararg styleClass: String,
    id: String? = null,
): TableView<S> = styledTableView(items = items, styleClass = *styleClass, id = id) { }

/**
 * Create a styled [TableView] with configuration block.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 *
 * @return the styled control created.
 */
public inline fun <S> styledTableView(
    items: ObservableList<S> = observableArrayList(),
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker TableView<S>).() -> Unit,
): TableView<S> {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = TableView<S>(items)
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return child
}

/**
 * Add a styled [TableView] with configuration block to this container.
 * @param styleClass the CSS style class.
 * @param id the CSS id.
 * @param configuration the configuration block.
 *
 * @return the styled control added.
 */
public inline fun <S> NodeContainer.styledTableView(
    items: ObservableList<S> = observableArrayList(),
    vararg styleClass: String,
    id: String? = null,
    configuration: (@KtfxLayoutDslMarker TableView<S>).() -> Unit,
): TableView<S> {
    contract { callsInPlace(configuration, EXACTLY_ONCE) }
    val child = TableView<S>(items)
    child.styleClass += styleClass
    child.id = id
    child.configuration()
    return addChild(child)
}
